package models.games;

import models.gamecomponents.Card;
import models.gamecomponents.CardSuit;
import models.gamecomponents.CardValue;
import models.gamecomponents.DeckOfCards;
import models.people.dealers.Dealer;
import models.people.players.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

@Ignore
public class BlackjackGameTest {
    DeckOfCards deckOfCards;
    Player player;
    Dealer dealer;
    BlackjackGame blackjackGame;
    ArrayList <Card> hand = new ArrayList();
    Card card1;
    Card card2;

    @Before
    public void init() {
        deckOfCards = new DeckOfCards();
        player = new Player();
        dealer = new Dealer("John", "Tokhi", 1000.00);
        blackjackGame = new BlackjackGame(player);
        card1 = new Card(CardValue.EIGHT, CardSuit.CLUBS);
        card2 = new Card(CardValue.NINE, CardSuit.DIAMONDS);
        hand.add(card1);
        hand.add(card2);


    }
    @Test
    public void dealCards() {
        blackjackGame.dealCards();
        int expected = 2;
        int actual = blackjackGame.getPlayerHandValue();
    }

    @Test
    public void playerHit() {
    }

    @Test
    public void dealerHit() {
    }

    @Test
    public void dealerTurnLoop() {
    }

    @Test
    public void dealerTurn() {
    }

    @Test
    public void playerStay() {
    }

    @Test
    public void determineWin() {
    }

    @Test
    public void getPlayerHandValueTest() {

        Integer expected = 17;



    }

    @Test
    public void getDealerHandValue() {
    }

    @Test
    public void checkForBlackjackPlayer() {
    }

    @Test
    public void checkForBlackjackDealer() {
    }

    @Test
    public void checkForDealerBust() {
    }

    @Test
    public void checkForPlayerBust() {
    }

    @Test
    public void getMenu() {
    }

    @Test
    public void startGame() {
    }

    @Test
    public void placeBet() {
    }

    @Test
    public void addToBet() {
    }

    @Test
    public void payOut() {
    }

    @Test
    public void testDealerTurn() {
    }

    @Test
    public void determineWin2() {
    }

    @Test
    public void restartGamePrompt() {
    }

    @Test
    public void leaveGame() {
    }

    @Test
    public void promptPlayerToHitOrStay() {
    }

    @Test
    public void testToString() {
    }

    @Test
    public void playGame() {
    }

    @Test
    public void testDealCards() {
    }

    @Test
    public void testPlayerHit() {
    }

    @Test
    public void testDealerHit() {
    }

    @Test
    public void testDealerTurnLoop() {
    }

    @Test
    public void testDealerTurn1() {
    }

    @Test
    public void testPlayerStay() {
    }

    @Test
    public void testDetermineWin() {
    }

    @Test
    public void testGetPlayerHandValue() {
    }

    @Test
    public void testGetDealerHandValue() {
    }

    @Test
    public void testCheckForBlackjackPlayer() {
    }

    @Test
    public void testCheckForBlackjackDealer() {
    }

    @Test
    public void testCheckForDealerBust() {
    }

    @Test
    public void testCheckForPlayerBust() {
    }

    @Test
    public void testGetMenu() {
    }

    @Test
    public void testStartGame() {
    }

    @Test
    public void testPlaceBet() {
    }

    @Test
    public void testAddToBet() {
    }

    @Test
    public void testPayOut() {
    }

    @Test
    public void testDealerTurn2() {
    }

    @Test
    public void testDetermineWin2() {
    }

    @Test
    public void testRestartGamePrompt() {
    }

    @Test
    public void testLeaveGame() {
    }

    @Test
    public void testPromptPlayerToHitOrStay() {
    }

    @Test
    public void testToString1() {
    }

    @Test
    public void testPlayGame() {
    }
}