package models.games;

import Interfaces.Game;
import models.gamecomponents.Card;
import models.gamecomponents.CardValue;
import models.gamecomponents.DeckOfCards;
import models.people.dealers.Dealer;
import models.people.players.Player;


import java.util.ArrayList;

public class GoFishGame extends CardGame implements Game {
   // Player player;
   // Dealer dealer;
    Boolean win;

    private DeckOfCards stock = new DeckOfCards();
    private ArrayList<Card> playerHand = new ArrayList<>();
    private ArrayList<Card> dealerHand = new ArrayList<>();

    //to store the sets formed by the player and the dealer
    private ArrayList<CardValue> playerSet = new ArrayList<>();
    private ArrayList<CardValue> dealerSet = new ArrayList<>();




   public GoFishGame(Player player, Dealer dealer)
   //public GoFishGame(Player player)
    {
        this.player = player;
        //this.dealer = dealer;
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
                System.out.println("\n\nRULES:\n" +
                        "The User and the Oppent(Computer) both start with" +
                        " 7 cards. The user\nasks for a Card by entering the value" +
                        " as a number. Ace is 1 and Jack,\nQueen,King are 11,12,13." +
                        "If the card you've asked for is contained in\nthe deck of" +
                        " the opponent then gives a card with that value.\n" +
                        "If guessed incorrectly then player goes to fish for the card. (must draw from the Table Deck)" +
                        " If the\ncard drawn from the Table Deck then its the computer's turn." +
                        "The game ends\nif either the Table Deck, User Hand, or Computer" +
                        " Hand are empty. The \nplayer with the most set (a set is 4 cards of the same value) wins the game" +
                        " \n\t\tPress Enter to start the Game");
                //need to read the console to check if the user pressed Enter key
                startGame();
                break;
        }

    }

    public void startGame()
    {
        do
        {
            stock.shuffle();
            for(int i = 0; i<7; i++)
            {
                Card card;

                card = stock.drawCard();
                playerHand.add(card );

                card = stock.drawCard();
                dealerHand.add(card);
            }

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


            StringBuilder sb = new StringBuilder();
            sb.append("Player has the following Cards in Hand\n");

            //showing the Players cards
            for (int i=0; i<playerHand.size() ; i++)
            {

                sb.append(playerHand.get(i).getSuit());
                sb.append(" ");
                sb.append(playerHand.get(i).getCardValue().getCardValue());
                sb.append(" ");

            }
            sb.append("\n");
            console.print(sb.toString());

            Boolean pt = playerTurn();
            if(pt)
            {
                checkDeal(playerHand, 1);
                checkForGameOver();
            }
            else
            {
                //draw a card from the stock - go fishing
                Card card;
                card = stock.drawCard();
                playerHand.add(card );

                checkDeal(playerHand, 1);
                checkForGameOver();
            }

            dealerTurn();
            checkForGameOver();

        }while(!win);

        System.out.println("Game Over!");
        displayWinner();

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
            playerHand.add(card); // todo check this
            dealerHand.remove(card);
            return true;
        }



        return false;//todo may have to change it
    }

    //public Boolean dealerTurn(Dealer goFishDealer)
    public Boolean dealerTurn()
    {
        //my logic should be to pick for a mostcountdealercard from player else pick mostcount card of player else draw a card


        return false;//todo may have to change it
    }




    public Boolean checkDeal(ArrayList<Card> hand, int playerOrDealer) //CHECKS FOR BOOK ON OPENING DEAL
    {
        for(int i = 0; i<4 ; i++) // todo: array size instead of 4 when checkfor sets after playerturn/userturn
        {
            if(getCount(hand.get(i).getCardValue(), hand) == 4)
            {
                if (playerOrDealer == 1)
                {
                    playerSet.add(hand.get(i).getCardValue());
                }
                else
                {
                    dealerSet.add(hand.get(i).getCardValue());
                }
                return true;

            }
        }
        return false;
    }

    //check for the card if it occurs 4 times within the arraylist
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

        win = ( playerHand.size() == 0
                || dealerHand.size() == 0); //todo: need to check if the stock is empty after drawing last card from the deck
    }

    public void displayWinner()
    {
        if(
                playerSet.size() < dealerSet.size())
        {
            System.out.println("The computer Won!\n");
        }else if(playerSet.size() > dealerSet.size())
        {
            System.out.println("Congrats YOU Won!\n" );
//                    "User Books : " + userBooks +
//                    "\nComputer Books : " + cpBooks);
        }else if(playerSet.size() == dealerSet.size())
        {
            System.out.println("The game was a tie!\n"  );
                   // "You both had " + userBooks + " books.");
        }
    }




}
