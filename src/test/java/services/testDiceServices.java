package services;

import org.junit.Assert;
import org.junit.Test;
import services.DiceService;




public class testDiceServices {

    @Test
    public void rollDiceTest(){
        DiceService diceService = new DiceService();
        int actual = diceService.rollDice();
        Assert.assertTrue(1 <= actual && actual <= 6);
    }
}
