package services;

import io.zipcoder.casino.gamecomponents.Dice;

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

}
