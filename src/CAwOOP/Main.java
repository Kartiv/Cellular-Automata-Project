package CAwOOP;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int size = 5;
        int states = 3;
        int timeSteps = 10;

        Cell[][] universe = new Cell[size][size];
        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                universe[i][j] = new TempCell(new int[]{i, j}, rand.nextInt(states));
            }
        }

        Universe uni = new Universe(timeSteps + 1, universe, states);
        for (int i = 0; i < timeSteps; i++) {
            uni.advance();
        }

        uni.animate(0, 500);
        System.out.println("Universe over time: " + Arrays.deepToString(uni.deepToArray())
                .replace("[[", "[")
                .replace("]], ", "\n")
                .replace("[", "\n")
                .replace("], ", "")
                .replace("]]]", "")
        );
    }
}
