package models.games;

import Interfaces.GamblingGame;
import Interfaces.Game;
import models.people.dealers.Dealer;
import models.people.players.Player;
import services.Console;
import services.KlondikePrints;

public class KlondikeGame extends DiceGame implements Game, GamblingGame {
    Double betAmount = 0.00;
    Double minimumBet;
    Dealer dealer;

    Console console = new Console(System.in, System.out);
    KlondikePrints klondikePrints = new KlondikePrints();


    public KlondikeGame(Player player) {
        this.player = player;
    }

    public void welcome() {
        console.println(klondikePrints.klondikeWelcome());
        //console.getIntegerInput();
    }

    public String dealerRoll() {
        return null;
    }

    public String playerRoll() {
        return null;
    }

    public Double payOut() {
        return null;
    }

    public Double addToBet() {
        return null;
    }

    public void setMinimumBet(Double minimumBet) {
        this.minimumBet = minimumBet;
    }



}
