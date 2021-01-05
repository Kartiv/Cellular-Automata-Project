package com.company;

public class Universe {
    public int size;
    public boolean borders;
    private Cell[][] currentState;
    public final int nSteps;
    public int[][][] overTime;

    public Cell[][][] overTimeCell;

    private int currentStep = 0;
    private CanvasFrame frame;

    public Universe(int nSteps, Cell[][] startState) {
        startState[0][0].setReference(startState);
        this.nSteps = nSteps;
        this.size = startState.length;
        this.borders = true;
        this.overTime = new int[nSteps][size][size];

        this.overTimeCell = new Cell[nSteps][size][size];

        overTime[0] = convertToInt(startState);

        overTimeCell[0] = startState;
        setState(startState);
    }

    public int[][] convertToInt(Cell[][] list){
        int[][] cellStates = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cellStates[i][j] = list[i][j].state;
            }
        }
        return cellStates;
    }
    public void setState(Cell[][] state) {
        int[][] cellStates = convertToInt(state);
        this.currentState = state;
        overTime[currentStep] = cellStates;

        overTimeCell[currentStep] = state;

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
        frame = new CanvasFrame(size, this, time, delay);
    }
}
