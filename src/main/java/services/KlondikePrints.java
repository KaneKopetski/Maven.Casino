package services;

import java.util.ArrayList;

public class KlondikePrints {


    public String klondikeWelcome() {
        return
                "****************************************************************\n" +
                "Welcome to:\n" +
                " ██╗  ██╗██╗      ██████╗ ███╗   ██╗██████╗ ██╗██╗  ██╗███████╗\n" +
                " ██║ ██╔╝██║     ██╔═══██╗████╗  ██║██╔══██╗██║██║ ██╔╝██╔════╝\n" +
                " █████╔╝ ██║     ██║   ██║██╔██╗ ██║██║  ██║██║█████╔╝ █████╗  \n" +
                " ██╔═██╗ ██║     ██║   ██║██║╚██╗██║██║  ██║██║██╔═██╗ ██╔══╝  \n" +
                " ██║  ██╗███████╗╚██████╔╝██║ ╚████║██████╔╝██║██║  ██╗███████╗\n" +
                " ╚═╝  ╚═╝╚══════╝ ╚═════╝ ╚═╝  ╚═══╝╚═════╝ ╚═╝╚═╝  ╚═╝╚══════╝\n" +
                "****************************************************************\n\n";
    }

    public String askInstructions() {
        return "Would you like to read the rules of the game before playing?\n" +
                "1.  Yes I would like that very much.\n" +
                "2.  I'm a pro so no thanks.\n";
    }

    public String displayInstructions() {
        return
                "+-+-+-+-+-+\n" +
                "|R|U|L|E|S|\n" +
                "+-+-+-+-+-+\n\n" +
                "1. A banker rolls five dice first and then the player will roll to beat the banker's combination.\n" +
                "2. Ties go to the banker.\n" +
                "3. The following combinations are sorted from highest to worse combination.\n\n" +
                "\t\tFive of a Kind\n" +
                "\t\tFour of a Kind\n" +
                "\t\tFull House (Three of a kind and a pair)\n" +
                "\t\tThree of a Kind\n" +
                "\t\tTwo pairs\n" +
                "\t\tOne pair\n" +
                "4. Money bet will be doubled if player wins.\n\n";
    }

    public String dealerRolls() {
        return
                "  / \\ / \\ / \\ / \\ / \\ / \\ / \\ / \\   / \\ / \\ / \\ / \\ \n" +
                " ( D | e | a | l | e | r | ' | s ) ( R | o | l | l )\n" +
                "  \\_/ \\_/ \\_/ \\_/ \\_/ \\_/ \\_/ \\_/   \\_/ \\_/ \\_/ \\_/ ";
    }

    public String playerRolls() {
        return
                "  / \\ / \\ / \\ / \\ / \\ / \\ / \\ / \\   / \\ / \\ / \\ / \\ \n" +
                " ( P | l | a | y | e | r | ' | s ) ( R | o | l | l )\n" +
                "  \\_/ \\_/ \\_/ \\_/ \\_/ \\_/ \\_/ \\_/   \\_/ \\_/ \\_/ \\_/ ";
    }

    public String asksBetAmount() {
        return "Feeling lucky?  How much you wanna bet?";
    }

    public String win() {
        return
                "  / \\ / \\ / \\   / \\ / \\ / \\ / \\ / \\ \n" +
                " ( Y | O | U ) ( W | I | N | ! | ! )\n" +
                "  \\_/ \\_/ \\_/   \\_/ \\_/ \\_/ \\_/ \\_/ ";
    }

    public String lose() {
        return
                "  / \\ / \\ / \\   / \\ / \\ / \\ / \\ \n" +
                " ( Y | o | u ) ( l | o | s | t )\n" +
                "  \\_/ \\_/ \\_/   \\_/ \\_/ \\_/ \\_/ ";
    }

    public ArrayList<String> printDice(ArrayList<Integer> dice) {
        ArrayList<String> diceArt = new ArrayList<>();

        for (Integer die : dice) {
            switch (die) {
                case 1:
                    diceArt.add("\n  ,------------,\n" +
                                  "  |            |\n" +
                                  "  |            |\n" +
                                  "  |     ██     |\n" +
                                  "  |            |\n" +
                                  "  |            |\n" +
                                  "  '------------'\n");
                    break;
                case 2:
                    diceArt.add(",------------,\n" +
                              "  |            |\n" +
                              "  |        ██  |\n" +
                              "  |            |\n" +
                              "  |  ██        |\n" +
                              "  |            |\n" +
                              "  '------------'\n");
                    break;
                case 3:
                    diceArt.add(",------------,\n" +
                              "  |        ██  |\n" +
                              "  |            |\n" +
                              "  |     ██     |\n" +
                              "  |            |\n" +
                              "  |  ██        |\n" +
                              "  '------------'\n");
                    break;
                case 4:
                    diceArt.add(",------------,\n" +
                              "  |            |\n" +
                              "  |  ██    ██  |\n" +
                              "  |            |\n" +
                              "  |  ██    ██  |\n" +
                              "  |            |\n" +
                              "  '------------'\n");
                    break;
                case 5:
                    diceArt.add(",------------,\n" +
                              "  |  ██    ██  |\n" +
                              "  |            |\n" +
                              "  |     ██     |\n" +
                              "  |            |\n" +
                              "  |  ██    ██  |\n" +
                              "  '------------'\n");
                    break;
                case 6:
                    diceArt.add(",------------,\n" +
                              "  |  ██    ██  |\n" +
                              "  |            |\n" +
                              "  |  ██    ██  |\n" +
                              "  |            |\n" +
                              "  |  ██    ██  |\n" +
                              "  '------------'\n");
                    break;
            }
        }
        return diceArt;
    }

    public String playAgain() {
        return  "Would you like to play again?\n" +
                "1. Another round\n" +
                "2. Lets go for another game\n";
    }

    public String anotherRound() {
        return "Let's GO!";
    }

    public String differentGame() {
        return "Thanks for playing Klondike!";
    }
}
