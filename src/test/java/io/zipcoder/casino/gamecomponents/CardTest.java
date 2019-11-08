package io.zipcoder.casino.gamecomponents;

import io.zipcoder.casino.gamecomponents.Card;
import io.zipcoder.casino.gamecomponents.CardSuit;
import io.zipcoder.casino.gamecomponents.CardValue;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CardTest {

    Card card;

    @Before
    public void init() {
        card = new Card(CardValue.ACE, CardSuit.CLUBS);
        setupObject();
    }

    @Test
    public void setAndGetTest(){
        assertEquals(CardValue.ACE ,card.getCardValue());
        assertEquals(CardSuit.CLUBS, card.getSuit());
    }

    private void setupObject(){
        card.setCardValue(CardValue.ACE);
        card.setSuit(CardSuit.CLUBS);
    }


}