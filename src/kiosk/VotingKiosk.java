package kiosk;

import data.DigitalSignature;
import data.MailAdress;
import data.Nif;
import data.Party;
import services.ElectoralOrganism;
import services.MailerService;
import Exception.NoElectoralOrganismException;
import Exception.NullParameterException;
import Exception.NoMailerServiceException;

public class VotingKiosk {

    private Party actual;
    private Nif voter;

    MailerService mail;
    ElectoralOrganism organism;
    VoteCounter counter;

    public VotingKiosk() {

    }

    public void setElectoralOrganism(ElectoralOrganism eO) {
        organism = eO;
    }
    public void setMailerService(MailerService mService){
        mail = mService;
    }


    /**a partir de l’opcio de vot seleccionada desencadena el pas d'escrutar el vot emes*/
    public void vote(Party party) throws NullParameterException, NoElectoralOrganismException{
        if(!organism.canVote(voter)) {
            finishVotation();
        } else{
            counter.scrutinize(party);
            actual = party;
        }
    }

    public void finishVotation() {
        actual = null;
        organism.disableVoter(new Nif(voter.getNif()));
    }

    /**Es comunica amb l’organisme electoral perque signi el vot.
     * Un cop signat envia un correu a l'adreça que es passa com a parametre.
     * Farà us, doncs, dels serveis externs ElectoralOrganism i MailService*/
    public void sendeReceipt(MailAdress address) throws NoMailerServiceException{
        DigitalSignature digitalSignature = organism.askForDigitalSignature(actual);
        mail.send(address, digitalSignature);
        finishVotation();
    }

    public void setCounter(VoteCounter count){
        counter = count;
    }

    public void setVoter(Nif nif){
        voter = nif;
    }

    public Nif getVoter(){
        return voter;
    }

}
