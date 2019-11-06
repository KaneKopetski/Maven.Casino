package models.games;

import Interfaces.Game;
import models.people.dealers.Dealer;
import models.people.players.Player;

public class GoFishGame extends CardGame implements Game {
    Player player;
    Dealer dealer;
    Boolean win;



    public GoFishGame(Player player, Dealer dealer) {
        this.player = player;
        this.dealer = dealer;
        win = false;
    }

    public Boolean playerTurn(Player goFishPlayer) {
        return null;
    }

    public Boolean dealerTurn(Dealer goFishDealer) {
        return null;
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
            case 1:
                startGame();
                break;
            case 2:
                System.out.println("\n\nRULES:\n" +
                        "The User and the Oppent(Computer) both start with" +
                        " 7 cards. The user\nasks for a Card by entering the value" +
                        " as a number. Ace is 1 and Jack,\nQueen,King are 11,12,13." +
                        "If the card you've asked for is contained in\nthe deck of" +
                        " the opponent then gives a card with that value.\n" +
                        "If guessed incorrectly then player goes to fish for the card. (must draw from the Table Deck)" +
                        " If the\ncard drawn from the Table Deck then its the computer's turn." +
                        "The game ends\nif either the Table Deck, User Hand, or Computer" +
                        " Hand are empty. The \nplayer with the most set (a set is 3 cards of the same value) wins the game" +
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
            userTurn();
            checkForGameOver();

            compTurn();
            checkForGameOver();

        }while(!win);


    }

    //steps to follow when its player's turn
    public void userTurn()
    {

    }

    //steps to follow when its computer's turn
    public void compTurn()
    {

    }

    //to check if the game is over or not
    public void checkForGameOver()
    {

    }




}
