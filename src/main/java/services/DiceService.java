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
        return 1 + randomNum.nextInt(6);
    }

}
