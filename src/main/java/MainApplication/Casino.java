package MainApplication;


import models.Lobby;
import models.games.BlackjackGame;
import models.people.players.Player;
import services.PlayerRepo;

public class Casino {
    public static void main(String[] args) {
        // write your tests before you start fucking with this
       /* PlayerRepo playerRepo = new PlayerRepo();
        Lobby lobby = new Lobby(playerRepo);
        lobby.intro();

        */

       Player player = new Player();
       BlackjackGame blackjackGame = new BlackjackGame(player);
       blackjackGame.playGame();
    }
}
