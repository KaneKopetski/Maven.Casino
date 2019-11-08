package models.people.players;

import io.zipcoder.casino.gamecomponents.Card;
import models.hands.GoFishHand;
import services.PlayerService;
import services.Console;

public class GoFishPlayer extends Player {
    Player goFishPlayer;
    GoFishHand hand = new GoFishHand();
    final Double betAmount;
    PlayerService ps;
    Console console = new Console(System.in, System.out);

    public GoFishPlayer(Player player) {

        this.goFishPlayer = player;
        betAmount = 1.0;
        ps = new PlayerService();
    }


    public Card drawCard() {
        return null;
    }

    public Card giveCard() {
        return null;
    }

}
