package services;

import models.gamecomponents.Dice;
import models.hands.KlondikeHand;
import java.util.Random;

public class DiceService {

    public Dice createDie() {
        Dice dice = new Dice();
        return dice;
    }

    public Integer rollDice() {
        Random randomNum = new Random();
        return 1 + randomNum.nextInt(6);
    }

    public Boolean addToHand(Dice dice, Integer valueOfDice, KlondikeHand hand) {

//        hand.addToHand(dice,valueOfDice);
//        //TODO must finish after Kane does hands
//        return false;
        return null;

    }

}
