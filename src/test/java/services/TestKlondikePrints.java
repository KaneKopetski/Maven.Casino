package services;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class TestKlondikePrints {

    private KlondikePrints klondikePrints = new KlondikePrints();

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
    public void testAskInstructions() {
        Integer test = klondikePrints.askInstructions().length();
        System.out.println(klondikePrints.askInstructions());
        Assert.assertNotEquals(0, (int) test);
    }

    @Test
    public void testDealersRolls() {
        Integer test = klondikePrints.dealerRolls().length();
        System.out.println(klondikePrints.dealerRolls());
        Assert.assertNotEquals(0, (int) test);
    }

    @Test
    public void testPlayerRolls() {
        Integer test = klondikePrints.playerRolls().length();
        System.out.println(klondikePrints.playerRolls());
        Assert.assertNotEquals(0, (int) test);
    }

    @Test
    public void testAsksBetAmount() {
        Integer test = klondikePrints.asksBetAmount().length();
        System.out.println(klondikePrints.asksBetAmount());
        Assert.assertNotEquals(0, (int) test);
    }

    @Test
    public void testWin() {
        Integer test = klondikePrints.win().length();
        System.out.println(klondikePrints.win());
        Assert.assertNotEquals(0, (int) test);
    }

    @Test
    public void testLose() {
        Integer test = klondikePrints.lose().length();
        System.out.println(klondikePrints.lose());
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
