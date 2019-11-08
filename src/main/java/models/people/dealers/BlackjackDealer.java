package models.people.dealers;

import models.gamecomponents.Card;
import models.gamecomponents.DeckOfCards;
import models.hands.BlackjackHand;

import java.util.ArrayList;

public class BlackjackDealer extends Dealer {
    Dealer blackjackDealer;
    BlackjackHand hand = new BlackjackHand();
    private DeckOfCards deckOfCards ;

    public BlackjackDealer(String firstName, String lastName, double balance, DeckOfCards deckOfCards) {
        super(firstName, lastName, balance);
        this.deckOfCards = deckOfCards;
    }

    public Dealer getBlackjackDealer() {

        return blackjackDealer;
    }

    public void setBlackjackDealer(Dealer blackjackDealer) {

        this.blackjackDealer = blackjackDealer;
    }

    public Card hit() {
        return deckOfCards.drawCard();
    }

    public Boolean stay() {
        return null;
    }

    public DeckOfCards shuffle(DeckOfCards deck) {
        return null;
    }


}
