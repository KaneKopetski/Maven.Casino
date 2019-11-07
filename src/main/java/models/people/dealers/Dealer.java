package models.people.dealers;

import models.gamecomponents.Card;
import models.gamecomponents.DeckOfCards;
import models.hands.Hand;

import java.util.ArrayList;

public class Dealer {
    private String firstName;
    private String lastName;
    private double balance;

    public Dealer(String firstName, String lastName, double balance) {
        this.firstName = "Richard";
        this.lastName = "Turner";
        this.balance = Double.MAX_VALUE;

    }

    public void dealGameComponent(Hand hand) {

    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void winBet(double amount) {
        this.balance = balance + amount;

    }
    public void loseBet(double amount) {
        this.balance = balance - amount;

    }
}
