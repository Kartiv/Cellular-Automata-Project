package CAwOOP;

public class Universe {
    public final int size;
    public final boolean borders;
    public final int timeSteps;
    public final int states;

    public final Cell[][][] overTime;
    private Cell[][] currentState;
    private int currentStep = 0;

    public Universe(int timeSteps, Cell[][] startState, int states) {
        startState[0][0].setReference(startState);
        this.timeSteps = timeSteps;
        this.states = states;
        this.size = startState.length;
        this.borders = true;
        this.overTime = new Cell[timeSteps][size][size];

        overTime[0] = startState;
        setState(startState);
    }

    public int[][] toArray(Cell[][] cellGrid) {
        int[][] cellStates = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cellStates[i][j] = cellGrid[i][j].state;
            }
        }

        return cellStates;
    }

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

    public void setState(Cell[][] state) {
        currentState = state;
        overTime[currentStep] = state;

        state[0][0].setReference(state);
        currentStep++;
    }

    public void advance() {
        Cell[][] nextState = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                nextState[i][j] = currentState[i][j].nextState(currentState[i][j].getNeighbors());
            }
        }
        setState(nextState);
    }

    public void animate(int time, int delay) {
        new CanvasFrame(size * 10, this, time, delay);
    }
}
