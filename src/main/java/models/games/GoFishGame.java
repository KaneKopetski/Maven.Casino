package models.games;

import Interfaces.Game;
import models.Lobby;
import models.gamecomponents.Card;
import models.gamecomponents.CardValue;
import models.gamecomponents.DeckOfCards;
import models.people.players.Player;
import services.PlayerRepo;


import java.util.ArrayList;

public class GoFishGame extends CardGame implements Game {

    Boolean win;
    Integer pickedCard =0;

    private DeckOfCards stock = new DeckOfCards();
    private ArrayList<Card> playerHand = new ArrayList<>();
    private ArrayList<Card> dealerHand = new ArrayList<>();

    //to store the sets formed by the player and the dealer
    private ArrayList<Integer> playerSet = new ArrayList<>();
    private ArrayList<Integer> dealerSet = new ArrayList<>();

   public GoFishGame(Player player)
    {
        this.player = player;
        win = false;
    }

    public void getMenu() {
        Integer userInput = console.getIntegerInput(
                "\nDo you need instructions for this game?\n\n" +
                        "1. Yes, I don't want to lose my money that easy\n" +
                        "2. Heck no, I'm a baller.\n");

        while(userInput > 2 || userInput < 1)
        {
            userInput =  console.getIntegerInput("Invalid input, 1 or 2 Only!\nTry Again.");
        }

        switch(userInput)
        {
            case 2:
                startGame();
                break;
            case 1:
                console.getStringInput("\n\nRULES:\n" +
                        "The User and the Oppent(Computer) both start with 7 cards." +
                        "  The user\nasks for a Card by entering the value as a number" +
                        " and Jack,Queen,King are 11,12,13." +
                        "If the card you've asked for is contained in\nthe deck of" +
                        " the opponent then gives a card with that value.\n" +
                        "If guessed incorrectly then player goes to fish for the card. (must draw from the Table Deck)" +
                        " If the\ncard drawn from the Table Deck then its the computer's turn." +
                        "The game ends\nif either the Table Deck, User Hand, or Computer" +
                        " Hand are empty. The \nplayer with the most set (a set is 4 cards of the same value) wins the game" +
                        " \nPress Enter to start the Game");

                //need to read the console to check if the user pressed Enter key
                startGame();
                break;
        }

    }

    public void startGame()
    {
            stock.shuffle();

            distributeCards();

            checkDeal(playerHand, 1);

            checkDeal(dealerHand, 2);

            if (playerSet.size() > 0)
            {
                System.out.println("Wow! You got extremely lucky and got a book " +
                        "on the deal of the value " + playerSet.get(0) +
                        "\nThat puts you at 1 Set already!\n");
            }

            if (dealerSet.size() > 0)
            {
                System.out.println("Wow! The Dealer got extremely lucky and got a " +
                        "book on the deal of the value " + dealerSet.get(0) +
                        "\nThat puts the dealer at 1 Set already!\n");
            }



            do
            {

            showCard("Player");
            showSets();

            Boolean pt = playerTurn();

            if(pt)
            {
                checkDeal(playerHand, 1);
                checkForGameOver();
            }
            else
            {
                //draw a card from the stock - go fishing
                String userPress = console.getStringInput("Go Fish. Press enter Key\n");

                    Card card;
                    card = stock.drawCard();
                    playerHand.add(card);

                    checkDeal(playerHand, 1);
                    checkForGameOver();

            }

            Boolean bt = dealerTurn();
            if(bt)
            {

                checkDeal(dealerHand, 2);
                checkForGameOver();
            }
            else
            {
                //draw a card from the stock - go fishing
                Card card;
                card = stock.drawCard();
                dealerHand.add(card );

                checkDeal(dealerHand, 2);
                checkForGameOver();
            }

        }while(!win);

        System.out.println("Game Over!");
        displayWinner();

        promptToPlayAgain();


    }

    // public Boolean playerTurn(Player goFishPlayer)
    public Boolean playerTurn()
    {

        Integer whatCard = console.getIntegerInput("Which value would you like to ask for from the Dealer?\n");

        int count = 0;
        Card card = null;
        for (int i=0; i<dealerHand.size(); i++)
        {
            card = dealerHand.get(i);
            CardValue cv = card.getCardValue();
            Integer cvb = cv.getCardValue();
            if(cvb == whatCard) //if the dealer hand contains the card asked by the player
            {
                count++;
                break;
            }
        }

        if (count>0)
        {

            int removeCount = 0;
            for (int i=0 ; i<dealerHand.size(); i++)
            {

                if (dealerHand.get(i).getCardValue().getCardValue() == card.getCardValue().getCardValue())
                {
                    playerHand.add(dealerHand.get(i));
                    dealerHand.remove(i);
                    i--;
                    removeCount += 1;

                }
            }
            console.println("Player picked " + removeCount + " card(s) from dealer\n");
            return true;
        }
        return false;
    }

