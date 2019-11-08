package models.games;

import Interfaces.GamblingGame;
import Interfaces.Game;
import models.Lobby;
import models.hands.KlondikeDealerHand;
import models.hands.KlondikeHand;
import models.people.dealers.Dealer;
import models.people.dealers.KlondikeDealer;
import models.people.players.KlondikePlayer;
import models.people.players.Player;
import services.Console;
import services.KlondikePrints;
import services.KlondikeService;
import services.PlayerService;

import java.util.ArrayList;

public class KlondikeGame extends DiceGame implements Game, GamblingGame {
    private Double betAmount;

    private Console console = new Console(System.in, System.out);
    private KlondikePrints kp = new KlondikePrints();
    private KlondikeDealer klondikeDealer = new KlondikeDealer("Seams", "Shaydee", Double.MAX_VALUE);
    private KlondikeDealerHand klondikeDealerHand = new KlondikeDealerHand();
    private KlondikePlayer klondikePlayer = new KlondikePlayer(player);
    private KlondikeHand klondikeHand = new KlondikeHand();
    private KlondikeService klondikeService = new KlondikeService();
    private PlayerService playerService = new PlayerService();

    public KlondikeGame(Player player) {
        this.player = player;
    }

    public void klondikeMenu() {
        welcome();

        Integer choice = instructions();

        instructionsChoice(choice);

        playGame();
    }

    public void playGame() {
        dealerRoll();
        setDealerRoll();
        getStringOfDealerRoll();

        betAmount = betAmount();
        setBetAmount(betAmount);

        playerRoll();
        setPlayerRoll();
        getStringOfPlayerRoll();

        winLose();

        Integer choice2 = playAgain();
        playAgainChoice(choice2);
        if(choice2 == 1) {
            playGame();
        } else {
            Lobby lobby = new Lobby();
            lobby.selectGameMenu(player);
        }
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
                console.println(kp.displayInstructions());
                break;
            case 2:
                console.println("Sounds great!");
                break;
        }
    }

    public Double betAmount() {
        return console.getDoubleInput(kp.asksBetAmount());
    }

    public void setBetAmount(Double betAmount) {
        this.betAmount = betAmount;
    }

    public Double getBetAmount() {
        return this.betAmount;
    }

    public void dealerRoll() {
        console.println(kp.dealerRolls());
    }

    public void setDealerRoll() {
        ArrayList<Integer> rolls = klondikeDealer.rollDiceFiveTimes();
        klondikeDealerHand.setDealersRoll(rolls);
    }

    public void getStringOfDealerRoll() {
        console.println(kp.printDice(klondikeDealerHand.getDealersRoll()).toString());
    }

    public void playerRoll() {
        console.println(kp.playerRolls());
    }

    public void setPlayerRoll() {
        klondikeHand.setPlayersRoll(klondikePlayer.rollDiceFiveTimes());
    }

    public void getStringOfPlayerRoll() {
        console.println(kp.printDice(klondikeHand.getPlayersRoll()).toString());
    }

    public Double payOut() {
        playerService.depositMoney(betAmount, player);
        return betAmount;
    }

    public Double addToBet() {
        return getBetAmount() * 2;
    }


    public Boolean didPlayerWin(){
        ArrayList<Integer> player = klondikeHand.getPlayersRoll();
        ArrayList<Integer> dealer = klondikeDealerHand.getDealersRoll();

        return klondikeService.didPlayerWin(klondikeService.bestHand(player), klondikeService.bestHand(dealer));
    }

    public void winLose() {
        if(didPlayerWin()) {
            console.println(kp.win());
        } else {
            console.println(kp.lose());
        }
    }

    public Integer playAgain() {
        return console.getIntegerInput(kp.playAgain());
    }

    public void playAgainChoice(Integer choice) {
        switch(choice) {
            case 1:
                console.println(kp.anotherRound());
                break;
            case 2:
                console.println(kp.differentGame());
                break;
        }
    }

}
