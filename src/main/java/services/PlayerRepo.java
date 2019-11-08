package services;

import models.people.players.Player;
import java.util.ArrayList;

public class PlayerRepo {
    ArrayList<Player> playerRepo;

    public PlayerRepo() {
        this.playerRepo = new ArrayList();

    }

    public Boolean addPlayer(Player player) {
        return this.playerRepo.add(player);
    }

    public Player getPlayerById(Integer id) {
        for (Player player : playerRepo) {
            if (player.getId() == id) {
                return player;
            }
        }
        return null;
    }

    public ArrayList<Player> getPlayers() {
        return playerRepo;
    }

    public Player getPlayerByName(String name) {
        for (Player player : playerRepo) {
            if (player.getName().equals(name)) {
                return player;
            }
        } return null;
    }
}
