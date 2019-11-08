package services;

import models.people.players.Player;

public class PlayerService {

     public PlayerService() {
     }

    public Double getBalance(Player player) {
        return player.getBalance();
    }

    public Double depositMoney(Double depositAmt, Player player) {
        Double balance = player.getBalance();
        Double newBalance = balance + depositAmt;
        player.setBalance(newBalance);
        return balance;
    }

    public Double withdrawMoney(Double withdrawAmt, Player player) {
        Double balance = player.getBalance();
        Double newBalance = balance - withdrawAmt;
        player.setBalance(newBalance);
        return newBalance;
    }


}
