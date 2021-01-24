package CAwOOP;

import java.util.Arrays;
import java.util.Random;

public class Universe {
    public final int size; // size of universe (4 if 4x4)
    public final int timeSteps;
    public final int states;

    public final Cell[][][] overTime; // all of the states of the universe
    public Cell[][] currentState;
    private int currentStep = 0;

    public Universe(int timeSteps, Cell[][] startState, int states) {
        startState[0][0].setReference(startState);
        this.timeSteps = timeSteps;
        this.states = states;
        this.size = startState.length;
        this.overTime = new Cell[timeSteps][size][size];

        overTime[0] = startState;
        setState(startState);
    }


    /**
     * Turns a 2d Cell array to a 2d int array of states.
     *
     * @param cellGrid the 2d Cell array to translate.
     * @return int representation of cellGrid.
     */
    public int[][] toArray(Cell[][] cellGrid) {
        int size = cellGrid.length;
        int[][] cellStates = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cellStates[i][j] = cellGrid[i][j].state;
            }
        }

        return cellStates;
    }

    /**
     * Turns universe state at a specific time to array of int cell states
     *
     * @param time time of universe state
     * @return int representation of time.
     */
    public int[][] toArray(int time) {
        if (time >= currentStep) {
            throw new RuntimeException(String.format("Universe object not advanced enough. " +
                                                             "Universe at time %d has not yet been generated.", time));
        }

        int[][] cellStates = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cellStates[i][j] = overTime[time][i][j].state;
            }
        }

        return cellStates;
    }

    /**
     * turns overTime to int array over time of cell states
     *
     * @return cell states over time
     */
    public int[][][] deepToArray() {
        int[][][] cellStatesOverTime = new int[timeSteps][size][size];
        for (int t = 0; t < timeSteps; t++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    cellStatesOverTime[t][i][j] = overTime[t][i][j].state;
                }
            }
        }

        return cellStatesOverTime;
    }

    /**
     * set new state for the universe
     *
     * @param state new state
     */
    public void setState(Cell[][] state) {
        currentState = state;
        overTime[currentStep] = state;

        state[0][0].setReference(state);
        currentStep++;
    }

    /**
     * advances universe, i.e next time step
     */
    public void advance() {

        Cell[][] nextState = new Cell[size][size]; //creates the next state
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                nextState[i][j] = currentState[i][j].nextState();
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

    /**
     * Create a GUI displaying the progression of the Universe.
     *
     * @param time  the starting time from which to animate.
     * @param delay the delay (in milliseconds). Setting the delay to 0 will display a still state.
     */
    public void animate(int time, int delay) { //animates universe
        new CanvasFrame(size * 10, this, time, delay);
    }

    public void animate(int time, int delay, int[][] colors) { //animates universe
        new CanvasFrame(size * 10, this, time, delay, colors);
    }
}
