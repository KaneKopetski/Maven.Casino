package models.hands;

import java.util.ArrayList;

public class KlondikeHand extends Hand {

    private ArrayList<Integer> playersRoll;

    public ArrayList<Integer> getPlayersRoll() {
        return this.playersRoll;
    }

    public void setPlayersRoll(ArrayList<Integer> playersRoll) {
        this.playersRoll = playersRoll;
    }
}
