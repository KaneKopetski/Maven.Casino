package services;

import java.util.ArrayList;
import java.util.Collections;

public class KlondikeService {

    private DiceService dice = new DiceService();

    public ArrayList<Integer> rollDiceFiveTimes(){

        ArrayList<Integer> rolls = new ArrayList<>();

        for(int i = 0; i < 5; i++) {
            //rolls.add(dice.rollDice());
        }
        return rolls;
    }

    public Integer onePair(ArrayList<Integer> dice) {
        Collections.sort(dice);
        for (int i = 0; i < 5; i++) {
            if(dice.get(i).equals(dice.get(i + 1)))
                return 1;
        }
        return 0;
    }

    public Integer twoPair(ArrayList<Integer> dice) {
        Collections.sort(dice);
        Integer pair1 = 0, pair2 = 0;

        // First Loop looks for the first pair going -> through the arraylist
        for (int i = 0; i < 5; i++) {
            if(dice.get(i).equals(dice.get(i + 1))) {
                pair1 = dice.get(i);
                break;
            }
        }
        // Second Loop looks for the first pair going <- through the arraylist
        for (int j = 5; j > 0; j--) {
            if(dice.get(j).equals(dice.get(j - 1))) {
                pair2 = dice.get(j);
                break;
            }
        }

        // If the first pair found (pair1) equals the second pair (pair2) then they are not two different pairs
        if (pair1.equals(pair2)) {
            return 0;
        }
        return 2;
    }

    public Integer threeOfAKind(ArrayList<Integer> dice) {
        Collections.sort(dice);
        for (int i = 0; i < 4; i++) {
            //  Checking if dice[i] == dice[i + 1] == dice[i + 2]
            if(dice.get(i).equals(dice.get(i + 1)) && dice.get(i).equals(dice.get(i + 2)))
                return 3;
        }
        return 0;
    }

    public Integer fullHouse(ArrayList<Integer> dice) {
        // No need to sort because each method bellow already sorts
        if(threeOfAKind(dice).equals(3) && twoPair(dice).equals(2))
            return 4;
        return 0;
    }

    public Integer fourOfAKind(ArrayList<Integer> dice) {
        Collections.sort(dice);
        for (int i = 0; i < 3; i++) {
            //  Checking if dice[i] == dice[i + 1] == dice[i + 2] == dice[i + 3]
            if(dice.get(i).equals(dice.get(i + 1)) && dice.get(i).equals(dice.get(i + 2)) && dice.get(i).equals(dice.get(i + 3)))
                return 5;
        }
        return 0;
    }

    public Integer fiveOfAKind(ArrayList<Integer> dice) {
        Collections.sort(dice);
        // If the dice[0] doesn't equal any of the other values in dice then return false
        for (int i = 1; i < 6; i++) {
            if (!dice.get(0).equals(dice.get(i)))
                return 6;
        }
        return 0;
    }

    public Boolean didPlayerWin(Integer player, Integer dealer) {
        return player > dealer;
    }


}
