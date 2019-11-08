package models.hands;

import java.util.ArrayList;

public class KlondikeDealerHand {

    //TODO: this should store what the dealers hand for Klondike is so that it can be compared to the players

    private ArrayList<Integer> dealersPoint;

    public ArrayList<Integer> getDealersPoint() {
        return dealersPoint;
    }

    public void setDealersPoint(ArrayList<Integer> dealersPoint) {
        this.dealersPoint = dealersPoint;
    }
}
