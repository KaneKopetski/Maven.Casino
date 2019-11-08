package models.games;

import Interfaces.GamblingGame;
import Interfaces.Game;
import models.hands.KlondikeDealerHand;
import models.hands.KlondikeHand;
import models.people.dealers.Dealer;
import models.people.dealers.KlondikeDealer;
import models.people.players.KlondikePlayer;
import models.people.players.Player;
import services.Console;
import services.KlondikePrints;

import java.util.ArrayList;

public class KlondikeGame extends DiceGame implements Game, GamblingGame {
    private Double betAmount = 0.00;
    private Double minimumBet;
    private Dealer dealer;

    private Console console = new Console(System.in, System.out);
    private KlondikePrints kp = new KlondikePrints();
    private KlondikeDealer klondikeDealer = new KlondikeDealer("Seams", "Shaydee", Double.MAX_VALUE);
    private KlondikeDealerHand klondikeDealerHand = new KlondikeDealerHand();
    private KlondikePlayer klondikePlayer = new KlondikePlayer(player);
    private KlondikeHand klondikeHand = new KlondikeHand();

    public KlondikeGame(Player player) {
        this.player = player;
    }

    public void klondikeMenu() {
        welcome();

        Integer choice = instructions();

        instructionsChoice(choice);

        setDealerRoll();
        getStringOfDealerRoll();
    }

    public void welcome() {
        console.println(kp.klondikeWelcome());
    }

    public Integer instructions() {
        return console.getIntegerInput(kp.askInstructions());
    }

    public void instructionsChoice(Integer choice) {
        switch(choice) {
            case 1:
                kp.displayInstructions();
                break;
            case 2:
                break;
        }
    }

    public void dealerRoll() {
        console.println(kp.dealerRolls());
    }

    public void setDealerRoll() {
        klondikeDealerHand.setDealersPoint(klondikeDealer.rollDiceFiveTimes());
    }

    public ArrayList<String> getStringOfDealerRoll() {
        return kp.printDice(klondikeDealerHand.getDealersPoint());
    }

    public void setPlayerRoll() {
        klondikeHand.setPlayersPoint(klondikePlayer.rollDiceFiveTimes());
    }

    public ArrayList<String> getStringOfPlayerRoll() {
        return kp.printDice(klondikeHand.getPlayersPoint());
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
