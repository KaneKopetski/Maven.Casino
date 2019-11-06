package models.people.players;

import Interfaces.GamblingPlayer;
import models.gamecomponents.Dice;
import models.hands.KlondikeHand;
import services.DiceService;
import services.PlayerService;

import java.util.ArrayList;

public class KlondikePlayer extends Player implements GamblingPlayer {
     private Player klondikePlayer;
     private final Double betAmount;
     private PlayerService ps;
     private DiceService dice = new DiceService();
     private ArrayList<Integer> rolls;

    public KlondikePlayer(Player player) {
        this.klondikePlayer = player;
        betAmount = 1.0;
        ps = new PlayerService(klondikePlayer);
    }

    public Double placeBet() {
        return PlayerService.depositMoney( betAmount);
    }

    public ArrayList<Integer> rollDiceFiveTimes(){

        rolls = new ArrayList<>();

        for(int i = 0; i < 5; i++) {
            rolls.add(dice.rollDice());
        }
        return this.rolls;
    }


}
