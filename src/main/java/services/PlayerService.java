package services;

import models.hands.Hand;
import models.people.players.Player;


public class PlayerService {
     Player player1 = new Player();
     Double balance;

     public PlayerService() {

     }

    public PlayerService(Player player1) {
        this.player1 = player1;
        balance = 0.0;
    }

    public Double getBalance(Player player) {
        return player.getBalance();
    }

    public Double depositMoney(Double depositAmt, Player player) {
        balance = player1.getBalance();
        balance += depositAmt;

        return balance;
    }

    public Double withdrawMoney(Double withdrawAmt, Player player) {
        balance = player1.getBalance();
        balance -= withdrawAmt;

        return balance;
    }

    public  Double getBalance2(Player player) {

        return balance;
    }

    public  Double depositMoney(Double depositAmt) {

        balance = player1.getBalance();
        balance += depositAmt;

        return balance;
    }

    public  Double withdrawMoney(Double withdrawAmt) {

        balance = player1.getBalance();
        balance -= withdrawAmt;

        return balance;
    }

    public Hand resetPlayerHands(Player player) {
        return  null;

    }

    public Integer getId() {
        return null;
    }





}
