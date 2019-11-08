package models.hands;

import models.gamecomponents.Dice;

import java.util.ArrayList;
import java.util.TreeMap;

public class KlondikeHand extends Hand {

    private ArrayList<Integer> playersRoll;

    public ArrayList<Integer> getPlayersRoll() {
        return this.playersRoll;
    }

    public void setPlayersRoll(ArrayList<Integer> playersRoll) {
        this.playersRoll = playersRoll;
    }
}
