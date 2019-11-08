package models.games;

import Interfaces.GamblingGame;
import Interfaces.Game;
import models.Lobby;
import models.gamecomponents.Card;
import models.gamecomponents.CardValue;
import models.gamecomponents.DeckOfCards;
import models.people.players.Player;
import services.PlayerService;

import java.util.ArrayList;
import java.util.HashMap;


public class BlackjackGame extends CardGame implements Game, GamblingGame {
    Double minimumBet = 5.00;
    Double betAmount;
    Player player;
    DeckOfCards deckOfCards;
    HashMap<CardValue, Integer> blackJackValue = new HashMap<>();
    ArrayList <Card> playerHand;
    ArrayList <Card> dealerHand;
    Boolean dealerBust;
    Boolean playerBust;
    Boolean playerStay = false;
    Boolean dealerStay = false;
    Integer playerHandValue = 0;
    Integer dealerHandValue = 0;
    Lobby lobby = new Lobby();
    PlayerService playerServices;
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


    public Player getPlayer() {
       return this.player = player;
    }

    //Test passed
    public Card playerHit(){
        Card card = deckOfCards.drawCard();
        playerHand.add(card);
        setPlayerHandValue();
        playerHandToString();
        Integer playerHandValue = getPlayerHandValue();
        printPlayerHandValue(playerHandValue);
        checkForPlayerBust();
        return card;
    }

    //Test passed
    public Card dealerHit(){
        Card card = deckOfCards.drawCard();
        dealerHand.add(card);
        setDealerHandValue();
        printDealerHits(card);
        return card;
    }

    //Test passed
    public String printDealerHits(Card card){
        console.print("Dealer hits: " + card.getCardValue() + "\n");
        return "Dealer hits: " + card.getCardValue() + "\n";
    }

    public Integer dealerTurnLoop() {
        do  {
            dealerTurn();
        } while (getDealerHandValue() < 16);
        return getDealerHandValue();
    }

    public Integer dealerTurn() {
        Integer dealerHand = getDealerHandValue();
        printDealerTurn();
        checkForDealerBust();
        checkForBlackjackDealer();
            if (dealerHand <= 16) {
                dealerHit();
            } else if (dealerHand > 21) {
                dealerBust = true;
                determineWin();
            } else {
                dealerBust = false;
                determineWin();
            }
            return dealerHand;
        }

    //Test passed
    public String printDealerTurn(){
        console.print("Dealer's hand total:  " + dealerHandValue + "\n");
        return "Dealer's hand total:  " + dealerHandValue + "\n";
    }

    //Test passed
    public Boolean playerStay(){
        playerStay = true;
        dealerTurnLoop();
        return true;
    }


    public Boolean determineWin() {
        Integer dealerHand = getDealerHandValue();
        Integer playerHand = getPlayerHandValue();
        if (playerHand > dealerHand) {
            return playerWin();
        } else if (dealerHand > playerHand) {
            return playerLose();
        } else {
            return playerTie();
        }
    }

    public Boolean playerWin(){
        printPlayerWin();
        restartGamePrompt();
        return true;
    }

// passed test
    public String printPlayerWin(){
        console.print("\nYou win!\n\n");
        return "\nYou win!\n\n";
    }


    public Boolean playerLose() {
        printPlayerLose();
        receivePayment();
        restartGamePrompt();
        return false;
    }


    public String printPlayerLose(){
        console.print("\nYou lose!\n\n");
        return "\nYou lose!\n\n";
    }

    public Boolean playerTie() {
        printTie();
        restartGamePrompt();
        return false;
    }


    public String printTie(){
        console.print("\nNo Winners\n\n");
        return "\nNo Winners\n\n";
    }


    public String printPlayerHandValue(Integer value) {
        console.print("Total in your hand: " + value + "\n");
        return "Total in your hand: " + value + "\n";
    }


    public Integer getPlayerHandValue() {
        return playerHandValue;
    }


    public Integer getDealerHandValue() {
        return dealerHandValue;
    }


    public Boolean checkForBlackjackPlayer(){
        if(getPlayerHandValue() == 21){
            printgotBJPlayer();
            restartGamePrompt();
            return true;
        }
        return false;
    }

    public String printgotBJPlayer(){
        console.print("\nAyeee, You got BlackJack!\n\n");
        return "\nAyeee, You got BlackJack!\n\n";
    }


    public Boolean checkForBlackjackDealer(){
        if(getDealerHandValue() == 21){
            printDealerBJ();
            restartGamePrompt();
            return true;
        }
        return false;
    }


