package models.people.players;

import Interfaces.GamblingPlayer;
import models.gamecomponents.Dice;
import services.PlayerService;

public class CrapsPlayer implements GamblingPlayer {
    Player crapsPlayer;
    final Double betAmount;
    PlayerService ps;

    public CrapsPlayer(Player player) {
        this.crapsPlayer = player;
        betAmount = 1.0;
        ps = new PlayerService();
    }

    public Double placeBet() {
        Double balanceAfterPlacingBet = ps.depositMoney(betAmount, crapsPlayer);
        return balanceAfterPlacingBet;
    }

    public Integer rollDice(Dice dice){
        return null;
    }


}

