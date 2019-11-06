package models.people.players;

import Interfaces.GamblingPlayer;
import models.gamecomponents.Dice;
import models.hands.KlondikeHand;
import services.PlayerService;

public class KlondikePlayer extends Player implements GamblingPlayer {
     Player klondikePlayer;
     Dice dice=new Dice();
     int valueOfDice;
     KlondikeHand hand = new KlondikeHand(dice, valueOfDice);
    final Double betAmount;
    PlayerService ps;

    public KlondikePlayer(Player player) {

        this.klondikePlayer = player;
        betAmount = 1.0;
        ps = new PlayerService(klondikePlayer);

    }

    public Double placeBet() {
        Double balanceAfterPlacingBet = ps.depositMoney( betAmount);
        return balanceAfterPlacingBet;
    }

    public Integer rollDice(Dice dice){
        return null;
    }


}
