package io.zipcoder.casino.People.Dealer;

import models.people.dealers.KlondikeDealer;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class TestKlondikeDealer {

    private KlondikeDealer klondikeDealer = new KlondikeDealer("Robert", "Frost", Double.MAX_VALUE);

    @Test
    public void testFiveDice() {
        ArrayList<Integer> rolls = klondikeDealer.rollDiceFiveTimes();

        Integer actual = rolls.size();
        Integer expected = 5;

        Assert.assertEquals(expected, actual);
    }
}
