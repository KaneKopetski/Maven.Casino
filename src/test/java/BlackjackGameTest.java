import models.gamecomponents.Card;
import models.games.BlackjackGame;
import models.people.players.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class BlackjackGameTest {
    BlackjackGame blackjackGame;
    Player player;

    @Before
    public void blackJackTest() {
        Player player = new Player();
        BlackjackGame blackjackGame = new BlackjackGame(player);
        this.blackjackGame = blackjackGame;
        this.player = player;
    }


    @Test
    public void BlackjackGameTest() {
        Player actual = blackjackGame.getPlayer();
        Player expected = player;
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void dealCardsTest() {
        String expected = "HEARTS TWO HEARTS THREE ";
        blackjackGame.dealCards();
        StringBuilder sb = new StringBuilder();
        for (Card card : blackjackGame.getPlayerHand()) {
            sb.append("" + card.getSuit() + " " + card.getCardValue() + " ");
        }
        String actual = sb.toString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void printBJInstructionsTest() {
        String expected = "\nTHE BASIC RULES WHEN PLAYING BLACKJACK:\n\n" +
                "1. Blackjack starts with player making bets.\n" +
                "2. Dealer deals 2 cards to the player and two to himself (1 card face up, the other face down).\n" +
                "3. Blackjack card values: All cards count their face value in blackjack. Picture cards count as 10 and the ace count as 1.\n" +
                "   Card suits have no meaning in blackjack. The total of any hand is the sum of the card values in the hand\n" +
                "4. Players must decide whether to stand, hit, surrender, double down, or split.\n" +
                "5. The dealer acts last and must hit on 16 or less and stand on 17 through 21.\n" +
                "6. Players win when their hand totals higher than dealer’s hand, or they have 21 or less when the dealer busts (i.e., exceeds 21).\n\n";
        String actual = blackjackGame.printBJInstructions();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void playerHitTest() {
        String expected = "HEARTS TWO";
        Card card = blackjackGame.playerHit();
        StringBuilder sb = new StringBuilder();
        sb.append("" + card.getSuit() + " " + card.getCardValue());

        String actual = sb.toString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void dealerHitTest() {
        String expected = "HEARTS TWO";
        Card card = blackjackGame.dealerHit();
        StringBuilder sb = new StringBuilder();
        sb.append("" + card.getSuit() + " " + card.getCardValue());

        String actual = sb.toString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void printDealerHits() {
        Card card = blackjackGame.dealerHit();
        String expected = "Dealer hits: " + card.getCardValue() + "\n";
        String actual = blackjackGame.printDealerHits(card);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void dealerTurnLoop() {


    }

    @Test
    public void dealerTurn() {


    }

    @Test
    public void printDealerTurn() {
    Card card = blackjackGame.dealerHit();
    Integer dealerHandValue = blackjackGame.getDealerHandValue();

    String expected = "Dealer's hand total:  " + dealerHandValue + "\n";
    String actual = blackjackGame.printDealerTurn();

    Assert.assertEquals(expected, actual);
    }








}
