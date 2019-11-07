package models;

import models.gamecomponents.DeckOfCards;
import models.games.BlackjackGame;
import models.games.CrapsGame;
import models.games.GoFishGame;
import models.games.KlondikeGame;
import models.people.dealers.BlackjackDealer;
import models.people.dealers.Dealer;
import models.people.dealers.GoFishDealer;
import models.people.dealers.KlondikeDealer;
import models.people.players.Player;
import services.Console;
import services.PlayerRepo;
import services.PlayerService;

public class Lobby {
    private Console console = new Console(System.in, System.out);
    private Player player;
    private PlayerRepo playerRepo;
    private PlayerService playerService;
    private String firstName;
    private String lastName;
    private double balance;
    private DeckOfCards deckOfCards;

    Player player1 = new Player();
    Dealer dealer1 = new Dealer("","",8.0);
    GoFishGame goFishGame = new GoFishGame(player1);

    //public Lobby(PlayerRepo playerRepo){
        //this.playerRepo = playerRepo;
  //  }

    public Lobby(){
    }

    public Integer intro() {
        console.println("      ___           ___           ___           ___                    ___           ___           ___           ___              \n" +
                "     /\\__\\         /\\  \\         /\\  \\         /\\  \\                  /\\  \\         /\\  \\         /\\  \\         /\\  \\             \n" +
                "    /:/  /        /::\\  \\       /::\\  \\       /::\\  \\                /::\\  \\       /::\\  \\       /::\\  \\       /::\\  \\            \n" +
                "   /:/__/        /:/\\:\\  \\     /:/\\:\\  \\     /:/\\:\\  \\              /:/\\:\\  \\     /:/\\:\\  \\     /:/\\:\\  \\     /:/\\:\\  \\           \n" +
                "  /::\\  \\ ___   /::\\~\\:\\  \\   /::\\~\\:\\  \\   /:/  \\:\\__\\            /:/  \\:\\  \\   /:/  \\:\\  \\   /:/  \\:\\__\\   /::\\~\\:\\  \\          \n" +
                " /:/\\:\\  /\\__\\ /:/\\:\\ \\:\\__\\ /:/\\:\\ \\:\\__\\ /:/__/ \\:|__|          /:/__/ \\:\\__\\ /:/__/ \\:\\__\\ /:/__/ \\:|__| /:/\\:\\ \\:\\__\\         \n" +
                " \\/__\\:\\/:/  / \\/__\\:\\/:/  / \\/_|::\\/:/  / \\:\\  \\ /:/  /          \\:\\  \\  \\/__/ \\:\\  \\ /:/  / \\:\\  \\ /:/  / \\:\\~\\:\\ \\/__/         \n" +
                "      \\::/  /       \\::/  /     |:|::/  /   \\:\\  /:/  /            \\:\\  \\        \\:\\  /:/  /   \\:\\  /:/  /   \\:\\ \\:\\__\\           \n" +
                "      /:/  /        /:/  /      |:|\\/__/     \\:\\/:/  /              \\:\\  \\        \\:\\/:/  /     \\:\\/:/  /     \\:\\ \\/__/           \n" +
                "     /:/  /        /:/  /       |:|  |        \\::/__/                \\:\\__\\        \\::/  /       \\::/__/       \\:\\__\\             \n" +
                "     \\/__/         \\/__/         \\|__|         ~~                     \\/__/         \\/__/         ~~            \\/__/             \n" +
                "                                                                                                                                  ");



        Integer input = console.getIntegerInput("Hello and welcome to the Casino. Have you been here before?\n" +
                "1. Yes" +
                "2. No");
        checkInMenu(input);
        return input;
    }

    public Player checkInMenu(Integer input) {
        switch (input) {
            case 1:
                Integer playerId = console.getIntegerInput("Great! What is your account ID?");
                player = playerRepo.getPlayerById(playerId);
                console.print("I have found your profile. Please proceed.");
                getChips();
                break;
            case 2:
                String name = console.getStringInput("What is your name?");
                Integer age = console.getIntegerInput("How old are you?");
                Player newPlayer = new Player(name, age);
                playerRepo.addPlayer(newPlayer);
                player = newPlayer;
                console.print("Your account has been created. The ID is: " + playerService.getId());
                getChips();
            default:
                console.print("Invalid selection. Please try again.");
                intro();
                break;
        } return player;
    }

    public Double getChips() {
        Double input = console.getDoubleInput("How much money would you like to play with?");
        playerService.depositMoney(input, player);
        console.print("Here you go!");
        console.print("Your current balance is " + playerService.getBalance(player) + ".");
        selectGameMenu();
        return input;
    }

    public void selectGameMenu() {
        Integer input = console.getIntegerInput(
                "\nHere are the available games:\n\n" +
                        "1. BlackJack\n" +
                        "2. Go Fish\n" +
                        "3. Klondike\n" +
                        "4. Craps\n" +
                        "5. Exit the Casino\n");

        menuActions(input);
    }

    private void menuActions(Integer input) {
        switch (input) {
            case 1:
                BlackjackGame blackjackGame = new BlackjackGame(player);
                blackjackGame.playGame();
             
                BlackjackGame blackjackGame = new BlackjackGame(player);
                blackjackGame.getMenu();

                break;
            case 2:
                //dealer = new Dealer(firstName, lastName, balance);
                GoFishDealer goFishDealer = new GoFishDealer(firstName, lastName, balance, deckOfCards);
                GoFishGame goFishGame = new GoFishGame(player);
                goFishGame.getMenu();
                break;
            case 3:
                //dealer = new Dealer();
                KlondikeDealer klondikeDealer = new KlondikeDealer(firstName, lastName, balance);
                KlondikeGame klondikeGame = new KlondikeGame(player, klondikeDealer);
                klondikeGame.getMenu();
                break;
            case 4:
                CrapsGame crapsGame = new CrapsGame(player);
                crapsGame.getMenu();
                break;
            case 5:
                console.print("Bye!");
                System.exit(0);
                break;
            default:
                console.print("\nInvalid selection. Please try again.");
                selectGameMenu();
                break;
        }
    }

    public void leaveCasino() {
        console.print(("Bye!"));
        System.exit(0);
    }



}
