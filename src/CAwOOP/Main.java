package CAwOOP;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int size = 5;
        int states = 3;
        int timeSteps = 10;

        // Generate initial starting state
        Cell[][] universe = new Cell[size][size];
        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                universe[i][j] = new Prey(new int[]{i, j});
            }
        }

        // BE GOD (haha get it? yaani create the universe...)
        Universe uni = new Universe(timeSteps + 1, universe, states);
        for (int i = 0; i < timeSteps; i++) {
            uni.advance();
        }

        // Animate
        uni.animate(0, 500);
    }

}
