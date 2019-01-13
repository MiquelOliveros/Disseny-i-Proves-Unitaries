package kiosk;

import data.*;
import org.junit.jupiter.api.*;
import services.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class VotingKioskTest {

    private VotingKiosk kiosk;
    private Party party_1 = new Party("PODEMOS");
    private Party party_2 = new Party("PP");
    private Party party_3 = new Party("PSOE");
    private Party party_4 = new Party("CIUTADANS");

    @BeforeEach
        //establim els serveis externs, els partits disponibles i un votant
    void init(){
        Set<Party> parties = new HashSet<>(Arrays.asList(party_1, party_2, party_3, party_4));
        kiosk = new VotingKiosk();
        Nif nif = new Nif("12345678A");
        kiosk.setVoter(nif);
    }

    private static class mailerServiceOutOfService extends impMailerService{
        @Override
        public void send(MailAdress address, DigitalSignature signature) throws NoMailerServiceException {
            throw new NoMailerServiceException();
        }
    }

    private static class electoralOrganismOutOfService extends implElectoralOrganism{
        @Override
        public boolean canVote(Nif nif) throws NoElectoralOrganismException {
            throw new NoElectoralOrganismException();
        }

        @Override
        public void disableVoter(Nif nif) throws NoElectoralOrganismException {
            throw new NoElectoralOrganismException();
        }

        @Override
        public DigitalSignature askForDigitalSignature(Party party) throws NoElectoralOrganismException, NoSignatureException{
            throw new NoElectoralOrganismException();
        }
    }

    private static class voterValidToVote extends implElectoralOrganism{
        @Override
        public boolean canVote (Nif nif){
            return true;
        }
    }

    private static class voterNotValidToVote extends implElectoralOrganism{
        @Override
        public boolean canVote (Nif nif){
            return false;
        }
    }

    private static class mailerServiceIsOperative extends impMailerService{
        int sended = 0;
        @Override
        public void send(MailAdress address, DigitalSignature signature) throws NoMailerServiceException{
            sended +=1;
        }
    }

    private static class electoralOrganismIsOperative extends implElectoralOrganism{
        public boolean voterCanVoteBool = true;
        private ArrayList<Nif> voterCanVote = new ArrayList<>();
        private ArrayList<Nif> voterAlreadyVoted = new ArrayList<>();

        @Override
        public boolean canVote(Nif nif) throws NoElectoralOrganismException {
            if(voterCanVote.contains(nif) && !voterAlreadyVoted.contains(nif))
                return true;
            return false;
        }

        @Override
        public void disableVoter(Nif nif) throws NoElectoralOrganismException {
            voterCanVoteBool = false;
            voterAlreadyVoted.add(nif);
        }

        @Override
        public DigitalSignature askForDigitalSignature(Party party) throws NoElectoralOrganismException, NoSignatureException{
            return new DigitalSignature(party.getName().getBytes());
        }
    }

    @Test
    @DisplayName("VotingKiosk Voter vote")
    void test_vote(){
        ElectoralOrganism organism = new electoralOrganismIsOperative();
        MailerService mailerService = new mailerServiceIsOperative();
        kiosk.setMailerService(mailerService);
        kiosk.setElectoralOrganism(organism);
        Party party = new Party("PP");
        kiosk.vote(party);
    }

    @Test
    @DisplayName("VotingKiosk Voter Can't Vote")
    void test_not_vote(){
        ElectoralOrganism organism = new voterNotValidToVote();
        MailerService mailerService = new mailerServiceOutOfService();
        kiosk.setMailerService(mailerService);
        kiosk.setElectoralOrganism(organism);
        Party party = new Party("PP");
        kiosk.vote(party);
        Assertions.assertThrows(UnsupportedOperationException.class,
                ()->{kiosk.sendeReceipt(new MailAdress("perez@a.com"));});
        Assertions.assertFalse(kiosk.organism.canVote(new Nif("21843H")));
    }

    @Test
    @DisplayName("VotingKiosk is valid to vote")
    void test_voter_vote(){
        ElectoralOrganism organism = new voterValidToVote();
        MailerService mailerService = new mailerServiceIsOperative();
        kiosk.setElectoralOrganism(organism);
        kiosk.setMailerService(mailerService);
        Assertions.assertTrue(kiosk.organism.canVote(new Nif("12345678A")));
    }

    @Test
    @DisplayName("VotingKiosk Electoral Organism out of service")
    void test_EOOutService(){
        ElectoralOrganism organism = new electoralOrganismOutOfService();
        MailerService mailerService = new mailerServiceIsOperative();
        kiosk.setElectoralOrganism(organism);
        kiosk.setMailerService(mailerService);
        Assertions.assertThrows(NoElectoralOrganismException.class,
                ()->{kiosk.vote(new Party("PSOE"));});
    }
}