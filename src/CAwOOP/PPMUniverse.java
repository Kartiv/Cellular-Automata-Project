package CAwOOP;

import java.util.Arrays;

public class PPMUniverse extends Universe {


    public PPMUniverse(int timeSteps, Cell[][] startState, int states) {
        super(timeSteps, startState, states);
    }

    @Override
    public void advance() {
        Cell[][] nextState = new Cell[size][size]; //creates the next state
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (currentState[i][j] instanceof Predator){
                    nextState[i][j] = currentState[i][j].nextState();
                }
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (currentState[i][j] instanceof Prey){
                    nextState[i][j] = currentState[i][j].nextState();
                }
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (currentState[i][j] instanceof Empty){
                    nextState[i][j] = currentState[i][j].nextState();
                }
            }
        }
        System.out.println(
                Arrays.deepToString(toArray(nextState))
                        .replace("[[", " [")
                        .replace("]]", "\n")
                        .replace(" [", "")
                        .replace("]", "\n")
                        .replace(",", "")
        );

        setState(nextState); //advances to the next state
}
}
