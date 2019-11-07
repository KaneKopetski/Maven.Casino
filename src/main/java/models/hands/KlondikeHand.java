package models.hands;

import models.gamecomponents.Dice;

import java.util.ArrayList;
import java.util.TreeMap;

public class KlondikeHand extends Hand {

    private Integer playersPoint;

    public Integer getPlayersPoint() {
        return playersPoint;
    }

    public void setPlayersPoint(Integer playersPoint) {
        this.playersPoint = playersPoint;
    }
}
