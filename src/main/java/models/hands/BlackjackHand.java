package models.hands;

import models.gamecomponents.Card;
import models.gamecomponents.CardValue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BlackjackHand {
    Integer handValue;
    ArrayList<Card> hand;
    Map<CardValue, Integer> valueMap = new HashMap();

    public BlackjackHand() {
        this.hand = new ArrayList<Card>();
        this.setValueMap();
    }

    public Integer getHandValue() {
        return this.handValue;
    }

    public Integer calculateHandValue() {
        handValue = 0;
        for (Card card : hand) {
            handValue += valueMap.get(card.getCardValue());
        }
        return this.handValue;
    }

    public Integer getcardValue(String cardValue) {
        return valueMap.get(cardValue);
    }

    public String getHand() {
        return hand.toString();
    }

    public Boolean checkForBust() {
        Boolean isBust;
        if (this.handValue > 21 && valueMap.get(CardValue.ACE) == 11) {
            changeAceValue();
            calculateHandValue();
            isBust = false;
        } else if (this.handValue > 21 && valueMap.get(CardValue.ACE) == 1); {
            isBust = true;
        }
        return isBust;
    }

    public Integer changeAceValue() {
    return valueMap.replace(CardValue.ACE, 1);
    }

    public Boolean addToHand(Card card) {
        return this.hand.add(card);
    }

    public void setValueMap() {
        valueMap.put(CardValue.ACE, 11);
        valueMap.put(CardValue.TWO, 2);
        valueMap.put(CardValue.THREE, 3);
        valueMap.put(CardValue.FOUR, 4);
        valueMap.put(CardValue.FIVE, 5);
        valueMap.put(CardValue.SIX, 6);
        valueMap.put(CardValue.SEVEN, 7);
        valueMap.put(CardValue.EIGHT, 8);
        valueMap.put(CardValue.NINE, 9);
        valueMap.put(CardValue.TEN, 10);
        valueMap.put(CardValue.JACK, 10);
        valueMap.put(CardValue.QUEEN, 10);
        valueMap.put(CardValue.KING, 10);
    }
}
