import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class YatzyGame {
    int rollsLeft;
    int turns;
    int gameNo;
    Dice[] dice;

    public YatzyGame() {
        this.rollsLeft = 3;
        this.turns = 13;
        this.gameNo = 1;
        this.dice = new Dice[5];

        //for (Dice d: this.dice) {d = new Dice();}
        for (int i = 0; i < 5; i++) {
            this.dice[i] = new Dice();
        }
    }

    public int getRollsLeft(){return this.rollsLeft;}

    public int getGameNo(){return this.gameNo;}

    public int[] getValues(){
        //1.Creating a stream from dice array
        Stream<Dice> sDice = Stream.of(this.dice);

        //Mapping getValue function to dice stream
        IntStream sValues = sDice.map(Dice::getValue).mapToInt(Integer::intValue);

        //return the stream as an array of integers
        return sValues.toArray();
    }

    public void rollDice(){
        for (Dice d: this.dice){d.roll();}
        this.rollsLeft--;
        System.out.println("Rolls Left: " + this.rollsLeft);
    }
    public static void main(String[] args) {
        YatzyGame play = new YatzyGame();

        System.out.println("Current Scores: " + Arrays.toString(play.getValues()));

        play.rollDice();
        System.out.println("Current Scores: " + Arrays.toString(play.getValues()));
    }
}
