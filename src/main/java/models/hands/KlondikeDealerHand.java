package models.hands;

import models.people.dealers.KlondikeDealer;

public class KlondikeDealerHand {

    //TODO: this should store what the dealers hand for Klondike is so that it can be compared to the players

    private Integer dealersPoint;

    public Integer getDealersPoint() {
        return dealersPoint;
    }

    public void setDealersPoint(Integer dealersPoint) {
        this.dealersPoint = dealersPoint;
    }
}