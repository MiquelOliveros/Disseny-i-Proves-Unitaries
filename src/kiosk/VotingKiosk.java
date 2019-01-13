package kiosk;

import data.DigitalSignature;
import data.MailAdress;
import data.Nif;
import data.Party;
import services.ElectoralOrganism;
import services.MailerService;
import services.NoElectoralOrganismException;
import data.NullParameterException;
import services.NoMailerServiceException;

public class VotingKiosk {

    private Party actual;
    private Nif voter;
    MailerService mail;
    ElectoralOrganism organism;
    VoteCounter counter;

    public VotingKiosk() {
    }

    //opcio de vot seleccionada desencadena el pas d'escrutar el vot emes
    public void vote(Party party) throws NullParameterException, NoElectoralOrganismException{
        if(!organism.canVote(voter)) {
            actual = null;
            organism.disableVoter(new Nif(voter.getNif()));
        }else {
            counter.scrutinize(party);
            actual = party;
        }
    }


    //Es comunica amb l’organisme electoral perque signi el vot.
    //Un cop signat envia un correu a l'adreça que es passa com a parametre.
    public void sendeReceipt(MailAdress address) throws NoMailerServiceException{
        DigitalSignature digitalSignature = organism.askForDigitalSignature(actual);
        mail.send(address, digitalSignature);
        actual = null;
        organism.disableVoter(new Nif(voter.getNif()));
    }

    //establir serveis
    public void setElectoralOrganism(ElectoralOrganism eO) {
        organism = eO;
    }
    public void setMailerService(MailerService mService){
        mail = mService;
    }

    //establir votant que exerceix dret a vot i els partits disponibles
    public void setVoter(Nif voter) {
        this.voter = voter;
    }
}
