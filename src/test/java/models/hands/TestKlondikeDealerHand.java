package models.hands;

import models.hands.KlondikeDealerHand;
import models.hands.KlondikeHand;
import models.people.dealers.KlondikeDealer;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class TestKlondikeDealerHand {

    KlondikeDealerHand klondikeHand;
    ArrayList<Integer> rolls = new ArrayList<>();

    @Test
    public void testGetDealersRoll() {
        klondikeHand = new KlondikeDealerHand();

        rolls.add(2);
        rolls.add(3);
        rolls.add(3);
        rolls.add(2);
        rolls.add(3);

        klondikeHand.setDealersRoll(rolls);
        Assert.assertEquals(rolls, klondikeHand.getDealersRoll());
    }
}
