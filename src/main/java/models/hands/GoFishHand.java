package models.hands;

import models.gamecomponents.Card;
import models.gamecomponents.CardValue;

import java.util.ArrayList;
import java.util.Map;

public class GoFishHand extends Hand {
    ArrayList<Card> hand;
    Map<CardValue, Integer> howManyOfEachValue;

    public GoFishHand() {
        this.hand = new ArrayList<Card>();
    }

    public Boolean checkForSet() {
        for (Card card : hand) {
        }
        return null;
    }

    public Boolean addCardToSet(Card card) {
        return null;
    }

    public String getHand() {
        return hand.toString();
    }

    public Boolean addToHand(Card card) {
        return this.hand.add(card);
    }
}
