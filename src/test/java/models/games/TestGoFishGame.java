package models.games;

import models.gamecomponents.Card;
import models.gamecomponents.CardValue;
import models.gamecomponents.DeckOfCards;
import models.games.GoFishGame;
import models.people.dealers.Dealer;
import models.people.players.GoFishPlayer;
import models.people.players.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class TestGoFishGame
{
    Player player = new Player();
    GoFishGame goFishGame = new GoFishGame(player);

    ArrayList<CardValue> handValue ;
    private DeckOfCards stock = new DeckOfCards();

    @Before
    public void setup()
    {
      //  Card card = new Card(, DIAMOND);
    }

    @Test
    public void TestcountOccurrence() {
        // Given
       // CardValue valueToEvaluate = handValue.get(0);
       // Integer expected = 1;

        //CardValue = ;


        // When
    //   Integer actual = goFishGame.getCount(valueToEvaluate, handValue);
              ;

        // Then
    //  Assert.assertEquals(expected, actual);
    }


}
