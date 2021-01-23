package CAwOOP;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int size = 15;
        int states = 3;
        int timeSteps = 20;

        // Generate initial starting state
        Cell[][] universe = new Cell[size][size];
        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(i==0 || j==0 || i==size-1 || j==size-1){
                    universe[i][j] = new Empty(new int[]{i, j});
                }
                else{
                    float s = rand.nextFloat();
                    if(s<0.3){
                        universe[i][j] = new Prey(new int[]{i,j});
                    }
                    else if (s<0.5){
                        universe[i][j] = new Predator(new int[]{i,j});
                    }
                    else{
                        universe[i][j] = new Empty(new int[]{i,j});
                    }
                }
            }
        }

        // BE GOD (haha get it? yaani create the universe...)
        Universe uni = new PPMUniverse(timeSteps + 1, universe, states);
        for (int i = 0; i < timeSteps; i++) {
            uni.advance();
        }

        // Animate
        uni.animate(0, 500);
    }

}
