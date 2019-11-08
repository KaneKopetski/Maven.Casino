package models.games;

import Interfaces.GamblingGame;
import Interfaces.Game;
import models.Lobby;
import models.gamecomponents.Dice;
import models.people.players.Player;
import services.Console;
import services.DiceService;
import services.PlayerRepo;
import services.PlayerService;

public class CrapsGame extends DiceGame implements Game, GamblingGame {
    Double minimumBet;
    Double betAmount = 0.00;
    DiceService diceService = new DiceService();
    Integer pointNumber;
    Player player;
    Console console = new Console(System.in, System.out);


    public CrapsGame(Player player) {
        this.player = player;
    }

    public void getMenu() {
        Integer userInput = console.getIntegerInput(
                "\nDo you want to start craps\n\n" +
                        "1. Yes\n");
    }



    public Integer rollAndSum()
    {
        int sum=0;
        diceService.createDie();
      for(int i = 0 ;i < 2 ;i++)
      {
          sum=sum+diceService.rollDice();
      }


       return sum;
      }
    public void askPlayerToPlaceBet() {
        betAmount = console.getDoubleInput("how much do you want to bet");
        PlayerService playerService = new PlayerService();
        Double balance = playerService.getBalance(player);

        if (betAmount <= balance) {
            startGame();
        } else {
            console.print("You don't have enough money. Sending you back to the lobby.\n");
            PlayerRepo playerRepo = new PlayerRepo();
            Lobby lobby = new Lobby();
            lobby.selectGameMenu(player);
        }
    }

    public void askToRollDie(){
        String request=console.getStringInput("please roll the die by giving the input :"+"roll\n");
    }
      public Boolean determineWin() {
        Dice dice = diceService.createDie();

        int sum=rollAndSum();
          System.out.println(sum);
          if (sum == 7 || sum == 11) {

              System.out.println("YOU WIN ON FIRST ROLL\n");
              payOut();
              promptToPlayAgain();
              return true;
          }
          else {
              askToRollDie();
              pointNumber = sum;
              System.out.println("YOUR POINT VALUE IS :\n"+pointNumber);
              System.out.println("ROLL AGAIN");
              //CrapsPlayer.placeBet();
              int finalValue = 0;
              // player should roll the dice until he reaches 7/11/pointNumber
              while (finalValue != pointNumber && finalValue != 7 && finalValue != 11) {
                  dice = new Dice();
                  finalValue = rollAndSum();
                  System.out.println(finalValue);
                  if (finalValue == sum) {
                      System.out.println("YOU WIN FINALLY");
                      payOut();
                      promptToPlayAgain();
                      return true;

                  }
                  else
                      {
                          if(finalValue==7||finalValue==11){
                              System.out.println   ("SORRY YOU LOOSE");
                      payOut();
                              promptToPlayAgain();}
                          else
                              System.out.println("ROLL AGAIN");

                      }

                  }

          }
          return false;
      }


    public Double payOut() {
        return null;
    }

    public Double addToBet() {
        return null;
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
                Lobby lobby = new Lobby();
                lobby.selectGameMenu(player);
        }
    }

}
