package services;

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
        rolls2 = new ArrayList<>();
        rolls3 = new ArrayList<>();
        rolls4 = new ArrayList<>();
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
        // Set dice that can do five of a kind
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
        Integer actual2 = klondikeService.onePair(rolls2);
        Integer expected2 = 1;
        Integer actual3 = klondikeService.onePair(rolls3);
        Integer expected3 = 0;
        Integer actual4 = klondikeService.onePair(rolls4);
        Integer expected4 = 1;

        Assert.assertEquals(expected2, actual2);
        Assert.assertEquals(expected3, actual3);
        Assert.assertEquals(expected4, actual4);
    }

    @Test
    public void testTwoPair() {
        Integer actual2 = klondikeService.twoPair(rolls2);
        Integer expected2 = 2;
        Integer actual3 = klondikeService.twoPair(rolls3);
        Integer expected3 = 0;
        Integer actual4 = klondikeService.twoPair(rolls4);
        Integer expected4 = 0;

        Assert.assertEquals(expected2, actual2);
        Assert.assertEquals(expected3, actual3);
        Assert.assertEquals(expected4, actual4);
    }

    @Test
    public void testThreeOfAKind() {
        Integer actual2 = klondikeService.threeOfAKind(rolls2);
        Integer expected2 = 3;
        Integer actual3 = klondikeService.threeOfAKind(rolls3);
        Integer expected3 = 0;
        Integer actual4 = klondikeService.threeOfAKind(rolls4);
        Integer expected4 = 3;

        Assert.assertEquals(expected2, actual2);
        Assert.assertEquals(expected3, actual3);
        Assert.assertEquals(expected4, actual4);
    }

    @Test
    public void testFullHouse() {
        Integer actual2 = klondikeService.fullHouse(rolls2);
        Integer expected2 = 4;
        Integer actual3 = klondikeService.fullHouse(rolls3);
        Integer expected3 = 0;
        Integer actual4 = klondikeService.fullHouse(rolls4);
        Integer expected4 = 0;

        Assert.assertEquals(expected2, actual2);
        Assert.assertEquals(expected3, actual3);
        Assert.assertEquals(expected4, actual4);
    }

    @Test
    public void testFourOfAKind() {
        Integer actual2 = klondikeService.fourOfAKind(rolls2);
        Integer expected2 = 0;
        Integer actual3 = klondikeService.fourOfAKind(rolls3);
        Integer expected3 = 0;
        Integer actual4 = klondikeService.fourOfAKind(rolls4);
        Integer expected4 = 5;

        Assert.assertEquals(expected2, actual2);
        Assert.assertEquals(expected3, actual3);
        Assert.assertEquals(expected4, actual4);
    }

    @Test
    public void testFiveOfAKind() {
        Integer actual2 = klondikeService.fiveOfAKind(rolls2);
        Integer expected2 = 0;
        Integer actual3 = klondikeService.fiveOfAKind(rolls3);
        Integer expected3 = 0;
        Integer actual4 = klondikeService.fiveOfAKind(rolls4);
        Integer expected4 = 6;

        Assert.assertEquals(expected2, actual2);
        Assert.assertEquals(expected3, actual3);
        Assert.assertEquals(expected4, actual4);
    }

    @Test
    public void testBestHand() {
        Integer actual2 = klondikeService.bestHand(rolls2);
        Integer expected2 = 4;
        Integer actual3 = klondikeService.bestHand(rolls3);
        Integer expected3 = 0;
        Integer actual4 = klondikeService.bestHand(rolls4);
        Integer expected4 = 6;

        Assert.assertEquals(expected2, actual2);
        Assert.assertEquals(expected3, actual3);
        Assert.assertEquals(expected4, actual4);
    }

    @Test
    public void testDidPlayerWin() {
        Boolean game1 = klondikeService.didPlayerWin(4, 2);
        Boolean game2 = klondikeService.didPlayerWin(1, 5);
        Boolean game3 = klondikeService.didPlayerWin(3, 3);

        Assert.assertTrue(game1);
        Assert.assertFalse(game2);
        Assert.assertFalse(game3);
    }
}
