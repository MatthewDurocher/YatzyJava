import java.util.*;

public class YatzyEngine {

    YatzyGame game;

    public YatzyEngine(){
        game = new YatzyGame();
    }

    private int sumDice() {
        return Arrays.stream(this.game.getValues()).sum();
    }

    public int scoreNo(int n){
        int[] list = this.game.getValues());

        int noCount = Collections.frequency(list, n);
        int points = noCount * n;
        System.out.println("You scored: "+points+" pts");
        return points;
    };

    public int score3Kind() {
        boolean condition = false;

        Set<Integer> uniqueValues = new HashSet<>();

        Arrays.stream(this.game.getValues()).forEach(uniqueValues::add);

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

        System.out.println(Arrays.toString(play.game.getValues()));
        play.game.rollDice();
        System.out.println(Arrays.toString(play.game.getValues()));

        System.out.println(play.scoreNo(1));

        System.out.println(play.scoreNo(6));

    }

}
