package models.hands;

import java.util.ArrayList;

public class KlondikeDealerHand {

    //TODO: this should store what the dealers hand for Klondike is so that it can be compared to the players

    private ArrayList<Integer> dealersRoll;

    public ArrayList<Integer> getDealersRoll() {
        return this.dealersRoll;
    }

    public void setDealersRoll(ArrayList<Integer> dealersRoll) {
        this.dealersRoll = dealersRoll;
    }
}
