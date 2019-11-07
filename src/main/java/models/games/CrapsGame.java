package models.games;

import Interfaces.GamblingGame;
import Interfaces.Game;
import com.sun.deploy.security.SelectableSecurityManager;
import com.sun.xml.internal.xsom.XSUnionSimpleType;
import models.Lobby;
import models.gamecomponents.Dice;
import models.people.players.CrapsPlayer;
import models.people.players.Player;
import services.Console;
import services.DiceService;
import services.PlayerRepo;
import services.PlayerService;
import sun.tools.jconsole.JConsole;

import java.net.ConnectException;

public class CrapsGame extends DiceGame implements Game, GamblingGame {
    Double minimumBet;
    Double betAmount = 0.00;
    DiceService diceService = new DiceService();
    Integer pointNumber;
    Player player;
    Console console = new Console(System.in, System.out);

    public static void main(String[] args) {
        Player player = new Player();
        player.setBalance(1000.00);
        CrapsGame crapsGame = new CrapsGame(player);
        crapsGame.getMenu();
        crapsGame.askPlayerToPlaceBet();
        crapsGame.askToRollDie();
        crapsGame.determineWin();
    }






    public CrapsGame(Player player) {
        this.player = player;
    }
    public void getMenu() {
        Integer userInput = console.getIntegerInput(
                "\nDo you want to start craps\n\n" +
                        "1. Yes\n"
                        );
    }



    public Integer rollAndSum(Dice dice)
    {
        int sum=0;
        diceService.createDie();
      for(int i = 0 ;i < 2 ;i++)
      {
          sum=sum+diceService.rollDice(dice);
      }


       return sum;
      }
    public void askPlayerToPlaceBet() {
        betAmount = console.getDoubleInput("how much do you want to bet");
        PlayerService playerService = new PlayerService(player);
        Double balance = playerService.getBalance(player);

        if (betAmount <= balance) {
            startGame();
        } else {
            console.print("You don't have enough money. Sending you back to the lobby.\n");
            PlayerRepo playerRepo = new PlayerRepo();
            Lobby lobby = new Lobby(playerRepo);
            lobby.selectGameMenu();
        }
    }

    public void askToRollDie(){
        String request=console.getStringInput("please roll the die by giving the input :"+"roll\n");
    }
      public Boolean determineWin() {
        Dice dice = diceService.createDie();

        int sum=rollAndSum(dice);
          System.out.println(sum);
          if (sum == 7 || sum == 11) {

              System.out.println("YOU WIN ON FIRST ROLL\n");
              payOut();
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
                  finalValue = rollAndSum(dice);
                  System.out.println(finalValue);
                  if (finalValue == sum) {
                      System.out.println("YOU WIN FINALLY");
                      payOut();
                      return true;

                  }
                  else
                      {
                          if(finalValue==7||finalValue==11){
                              System.out.println   ("SORRY YOU LOOSE");
                      payOut();}
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

}
