package io.zipcoder.casino.GameComponents;

import models.gamecomponents.Dice;
import models.games.CrapsGame;
import models.people.players.Player;
import org.junit.Test;
import services.DiceService;

public class testRollAndSum {
    @Test
    public void rollAndSumTest() {
        Dice dice = new Dice();
        Player player = new Player();
        CrapsGame crapsGame = new CrapsGame(player);
        int actual = crapsGame.rollAndSum(dice);
        System.out.println(actual);
    }

    @Test
    public void determineWinTest() {
        Dice dice = new Dice();
        Player player = new Player();
        CrapsGame crapsGame = new CrapsGame(player);
        Boolean actual = crapsGame.determineWin();
        System.out.println("result of game is:" + actual);


    }



}