    public String printDealerBJ(){
        console.print("\nOh no, you lost! The Dealer has BlackJack.\n\n");
        return "\nOh no, you lost! The Dealer has BlackJack.\n\n";
    }


    public Boolean checkForDealerBust() {
        if (getDealerHandValue() > 21) {
            dealerBust = true;
            printDealerBust();
            restartGamePrompt();
            return true;
        } else {
            dealerBust = false;
            return false;
        }
    }


    public String printDealerBust(){
        console.print("\nDealer busts!\n\n");
        return "\nDealer busts!\n\n";
    }


    public Boolean checkForPlayerBust() {
        if (getPlayerHandValue() > 21) {
            playerBust = true;
            printPlayerBust();
            restartGamePrompt();
            return true;
        } else
            playerBust = false;
        return false;
    }

    public String printPlayerBust(){
        console.print("\nYou bust!\n\n");
        return "\nYou bust!\n\n";
    }


    public void promptForInstructionsMenu() {
        Integer input = console.getIntegerInput(
                "\nWelcome to the Blackjack table, Do you need instructions for this game?\n\n" +
                        "1. Yes, I don't want to lose my money that easy.\n" +
                        "2. Heck no, I'm a baller.\n" +
                        "3. I don't want to play this anymore\n");
        //Then call
        promptForInstructionsMenuAction(input);
    }

    private void promptForInstructionsMenuAction(Integer input) {
        switch (input) {
            case 1:
                printBJInstructions();
                promptPlayerToPlayMenu();
                break;
            case 2:
                startGame();
                break;
            default:
                lobby.selectGameMenu();
                break;
        }
    }

    public String printBJInstructions(){
        console.print("\nTHE BASIC RULES WHEN PLAYING BLACKJACK:\n\n" +
                "1. Blackjack starts with player making bets.\n" +
                "2. Dealer deals 2 cards to the player and two to himself (1 card face up, the other face down).\n" +
                "3. Blackjack card values: All cards count their face value in blackjack. Picture cards count as 10 and the ace count as 1.\n" +
                "   Card suits have no meaning in blackjack. The total of any hand is the sum of the card values in the hand\n" +
                "4. Players must decide whether to stand, hit, surrender, double down, or split.\n" +
                "5. The dealer acts last and must hit on 16 or less and stand on 17 through 21.\n" +
                "6. Players win when their hand totals higher than dealer’s hand, or they have 21 or less when the dealer busts (i.e., exceeds 21).\n\n");

        return "\nTHE BASIC RULES WHEN PLAYING BLACKJACK:\n\n" +
                "1. Blackjack starts with player making bets.\n" +
                "2. Dealer deals 2 cards to the player and two to himself (1 card face up, the other face down).\n" +
                "3. Blackjack card values: All cards count their face value in blackjack. Picture cards count as 10 and the ace count as 1.\n" +
                "   Card suits have no meaning in blackjack. The total of any hand is the sum of the card values in the hand\n" +
                "4. Players must decide whether to stand, hit, surrender, double down, or split.\n" +
                "5. The dealer acts last and must hit on 16 or less and stand on 17 through 21.\n" +
                "6. Players win when their hand totals higher than dealer’s hand, or they have 21 or less when the dealer busts (i.e., exceeds 21).\n\n";
    }

    private Integer promptPlayerToPlayMenu() {
        Integer input = console.getIntegerInput("\nDo you want to play?\n" +
                "1. Yes\n" +
                "2. No\n");
        promptPlayerToPlayActions(input);
        return input;
    }

    private void promptPlayerToPlayActions(Integer input) {
        switch (input) {
            case 1:
                startGame();
                break;
            case 2:
                lobby.selectGameMenu();
                break;
            default:
                printInvalidSelectMessage();
                break;
        }
    }

    public void startGame() {
        deckOfCards.shuffle();
        dealCards();
    }

    public void dealCards() {
        Card drawnCard = deckOfCards.drawCard();
        playerHand.add(drawnCard);
        drawnCard = deckOfCards.drawCard();
        playerHand.add(drawnCard);
        drawnCard = deckOfCards.drawCard();
        dealerHand.add(drawnCard);
        drawnCard = deckOfCards.drawCard();
        dealerHand.add(drawnCard);
    }

    public Integer setPlayerHandValue(){
        Integer playerNewHandValue = 0;
        for (Card card : playerHand) {
            playerNewHandValue += blackJackValue.get(card.getCardValue());
        }
        playerHandValue = playerNewHandValue;
        return playerNewHandValue;
    }

