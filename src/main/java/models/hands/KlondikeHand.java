package models.hands;

import models.gamecomponents.Dice;

import java.util.ArrayList;
import java.util.TreeMap;

public class KlondikeHand extends Hand {

    private ArrayList<Integer> playersPoint;

    public ArrayList<Integer> getPlayersPoint() {
        return playersPoint;
    }

    public void setPlayersPoint(ArrayList<Integer> playersPoint) {
        this.playersPoint = playersPoint;
    }
}
