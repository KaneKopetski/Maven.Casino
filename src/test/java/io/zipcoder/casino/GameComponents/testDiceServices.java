package io.zipcoder.casino.GameComponents;

import models.gamecomponents.Dice;
import models.gamecomponents.GameComponent;
import models.hands.KlondikeHand;
import org.junit.Assert;
import org.junit.Test;
import services.DiceService;




public class testDiceServices {

@Test
        public void rollDiceTest(){
    Dice dice=new Dice();
    DiceService diceService = new DiceService();
    int actual= diceService.rollDice();
   // System.out.println(actual);
}
@Test
    public void addToHandTest(){
    Dice dice = new Dice();
    DiceService diceService = new DiceService();
    int valueOfDice=diceService.rollDice();
    KlondikeHand hand = new KlondikeHand();
     boolean actual =diceService.addToHand(dice , valueOfDice ,hand );
    Assert.assertEquals(true,actual);
}


}
