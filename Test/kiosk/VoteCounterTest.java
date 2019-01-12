package kiosk;

import data.Party;
import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import Exception.NullParameterException;

import static org.junit.jupiter.api.Assertions.*;


class VoteCounterTest {

    private Set<Party> possiblesVots;
    private VoteCounter count;
    private Party party = new Party("PSOE");
    private Party party1 = new Party("PP");
    private Party party2 = new Party("CS");
    private Party party3 = new Party("PODEMOS");

    @BeforeEach
    public void initTest(){
        possiblesVots = new HashSet<>(Arrays.asList(party, party1, party2, party3));

        count = new VoteCounter(possiblesVots);
    }

    @Test
    @DisplayName("VoteCounter correct scrutinize with no votes")
    void Test_Scrutinize() throws NullParameterException{
        Assertions.assertEquals(0, count.getBlanks());
        Assertions.assertEquals(0, count.getNulls());
        Assertions.assertEquals(0, count.getVotesFor(new Party("PSOE")));
    }

    @Test
    @DisplayName("VoteCounter correct scrutinize")
    void Test_Scrutinize_Votes() throws NullParameterException{
        count.scrutinize(new Party("null"));
        count.scrutinize(new Party("null"));
        count.scrutinize(new Party(""));
        count.scrutinize(new Party(""));
        count.scrutinize(new Party("PSOE"));
        count.scrutinize(new Party("PSOE"));
        count.scrutinize(new Party("PSOE"));
        count.scrutinize(new Party("PP"));
        count.scrutinize(new Party("PSOE"));

        Assertions.assertEquals(4, count.getVotesFor(new Party("PSOE")));
        Assertions.assertEquals(1, count.getVotesFor(new Party("PP")));
        Assertions.assertEquals(2, count.getBlanks());
        Assertions.assertEquals(2, count.getNulls());
        Assertions.assertEquals(9, count.getTotal());
    }


}