package models.games;

import Interfaces.GamblingGame;
import Interfaces.Game;
import models.Lobby;
import models.gamecomponents.Card;
import models.gamecomponents.CardValue;
import models.gamecomponents.DeckOfCards;
import models.people.dealers.BlackjackDealer;
import models.people.dealers.Dealer;
import models.people.players.Player;
import services.Console;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;


public class BlackjackGame extends CardGame implements Game, GamblingGame {
//    Double minimumBet;
//    Double betAmount;
    Player player;
//    Dealer dealer;
    DeckOfCards deckOfCards;
    HashMap<CardValue, Integer> blackJackValue = new HashMap<>();
    ArrayList <Card> playerHand;
    ArrayList <Card> dealerHand;
    Boolean dealerBust;
    Boolean playerBust;
    Boolean playerStay = false;
    Boolean dealerStay = false;
    Lobby lobby = new Lobby();
    //Console console = new Console(); //Do we need this?


    public BlackjackGame(Player player){
        this.player = player;
        deckOfCards = new DeckOfCards();
        playerHand = new ArrayList<>();
        dealerHand = new ArrayList<>();
        blackJackValue.put(CardValue.TWO, 2);
        blackJackValue.put(CardValue.THREE, 3);
        blackJackValue.put(CardValue.FOUR, 4);
        blackJackValue.put(CardValue.FIVE, 5);
        blackJackValue.put(CardValue.SIX, 6);
        blackJackValue.put(CardValue.SEVEN, 7);
        blackJackValue.put(CardValue.EIGHT, 8);
        blackJackValue.put(CardValue.NINE, 9);
        blackJackValue.put(CardValue.TEN, 10);
        blackJackValue.put(CardValue.JACK, 10);
        blackJackValue.put(CardValue.KING, 10);
        blackJackValue.put(CardValue.QUEEN, 10);
        blackJackValue.put(CardValue.ACE, 1);
    }


    public void dealCards() {
        deckOfCards.shuffle();
        for (int i = 0; i < 2; i++) {
            Card drawnCard = deckOfCards.draw();
            playerHand.add(drawnCard);
        }
        for (int i = 0; i < 2; i++) {
            Card drawnCard = deckOfCards.draw();
            dealerHand.add(drawnCard);
        }
    }


    public void playerHit(){
        Card card = deckOfCards.draw();
        playerHand.add(card);
        console.print(playerHand.toString());
    }


    public void dealerHit(){
        Card card = deckOfCards.draw();
        dealerHand.add(card);
    }

    public void dealerTurnLoop() {
        do  {
            dealerTurn();
        } while (getDealerHandValue() < 16);
    }

    public void dealerTurn() {
        Integer dealerHand = getDealerHandValue();
            if (dealerHand <= 16) {
                dealerHit();

            } else if (dealerHand > 21) {
                determineWin();
                dealerBust = true;

            } else {
                determineWin();
                dealerBust = false;
            }
        }

    public void playerStay(){
        playerStay = true;
    }

    public Boolean determineWin() {
        Integer dealerHand = getDealerHandValue();
        Integer playerHand = getPlayerHandValue();
        if (playerHand > dealerHand || dealerBust == true) {
            console.print("You win!");
            restartGamePrompt();
            return true;
        } else if (dealerHand > playerHand || playerBust == true) {
            console.print("You lose!");
            restartGamePrompt();
            return false;
        } else {
            restartGamePrompt();
            return false;
        }
    }


    public Integer getPlayerHandValue(){
        Integer playerHandValue = 0;
        for (Card card : playerHand) {
            playerHandValue += blackJackValue.get(card.getCardValue());
        } return playerHandValue;
    }

    public Integer getDealerHandValue() {
        Integer dealerHandValue = 0;
        for (Card card : dealerHand) {
            dealerHandValue += blackJackValue.get(card.getCardValue());
        } return dealerHandValue;
    }


