package kiosk;

import data.MailAdress;
import data.Party;
import services.ElectoralOrganism;
import services.MailerService;

public class VotingKiosk {

    //TODO

    public VotingKiosk() {
        //TODO
    }

    public void setElectoralOrganism(ElectoralOrganism eO) {
        //TODO
    }
    public void setMailerService(MailerService mService){
        //TODO
    }


    /**a partir de l’opcio de vot seleccionada desencadena el pas d'escrutar el vot emes*/
    public void vote(Party party){
        //TODO
    }

    /**Es comunica amb l’organisme electoral perque signi el vot.
     * Un cop signat envia un correu a l'adreça que es passa com a parametre.
     * Farà us, doncs, dels serveis externs ElectoralOrganism i MailService*/
    public void sendeReceipt(MailAdress address){
        //TODO
    }

}
