package services;

import models.gamecomponents.Dice;
import models.hands.KlondikeHand;
import java.util.Random;

public class DiceService {

    public Dice createDie() {
        Dice dice = new Dice();
        return dice;
    }

    public Integer rollDice(Dice dice) {
        Random randomNum = new Random();
        Integer valueOfDice = 1 + randomNum.nextInt(6);
        return valueOfDice;
    }

    public Boolean addToHand(Dice dice, Integer valueOfDice, KlondikeHand hand) {

        hand.addToHand(dice,valueOfDice);
        //TODO must finish after Kane does hands
        return false;

    }

}
