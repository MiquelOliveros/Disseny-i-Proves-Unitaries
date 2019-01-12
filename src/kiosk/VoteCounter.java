package kiosk;

/*imports*/
import data.Party;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class VoteCounter {

    //Variables de la classe VoteCounter necessaries pels metodes seguents
    private int nullVote, blankVote;

    public VoteCounter(Set<Party> validParties) {
        //TODO
    }


    /**
     * Incrementa el comptador de vots que actualment te opcio de vot party*
     */
    public void countParty(Party party) {
        //TODO
    }

    /**
     * Incrementa el comptador de vots nuls
     */
    public void countNull() {
        //TODO
    }

    /**
     * Incrementa el comptador de vots en blanc
     */
    public void countBlank() {
        //TODO
    }

    /**
     * fa us dels metodes anteriors per escrutar opcio de vot correctament
     */
    public void scrutinize(Party party) {
        //TODO
    }

    /**
     * retorna el nombre de vots que ha obtingut el partit
     */
    public int getVotesFor(Party party) {
        //TODO
        return 0;
    }

    /**
     * retorna el nombre de vots nuls
     */
    public int getNulls() {
        //TODO
        return 0;
    }

    /**
     * retorna el nombre de vots en blanc
     */
    public int getBlanks() {
        //TODO
        return 0;
    }

    /**
     * retorna el nombre total de vots comptabilitzats
     */
    public int getTotal() {
        //TODO
        return 0;
    }
}
