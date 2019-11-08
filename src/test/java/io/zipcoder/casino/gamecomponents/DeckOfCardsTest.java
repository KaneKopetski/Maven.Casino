package io.zipcoder.casino.gamecomponents;

import io.zipcoder.casino.gamecomponents.Card;
import io.zipcoder.casino.gamecomponents.CardSuit;
import io.zipcoder.casino.gamecomponents.CardValue;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeckOfCardsTest {
    @Test
    public void DeckOfCardsTest() {
        CardSuit[] suits = CardSuit.values();
        CardValue[] values = CardValue.values();
        Card card = new Card(CardValue.ACE, CardSuit.CLUBS);
        assertEquals(CardValue.ACE, card.getCardValue());
        //assertEquals(suits, card.getSuit());

    }
}

