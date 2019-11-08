package models;

import models.games.BlackjackGame;
import models.games.CrapsGame;
import models.games.GoFishGame;
import models.games.KlondikeGame;
import models.people.players.KlondikePlayer;
import models.people.players.Player;
import services.Console;
import services.PlayerRepo;
import services.PlayerService;

public class Lobby {
    private Console console = new Console(System.in, System.out);
    private Player player;
    private PlayerRepo playerRepo;
    private PlayerService playerService = new PlayerService();

    public Lobby(PlayerRepo playerRepo){
        this.playerRepo = playerRepo;
    }

    public Lobby(){
    }

    public Integer intro() {
        console.print("      ___           ___           ___           ___                    ___           ___           ___           ___              \n" +
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
                "                                                                                                                                  \n");



        Integer input = console.getIntegerInput("Hello and welcome to the Casino. Have you been here before?\n" +
                "1. Yes\n" +
                "2. No");
        checkInMenu(input);
        return input;
    }

    public Player checkInMenu(Integer input) {
        switch (input) {
            case 1:
                Integer playerId = console.getIntegerInput("Great! What is your account ID?");
                player = playerRepo.getPlayerById(playerId);
                console.print("I have found your profile. Your current balance is: " + player.getBalance());
                updateChips();
                break;
            case 2:
                String name = console.getStringInput("What is your name?");
                Integer age = console.getIntegerInput("How old are you?");
                Player newPlayer = new Player(name, age);
                playerRepo.addPlayer(newPlayer);
                player = newPlayer;
                console.print("Your account has been created. The ID is: " + player.getId() + "\n");
                getChips();
            default:
                invalidSelectionMessage();
                intro();
                break;
        } return player;
    }

    public Double getChips() {
        Double input = console.getDoubleInput("How much money would you like to play with?");
        playerService.depositMoney(input, player);
        console.print("Here you go!\n");
        console.print("Your current balance is " + player.getBalance() + ".");
        selectGameMenu(player);
        return input;
    }

    public Integer updateChips() {
        Integer input = console.getIntegerInput("Would you like to add more to your balance\n1. Yes\n2. No");
        updateChipsActions(input);
        return input;
    }

    public void updateChipsActions(Integer input) {
        switch (input) {
            case 1:
                Double depositAmt = promptForDepositAmount();
                addToBalance(depositAmt);
                selectGameMenu(player);
                break;
            case 2:
                selectGameMenu(player);
                break;
            default:
                invalidSelectionMessage();
                updateChips();
                break;
        }
    }

    public Double promptForDepositAmount() {
        return console.getDoubleInput("How much would you like to add?");
    }

    public void addToBalance(Double depositAmt) {
        Double newBalance = player.getBalance() + depositAmt;
        player.setBalance(newBalance);
    }

    public void selectGameMenu(Player player) {
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
                break;
            case 2:
                GoFishGame goFishGame = new GoFishGame(player);
                goFishGame.getMenu();
                break;
            case 3:
                KlondikePlayer klondikePlayer = new KlondikePlayer(player);
                KlondikeGame klondikeGame = new KlondikeGame(klondikePlayer);
                klondikeGame.klondikeMenu();
                break;
            case 4:
                CrapsGame crapsGame = new CrapsGame(player);
                crapsGame.determineWin();
                break;
            case 5:
                leaveCasino();
                break;
            default:
                invalidSelectionMessage();
                selectGameMenu(player);
                break;
        }
    }

    public String invalidSelectionMessage() {
        String message = "Invalid selection. Please try again.";
        console.print(message);
        return message;

    }

    public void leaveCasino() {
        console.print(("Bye!"));
        System.exit(0);
    }



}
