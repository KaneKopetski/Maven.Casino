package io.zipcoder.casino.People.Person;

import models.people.players.KlondikePlayer;
import models.people.players.Player;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class TestKlondikePlayer {

    private Player player = new Player("BillyJoeBob", 42);
    private KlondikePlayer klondikePlayer = new KlondikePlayer(player);

    @Test
    public void testRollDiceFiveTimes() {
        ArrayList<Integer> rolls = klondikePlayer.rollDiceFiveTimes();

        Integer actual = rolls.size();
        Integer expected = 5;

        Assert.assertEquals(expected, actual);
    }


}
