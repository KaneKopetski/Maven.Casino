package services;

import models.gamecomponents.Dice;
import models.hands.KlondikeHand;
import java.util.Random;

public class DiceService {

    public void createDie() {
        Dice dice = new Dice();
    }

    public Integer rollDice() {
        Random randomNum = new Random();
        return 1 + randomNum.nextInt(6);
    }

    public void addToHand(Dice dice, Integer valueOfDice, KlondikeHand hand) {

        hand.addToHand(dice, valueOfDice);

    }

}
