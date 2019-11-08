package models.people.players;

import services.KlondikeService;
import services.PlayerService;

import java.util.ArrayList;

public class KlondikePlayer extends Player {
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


    public ArrayList<Integer> rollDiceFiveTimes(){
        return klondikeService.rollDiceFiveTimes();
    }


}
