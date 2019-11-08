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

    public Lobby(PlayerRepo playerRepo, Player player){
        this.playerRepo = playerRepo;
        this.player = player;
    }


    public void intro() {
        console.print(introMessage());
        Integer input = console.getIntegerInput(introPrompt());
        checkInMenu(input);
    }

    public String introMessage() {
        String message = "      ___           ___           ___           ___                    ___           ___           ___           ___              \n" +
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
                "                                                                                                                                  \n";
        return message;
    }

    public String introPrompt() {
        String prompt = "Hello and welcome to the Hard Code Casino. Have you been here before?\n" +
                "1. Yes\n" +
                "2. No";
        return prompt;
    }

    public String promptForAccountId() {
        String prompt = "Great! What is your account ID?";
        return prompt;
    }

    public String foundAccountMessage() {
        String message = "I have found your profile.";
        return message;
    }

    public String namePrompt() {
        String prompt = "What is your name?";
        return prompt;
    }

    public String agePrompt() {
        String prompt = "How old are you?";
        return prompt;
    }

    public String accountIdMessage() {
        String message = "Your account has been created. The ID is: " + player.getId() + "\n";
        return message;
    }

    public Player checkInMenu(Integer input) {
        switch (input) {
            case 1:
                Integer playerId = console.getIntegerInput(promptForAccountId());
                player = playerRepo.getPlayerById(playerId);
                console.print(foundAccountMessage());
                console.print(printBalanceMessage());
                updateChips();
                break;
            case 2:
                String name = console.getStringInput(namePrompt());
                Integer age = console.getIntegerInput(agePrompt());
                Player newPlayer = new Player(name, age);
                playerRepo.addPlayer(newPlayer);
                player = newPlayer;
                console.print(accountIdMessage());
                getChips();
            default:
                invalidSelectionMessage();
                intro();
                break;
        } return player;
    }

    public String getChipsPrompt() {
        String prompt = "How much money would you like to play with?";
        return prompt;
    }

    public String printBalanceMessage() {
        String message = "Your current balance is " + player.getBalance() + ".";
        return message;
    }

    public void getChips() {
        Double input = console.getDoubleInput(getChipsPrompt());
        playerService.depositMoney(input, player);
        console.print(printBalanceMessage());
        selectGameMenu();
    }

    public String updateChipsPrompt() {
        String prompt = "Would you like to add more to your balance\n1. Yes\n2. No";
        return prompt;
    }

    public void updateChips() {
        Integer input = console.getIntegerInput(updateChipsPrompt());
        updateChipsActions(input);
    }

    public void updateChipsActions(Integer input) {
        switch (input) {
            case 1:
                Double depositAmt = promptForDepositAmount();
                addToBalance(depositAmt);
                selectGameMenu();
                break;
            case 2:
                selectGameMenu();
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

    public String selectGamePrompt() {
        String prompt = "\nHere are the available games:\n\n" +
                "1. BlackJack\n" +
                "2. Go Fish\n" +
                "3. Klondike\n" +
                "4. Craps\n" +
                "5. Logout" +
                "6. Exit the Casino\n";
        return prompt;
    }

    public void selectGameMenu() {
        Integer input = console.getIntegerInput(selectGamePrompt());
        menuActions(input);
    }

    private void menuActions(Integer input) {
        switch (input) {
            case 1:
                BlackjackGame blackjackGame = new BlackjackGame(player, playerRepo);
                blackjackGame.playGame();
                break;
            case 2:
                GoFishGame goFishGame = new GoFishGame(player);
                goFishGame.getMenu();
                break;
            case 3:
                KlondikePlayer klondikePlayer = new KlondikePlayer(player);
                KlondikeGame klondikeGame = new KlondikeGame(klondikePlayer, playerRepo);
                klondikeGame.klondikeMenu();
                break;
            case 4:
                CrapsGame crapsGame = new CrapsGame(player, playerRepo);
                crapsGame.determineWin();
                break;
            case 5:
                intro();
                break;
            case 6:
                leaveCasino();
                break;
            default:
                invalidSelectionMessage();
                selectGameMenu();
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
