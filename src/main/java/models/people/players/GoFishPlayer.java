package models.people.players;

import models.gamecomponents.Card;
import models.hands.GoFishHand;
import services.PlayerService;

public class GoFishPlayer extends Player {
    Player goFishPlayer;
    GoFishHand hand = new GoFishHand();
    final Double betAmount;
    PlayerService ps;

    public GoFishPlayer(Player player) {

        this.goFishPlayer = player;
        betAmount = 1.0;
        ps = new PlayerService(goFishPlayer);
    }

    public Integer askForCard(){
        return null;
    }

    public Card drawCard() {
        return null;
    }

    public Card giveCard() {
        return null;
    }

}
