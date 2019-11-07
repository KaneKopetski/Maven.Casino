package io.zipcoder.casino.Service;

import org.junit.Assert;
import org.junit.Test;
import services.KlondikePrints;

import java.util.ArrayList;

public class TestKlondikePrints {

    KlondikePrints klondikePrints = new KlondikePrints();

    @Test
    public void testKlondikeWelcome() {
        Integer test = klondikePrints.klondikeWelcome().length();
        Assert.assertNotEquals(0, (int) test);
    }

    @Test
    public void testDisplayInstructions() {
        Integer test = klondikePrints.displayInstructions().length();
        Assert.assertNotEquals(0, (int) test);
    }

    @Test
    public void testPrintDice() {
        ArrayList<Integer> rolls = new ArrayList<>();
        rolls.add(1);
        rolls.add(2);
        rolls.add(3);
        rolls.add(4);
        rolls.add(5);
        ArrayList<String> test = klondikePrints.printDice(rolls);
        System.out.println(test);
        Integer actual = test.size();
        Integer expected = 5;

        Assert.assertEquals(expected, actual);
    }
}