    //public Boolean dealerTurn(Dealer goFishDealer)
    public Boolean dealerTurn()
    {

        Integer mostCount = getMostCount(); //gives mostcount from the dealer

        int count = 0;
        Card card = null;
        for (int i=0; i<playerHand.size(); i++)
        {
            card = playerHand.get(i);
            CardValue cv = card.getCardValue();
            Integer cvb = cv.getCardValue();
            if(cvb == mostCount) //if the player hand contains the card asked by the dealer
            {
                dealerHand.add(card);
                int removeCount = 0;
                for (int j=0 ; j<playerHand.size(); i++)
                {

                    if (playerHand.get(j).getCardValue().getCardValue() == card.getCardValue().getCardValue())
                    {
                        dealerHand.add(playerHand.get(j));
                        playerHand.remove(j);
                        i--;
                        removeCount += 1;

                    }
                }
                console.println("Dealer picked " + removeCount + " card(s) from Player\n");
                return true;

            }
        }

        return false;


    }



    public Boolean checkDeal(ArrayList<Card> hand, int playerOrDealer)
    {
        for(int i = 0; i<hand.size()-3 ; i++)
        {
            if(getCount(hand.get(i).getCardValue(), hand) == 3)
            {
                Integer cardToBeRemoved = hand.get(i).getCardValue().getCardValue();

                if (playerOrDealer == 1)
                {
                    playerSet.add(cardToBeRemoved);
                    for (int j = 0; j < playerHand.size(); j++)
                    {
                        Integer cv1 = playerHand.get(j).getCardValue().getCardValue();
                        if (cv1 == cardToBeRemoved)
                        {
                            playerHand.remove(j);
                            j--;
                        }
                    }

                }
                else
                {
                    dealerSet.add(cardToBeRemoved);
                    for (int j = 0; j < dealerHand.size(); j++) {
                        Integer cv1 = dealerHand.get(j).getCardValue().getCardValue();

                        if (cv1 == cardToBeRemoved)
                        {
                            dealerHand.remove(j);
                            j--;
                        }
                    }
                }


                return true;

            }
        }
        return false;
    }

    //checking the dealerHand (mostcount) to ask from the player
    public int getMostCount()
    {
        int newCount;
        int mostCount = 0;
        Integer mostCommon =0;

        for (int i=0 ; i<dealerHand.size(); i++)
        {
            newCount = getCount(dealerHand.get(i).getCardValue(),dealerHand);
            if (newCount > mostCount)
            {
                mostCount = newCount;
                mostCommon = dealerHand.get(i).getCardValue().getCardValue();
            }

        }
        return mostCommon;
    }

    //check for occurence
    public int getCount(CardValue value, ArrayList<Card> hand)
    {
        int occurence = 0;
        for(int i = 0; i< hand.size(); i++)
        {
            if( hand.get(i).getCardValue() == value)
            {
                occurence++;
            }
        }
        return occurence;
    }


    //to check if the game is over or not
    public void checkForGameOver()
    {

        win = ( stock.numberOfCardsLeft() == 0 || playerHand.size() == 0
                || dealerHand.size() == 0);
    }

    public void displayWinner()
    {
        if(
                playerSet.size() < dealerSet.size())
        {
            System.out.println("The computer Won!\n");
        }
        else if(playerSet.size() > dealerSet.size())
        {
            System.out.println("Congrats YOU Won!\n" );
//                    "User Books : " + userBooks +
//                    "\nComputer Books : " + cpBooks);
        }
        else if(playerSet.size() == dealerSet.size())
        {
            System.out.println("The game was a tie!\n"  );
                   // "You both had " + userBooks + " books.");
        }
    }

    //showing the Player/Dealer card
    public void showCard(String playerOrDealer)
    {
        if (playerOrDealer == "Player") {
            StringBuilder sb = new StringBuilder();
            sb.append("Player has the following Cards in Hand\n");
            for (int i = 0; i < playerHand.size(); i++) {

                sb.append(playerHand.get(i).getSuit());
                sb.append(" ");
                sb.append(playerHand.get(i).getCardValue().getCardValue());
                sb.append(" ");

            }
            sb.append("\n\n");
            console.print(sb.toString());
        }
    }

    public void showSets()
    {
        StringBuilder sb1 = new StringBuilder();
        sb1.append(String.format("Player has %s set(s) [", playerSet.size()));
        for(int i=0; i<playerSet.size(); i++)
        {
            sb1.append(playerSet.get(i));
            sb1.append(" ");
        }
        sb1.append("]\n");
        console.println(sb1.toString());

        StringBuilder sb2 = new StringBuilder();
        sb2.append(String.format("Dealer has %s set(s) [", dealerSet.size()));
        for(int i=0; i<dealerSet.size(); i++)
        {
            sb2.append(dealerSet.get(i));
            sb2.append(" ");
        }
        sb2.append("]\n");
        console.println(sb2.toString());

    }

    public void promptToPlayAgain() {
        Integer input = console.getIntegerInput("PLAY AGAIN?\n1. YES\n2. NO");
        playAgainActions(input);
    }

    public void playAgainActions(Integer input) {
        switch (input) {
            case 1:
                determineWin();
            case 2:
                Lobby lobby = new Lobby(playerRepo, player);
                lobby.selectGameMenu();
        }
    }

    public void distributeCards()
    {
        for(int i = 0; i<7; i++)
        {
            Card card;

            card = stock.drawCard();
            playerHand.add(card );

            card = stock.drawCard();
            dealerHand.add(card);
        }
    }

}
