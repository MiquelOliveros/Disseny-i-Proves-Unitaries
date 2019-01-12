package kiosk;
import data.Party;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class VoteCounter {

    //Variables de la classe VoteCounter necessaries pels metodes seguents

    private int nullVote, blankVote, totalVots;
    private HashMap<Party,Integer> hashVot;
    private ArrayList<Party> arrayNames;

    public VoteCounter(Set<Party> validParties) {
        arrayNames = new ArrayList<>();
        arrayNames.addAll(validParties);
        hashVot = new HashMap<>();
    }


    //Incrementa el comptador de vots que actualment te opcio de vot party
    public void countParty(Party party) {
        if(arrayNames.contains(party)) {
            if (!hashVot.containsKey(party)) {
                hashVot.put(party, 1);
            }else {
                hashVot.put(party, hashVot.get(party) + 1);
            }
        }
        totalVots+=1;
    }

    //Incrementa el comptador de vots nuls
    public void countNull() {
        this.nullVote += 1;
        this.totalVots += 1;
    }

    //Incrementa el comptador de vots en blanc
    public void countBlank() {
        this.blankVote += 1;
        this.totalVots += 1;
    }

    //fa us dels metodes anteriors per escrutar opcio de vot correctament
    public void scrutinize(Party party) {
        if (party.getName().equals("")) {
            countBlank();
        } else if (party.getName().equals("null")){
            countNull();
        }else{
            countParty(party);
        }
    }

    //GETTERS

    //retorna el nombre de vots que ha obtingut el partit
    public int getVotesFor(Party party) {
        if(!hashVot.containsKey(party))
            return 0;
        return hashVot.get(party);
    }

    //retorna el nombre de vots nuls
    public int getNulls() {
        return nullVote;
    }

    //retorna el nombre de vots en blanc
    public int getBlanks() {
        return blankVote;
    }

    //retorna el nombre total de vots comptabilitzats
    public int getTotal() {
        return totalVots;
    }
}
