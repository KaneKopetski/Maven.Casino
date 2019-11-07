package io.zipcoder.casino;

import models.games.GoFishGame;
import models.people.dealers.Dealer;
import models.people.players.GoFishPlayer;
import models.people.players.Player;
import org.junit.Test;

public class TestGoFishGame
{
    Player player = new Player();
    Dealer dealer = new Dealer("","",8.0);
    GoFishGame goFishGame = new GoFishGame(player);

    @Test
    public void testGame()
    {
        goFishGame.getMenu();

    }
}
