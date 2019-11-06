package models.people.dealers;

import models.gamecomponents.Card;
import models.gamecomponents.DeckOfCards;
import models.hands.GoFishHand;
import models.people.players.GoFishPlayer;
import models.people.players.Player;


public class GoFishDealer extends Dealer {
    Dealer goFishDealer;
    GoFishHand hand = new GoFishHand();
    private DeckOfCards deckOfCards ;


    public GoFishDealer(String firstName, String lastName, double balance, DeckOfCards deckOfCards) {
        super(firstName, lastName, balance);
        this.deckOfCards = deckOfCards;
    }

    public Integer askForCard(){
        return null;
    }

    public Card drawCard() {

        return deckOfCards.drawCard();
    }

    public Card giveCard() {

        return null;
    }


}
