/*
@author: Matthew Durocher
 */

import java.util.Random;

public class Dice {
    int value;
    boolean kept;
    Random number = new Random();
    public Dice() {
        this.value = 1;
        this.kept = false;
    }

    private int getValue() {
        return this.value;
    }

    private boolean isKept(){
        return this.kept;
    }

    public void roll() {
        this.value = number.nextInt(1,6);
        System.out.println("Die rolled:" + value + "\n");
    }

    public static void main(String[] args) {
        Dice myDice = new Dice();
        myDice.roll();

        System.out.println("Die value is: " + myDice.getValue());
        System.out.println("Die is kept: " + myDice.isKept());
    }

}
