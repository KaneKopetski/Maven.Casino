package models.games;

import Interfaces.GamblingGame;
import Interfaces.Game;
import com.sun.deploy.security.SelectableSecurityManager;
import com.sun.xml.internal.xsom.XSUnionSimpleType;
import models.gamecomponents.Dice;
import models.people.players.CrapsPlayer;
import models.people.players.Player;
import services.Console;
import services.DiceService;
import sun.tools.jconsole.JConsole;

import java.net.ConnectException;

public class CrapsGame extends DiceGame implements Game, GamblingGame {
    Double minimumBet;
    Double betAmount = 0.00;
    DiceService diceService = new DiceService();
    Integer pointNumber;
    Player player;
    Console console = new Console(System.in, System.out);

    public void askPlayerToPlaceBet() {
        betAmount = console.getDoubleInput("How much would you like to bet?");
        console.print("This will print") ;
    }

    public CrapsGame(Player player) {
        this.player = player;
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
