package models.people.dealers;

import services.DiceService;
import services.KlondikeService;

import java.util.ArrayList;

public class KlondikeDealer extends Dealer {

    private KlondikeService klondikeService = new KlondikeService();
    private ArrayList<Integer> rolls;


    public KlondikeDealer(String firstName, String lastName, Double balance) {
        super("Seams", "Shaydee", Double.MAX_VALUE);
    }

    public ArrayList<Integer> rollDiceFiveTimes(){
        return klondikeService.rollDiceFiveTimes();
    }





}
