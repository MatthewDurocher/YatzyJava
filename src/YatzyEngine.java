import java.util.*;

public class YatzyEngine {

    YatzyGame game;

    public YatzyEngine(){
        game = new YatzyGame();
    }

    private int sumDice() {
        return this.game.getValues().sum();
    }

    public int scoreNo(int n){

        int count = 0;

        for (Integer i : this.game.getValues().toArray()){
            if (i == n) {count++;}
        }
        int points = count * n;

        System.out.println("You scored: "+points+" pts");

        return points;
    };

    public int score3Kind() {
        boolean condition = false;

        Set<Integer> uniqueValues = new HashSet<>();


        condition = (uniqueValues.size() <= 3);

        return condition ? this.sumDice() : 0;
    }

    public int score4Kind() {
        boolean condition = false;

        return condition ? this.sumDice() : 0;
    }

    public int scoreChance() {
        boolean condition = false;

        return condition ? this.sumDice() : 0;
    }

    public int scoreFullHouse() {
        boolean condition = false;

        return condition ? 25 : 0;
    }

    public int scoreSmallStraight() {
        boolean condition = false;

        return condition ? 30 : 0;
    }

    public int scoreLargeStraight() {
        boolean condition = false;

        return condition ? 40 : 0;
    }

    public int scoreYatzy() {
        boolean condition = false;

        return condition ? 50 : 0;
    }

    public static void main(String[] args) {
        YatzyEngine play = new YatzyEngine();

        System.out.println(Arrays.toString(play.game.getValues().toArray()));

        play.game.rollDice();

        System.out.println("Sum of dice values: " + play.sumDice());

        System.out.println(Arrays.toString(play.game.getValues().toArray()));

        System.out.println("Scoring Ones:");
        play.scoreNo(1);

        System.out.println("Scoring Sixes:");
        play.scoreNo(6);

    }

}
