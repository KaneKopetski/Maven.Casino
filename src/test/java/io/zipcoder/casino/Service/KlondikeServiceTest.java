package io.zipcoder.casino.Service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import services.KlondikeService;

import java.util.ArrayList;

public class KlondikeServiceTest {

    private KlondikeService klondikeService;
    private ArrayList<Integer> rolls, rolls2, rolls3, rolls4;

    @Before
    public void stuffBeforeTests() {
        klondikeService = new KlondikeService();
        // Random dice
        rolls = klondikeService.rollDiceFiveTimes();
        // Set dice that can do a Full House
        rolls2.add(2);
        rolls2.add(3);
        rolls2.add(3);
        rolls2.add(2);
        rolls2.add(3);
        // Set dice that should fail any test
        rolls3.add(1);
        rolls3.add(2);
        rolls3.add(3);
        rolls3.add(4);
        rolls3.add(5);
        rolls3.add(6);
        // Set dice that can do five of a kind
        rolls4.add(1);
        rolls4.add(1);
        rolls4.add(1);
        rolls4.add(1);
        rolls4.add(1);
        rolls4.add(1);
    }

    @Test
    public void testRollDiceFiveTimes() {

        Integer actual = rolls.size();
        Integer expected = 5;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testOnePair() {

        Integer actual = klondikeService.onePair(rolls2);
        Integer expected = 1;

        Assert.assertEquals(expected, actual);
    }
}
