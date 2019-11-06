package models.people.players;

import Interfaces.GamblingPlayer;
import models.gamecomponents.Card;
import models.hands.BlackjackHand;
import services.PlayerService;
import services.PlayerRepo;


public class BlackjackPlayer implements GamblingPlayer {
    Player blackjackPlayer;
    BlackjackHand hand = new BlackjackHand();
    final Double betAmount;
    PlayerService ps;


    public BlackjackPlayer(Player player)
    {
        this.blackjackPlayer = player;
        betAmount = 1.0;
        ps = new PlayerService(blackjackPlayer);
    }

    public Double placeBet() {

        Double balanceAfterPlacingBet = ps.depositMoney( betAmount);
        return balanceAfterPlacingBet;
    }

    public Card hit()
    {
        return null;

    }

    public Boolean stay() {
        return null;

    }


}
