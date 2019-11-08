package models.people.players;

import Interfaces.GamblingPlayer;
import models.gamecomponents.Dice;
import models.hands.KlondikeHand;
import services.DiceService;
import services.KlondikeService;
import services.PlayerService;

import java.util.ArrayList;

public class KlondikePlayer extends Player implements GamblingPlayer {
     private Player klondikePlayer;
     private final Double betAmount;
     private PlayerService ps;
     private KlondikeService klondikeService = new KlondikeService();
     private PlayerService playerService = new PlayerService();

    public KlondikePlayer(Player player) {
        this.klondikePlayer = player;
        betAmount = 1.0;
        ps = new PlayerService();
    }


   public Double placeBet() {

       //TODO FIX THIS SHIIITTTTTT return playerService.depositMoney(betAmount);
       return null;
    }

    public ArrayList<Integer> rollDiceFiveTimes(){
        return klondikeService.rollDiceFiveTimes();
    }


}
