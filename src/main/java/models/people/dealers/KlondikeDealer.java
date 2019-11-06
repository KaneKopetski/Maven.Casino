package models.people.dealers;

import services.DiceService;

import java.util.ArrayList;

public class KlondikeDealer extends Dealer {

    private DiceService dice = new DiceService();
    private ArrayList<Integer> rolls;


    public KlondikeDealer(String firstName, String lastName, Double balance) {
        super("Seams", "Shaydee", Double.MAX_VALUE);
    }

    public ArrayList<Integer> rollDiceFiveTimes(){

        rolls = new ArrayList<>();

        for(int i = 0; i < 5; i++) {
            rolls.add(dice.rollDice());
        }
        return rolls;
    }





}
