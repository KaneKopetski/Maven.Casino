package models;

import models.people.players.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import services.PlayerRepo;

import static org.junit.Assert.*;

public class LobbyTest {
    Lobby lobby;
    PlayerRepo playerRepo;

    @Before
    public void createLobby() {
        PlayerRepo playerRepo = new PlayerRepo();
        Lobby lobby = new Lobby(playerRepo);
        this.lobby = lobby;
        this.playerRepo = playerRepo;
    }

    @Test
    public void introMessage() {
        String actual = lobby.introMessage();
        String expected = "      ___           ___           ___           ___                    ___           ___           ___           ___              \n" +
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

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void introPrompt() {
        String actual = lobby.introPrompt();
        String expected = "";
    }

    @Test
    public void promptForAccountId() {
    }

    @Test
    public void foundAccountMessage() {
    }

    @Test
    public void namePrompt() {
    }

    @Test
    public void agePrompt() {
    }

    @Test
    public void accountIdMessage() {
    }

    @Test
    public void checkInMenu() {
    }

    @Test
    public void getChipsPrompt() {
    }

    @Test
    public void printBalanceMessage() {
    }

    @Test
    public void updateChipsPrompt() {
    }

    @Test
    public void promptForDepositAmount() {
    }

    @Test
    public void selectGamePrompt() {
    }

    @Test
    public void invalidSelectionMessage() {
    }
}