    public Integer setDealerHandValue() {
        Integer dealerNewHandValue = 0;
        for (Card card : dealerHand) {
            dealerNewHandValue += blackJackValue.get(card.getCardValue());
        }
        dealerHandValue = dealerNewHandValue;
        return dealerNewHandValue;
    }


    public void setBetAmount(Double betAmount) {
        this.betAmount = betAmount;
    }



    public void setMinimumBet(Double minimumBet) {
        this.minimumBet = minimumBet;
    }


    public Boolean betCheck(Double betAmount){
        playerServices = new PlayerService();
        if(betAmount >= minimumBet && playerServices.getBalance(this.player) >= betAmount) {
            this.betAmount = betAmount;
            return true;
        } else if(betAmount < playerServices.getBalance(this.player)) {
            printBetCheck();
            lobby.selectGameMenu();
            return false;
        } else {
            printMinimumBetMessage();
            placeBet();
            return false;
        }
    }


    public String printBetCheck(){
        console.print("You're broke. Get some more money.");
        return "You're broke. Get some more money.";
    }

    public String printMinimumBetMessage() {
        console.print("Minimum bet is $" + minimumBet + ". Please try again.");
        return "Minimum bet is $" + minimumBet + ". Please try again.";


    }
//You CANNOT write unit tests for methods that require user input
    public Double placeBet() {
            Double input = console.getDoubleInput("How much would you like to bet?");
            setBetAmount(input);
            return input;
        }

    public Double addToBet() {
        return null;
    }

    public Double payOut() {
        playerServices.depositMoney(betAmount, player);
        return betAmount;
    }

    public Double receivePayment() {
        playerServices.withdrawMoney(betAmount, player);
        return betAmount;
    }

    public void restartGamePrompt() {
        Integer input = console.getIntegerInput("\nDo you want to play again?\n" +
                "1. Yes\n" +
                "2. No\n");
        restartGameAction(input);
    }

    private void restartGameAction(Integer input2) {
        switch (input2) {
            case 1:
                BlackjackGame blackjackGame = new BlackjackGame(player);
                blackjackGame.playGame();
                break;
            case 2:
                leaveGame();
                break;
            default:
                printInvalidSelectMessage();
                restartGamePrompt();
                break;
        }
    }


    public String printInvalidSelectMessage(){
        console.print("Invalid selection please try again.\n");
        return "Invalid selection please try again.\n";
    }

    public void leaveGame() {
        printThanksForPlay();
        lobby.selectGameMenu();
    }


    public String printThanksForPlay(){
        console.print("Thanks for playing Blackjack!\n");
        return "Thanks for playing Blackjack!\n";
    }


    public void promptPlayerToHitOrStay() {
        Integer input = console.getIntegerInput("\nDo you want to hit or stay?\n1. Hit\n2. Stay\n");
        switch (input) {
            case 1:
                playerHit();
                checkForPlayerBust();
                checkForBlackjackPlayer();
                promptPlayerToHitOrStay();
                break;

            case 2:
                playerStay();
                break;

            default:
                printInvalidSelectMessage();
                promptPlayerToHitOrStay();
                break;
        }
    }

    public String playerHandToString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Your hand contains: ");
        for (Card card : playerHand) {
            sb.append(card.getCardValue().toString() + " ");
        }
        sb.append("\n");
        console.print(sb.toString());
        return sb.toString();
    }

    public String printDealerUpCard() {
        console.print("\n" + "Dealer's upcard is: " + dealerHand.get(1).getCardValue() + "\n");
        return "\n" + "Dealer's upcard is: " + dealerHand.get(1).getCardValue() + "\n";
    }

    public void playGame() {
    //When the game starts ask player if they want instruction
    promptForInstructionsMenu();
    placeBet();
    setPlayerHandValue();
    setDealerHandValue();
    printDealerUpCard();
    Integer playerHandValue = getPlayerHandValue();
    checkForBlackjackPlayer();
    checkForBlackjackDealer();
    //if player says yes, print instructions then start game
    //if player says no start game
    // if player wants to play after instructions, start game
    playerHandToString();
    printPlayerHandValue(playerHandValue);
    //ask player if they want to hit or stay
    promptPlayerToHitOrStay();
    //dealer takes turn until dealer stays
    dealerTurnLoop();
    checkForDealerBust();

    }


    public ArrayList<Card> getPlayerHand() {
        return playerHand;
    }

    public ArrayList<Card> getDealerHand() {
        return dealerHand;
    }
}
