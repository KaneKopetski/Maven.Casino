import models.gamecomponents.Card;
import models.gamecomponents.CardValue;
import models.games.BlackjackGame;
import models.people.dealers.BlackjackDealer;
import models.people.players.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import services.PlayerRepo;

import java.util.ArrayList;

public class BlackjackGameTest {
    BlackjackGame blackjackGame;
    Player player;

    @Before
    public void blackJackTest() {
        Player player = new Player();
        PlayerRepo playerRepo = new PlayerRepo();
        BlackjackGame blackjackGame = new BlackjackGame(player, playerRepo);
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
    public void printDealerHitsTest() {
        Card card = blackjackGame.dealerHit();
        String expected = "Dealer hits: " + card.getCardValue() + "\n";
        String actual = blackjackGame.printDealerHits(card);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void dealerTurnLoopTest() {


    }

    @Test
    public void dealerTurnTest() {


    }

    @Test
    public void printDealerTurnTest() {
    Card card = blackjackGame.dealerHit();
    Integer dealerHandValue = blackjackGame.getDealerHandValue();

    String expected = "Dealer's hand total:  " + dealerHandValue + "\n";
    String actual = blackjackGame.printDealerTurn();

    Assert.assertEquals(expected, actual);
    }

    @Test
    public void playerStayTest() {
    Assert.assertTrue(blackjackGame.playerStay());
    }

//    @Test
//    public void determineWin() {
//    Integer dealerHand = blackjackGame.getDealerHandValue();
//    Integer playerHand = blackjackGame.getPlayerHandValue();
//
//    Integer expected = 17;
//    Integer actual =
//
//    Assert.assertTrue(expected, actual);
//    }


    @Test
    public void printPlayerWinTest() {
        Assert.assertEquals("\nYou win!\n\n",blackjackGame.printPlayerWin());
    }

    @Test
    public void printPlayerLoseTest() {
        Assert.assertEquals("\nYou lose!\n\n",blackjackGame.printPlayerLose());
    }

    @Test
    public void printTie() {
        Assert.assertEquals("\nNo Winners\n\n", blackjackGame.printTie());
    }

    @Test
    public void printPlayerHandValue() {
        Integer value = blackjackGame.getPlayerHandValue();

        Assert.assertEquals("Total in your hand: " + value + "\n", blackjackGame.printPlayerHandValue(value));
    }

    @Test
    public void printBetCheck() {
        Assert.assertEquals("You're broke. Get some more money.", blackjackGame.printBetCheck());
    }

    @Test
    public void printMinimumBetMessageTest(){
        Assert.assertEquals("Minimum bet is $5.0. Please try again.", blackjackGame.printMinimumBetMessage());
    }

    @Test
    public void printInvalidSelectMessageTest(){
        Assert.assertEquals("Invalid selection please try again.\n", blackjackGame.printInvalidSelectMessage());
    }

    @Test
    public void printThanksForPlayTest(){
        Assert.assertEquals("Thanks for playing Blackjack!\n", blackjackGame.printThanksForPlay());
    }

//    @Test
//    public void printDealerUpCardTest(){
//        ArrayList<Card> dealerHand = new ArrayList<>();
//        dealerHand.add(Card.);
//        (CardValue.FOUR)
//        Assert.assertEquals("\n" + "Dealer's upcard is: " + dealerHand.get(1).getCardValue() + "\n", blackjackGame.printDealerUpCard());
//    }

    @Test
    public void printPlayerBustTest(){
        Assert.assertEquals("\nYou bust!\n\n", blackjackGame.printPlayerBust());
    }

    @Test
    public String printgotBJPlayerTest() {
        Assert.assertEquals("\nYou bust!\n\n", blackjackGame.printgotBJPlayer());




    }