    public boolean checkForBlackjackPlayer(){
        if(getPlayerHandValue() == 21){
            console.print("You got BlackJack!\n");
            return true;
        }
        return false;
    }


    public boolean checkForBlackjackDealer(){
        if(getDealerHandValue() == 21){
            console.print("Dealer got BlackJack, you lost!\n");
            return true;
        }
        return false;
    }


    public void getMenu() {
        Integer input2 = console.getIntegerInput(
                "\nWelcome to the Blackjack table, Do you need instructions for this game?\n\n" +
                        "1. Yes, I don't want to lose my money that easy.\n" +
                        "2. Heck no, I'm a baller.\n" +
                        "3. I don't want to play this anymore\n");
        // call the menuAction to show what happens after selection
        menuAction(input2);
    }


    private void menuAction(Integer input2) {
        switch (input2) {
            case 1:
                console.print("\nTHE BASIC RULES WHEN PLAYING BLACKJACK:\n\n" +
                                    "1. Blackjack starts with player making bets.\n" +
                                    "2. Dealer deals 2 cards to the player and two to himself (1 card face up, the other face down).\n" +
                                    "3. Blackjack card values: All cards count their face value in blackjack. Picture cards count as 10 and the ace count as 1.\n" +
                                    "   Card suits have no meaning in blackjack. The total of any hand is the sum of the card values in the hand\n" +
                                    "4. Players must decide whether to stand, hit, surrender, double down, or split.\n" +
                                    "5. The dealer acts last and must hit on 16 or less and stand on 17 through 21.\n" +
                                    "6. Players win when their hand totals higher than dealer’s hand, or they have 21 or less when the dealer busts (i.e., exceeds 21).\n");

                String str = console.getStringInput("Type anything once you're ready to move on.");

                if (!str.equals(""))
                    startGame();
                // than call startgame or leavegame

                break;

            case 2:
                startGame();
                break;

            default:
                leaveGame();
                break;
        }
    }


    public void startGame() {
    //dealer starts handing out cards
    }


//    public void setMinimumBet(Double minimumBet) {
//        this.minimumBet = minimumBet;
//    }


    public Double placeBet() {
        return null;
    }



    public Double addToBet() {
        return null;
    }


    public Double payOut() {

        return null;
    }


    public Boolean dealerTurn(Dealer blackjackDealer) {
        return null;
    }


    public Boolean determineWin2() {
//        boolean winner = "YOU WON!";
//
//        if (player.equals(21)) {
//            return winner;
//        }
//        if (dealer.equals(21)) {
//            return  loser = AH CRAP;
//        }
        return null;
    }


    public void restartGamePrompt() {
        Integer input = console.getIntegerInput("Do you want to play again?\n" +
                "1. Yes\n" +
                "2. No");
        restartGameAction(input);
    }

    private void restartGameAction(Integer input2) {
        switch (input2) {
            case 1:
                startGame();
                break;
            case 2:
                console.print("Bye!");
                leaveGame();
                break;
            default:
                console.print("Invalid selection please try again.");
                restartGamePrompt();
                break;
        }
    }


    public void leaveGame() {
        console.print(("Bye!\n"));
        lobby.selectGameMenu();
    }

    public void promptPlayerToHitOrStay() {
        Integer input = console.getIntegerInput("Do you want to hit or stay?\n1. Hit\n2. Stay");
        if (input == 1) {
            playerHit();
            promptPlayerToHitOrStay();
        } else {
            playerStay();
        }

    }

public void playGame() {
        //When the game starts ask player if they want instructions
    getMenu();
    //if player says yes, print instructions then start game
    //if player says no start game
    //at game start, deal cards
    dealCards();
    playerHand.toString();
    //ask player if they want to hit or stay
    promptPlayerToHitOrStay();
    //continue to ask player until they stay
    //dealer takes turn until dealer stays
    dealerTurnLoop();
    //winner is determined
    //payout happens
}


}
