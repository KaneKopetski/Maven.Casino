package models.gamecomponents;

import models.gamecomponents.Card;
import models.gamecomponents.CardSuit;
import models.gamecomponents.CardValue;
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

