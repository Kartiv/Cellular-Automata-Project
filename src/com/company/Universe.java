package com.company;

import com.company.Cell;

import java.util.Random;

public class Universe {
    public int size;
    public boolean borders;
    private Cell[][] currentState;
    private int nSteps;
    public int[][][] overTime;
    private int currentStep = 0;

    public Universe(int size, int nSteps, Cell[][] startState) {
        this.nSteps=nSteps;
        this.size = size;
        this.borders = true;
        this.overTime = new int[nSteps][size][size];
        setState(startState);
    }

    public void setState(Cell[][] state){
        int[][] cellStates = new int[size][size];
        for(int i=0; i<size; i++){
            for(int j=0;j<size;j++){
                cellStates[i][j] = state[i][j].state;
            }
        }
        this.currentState = state;
        overTime[currentStep] = cellStates;
        state[0][0].setReference(state);
        currentStep++;
    }

    public void advance(){
        Cell[][] nextState = new Cell[size][size];
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                nextState[i][j] = currentState[i][j].nextState(currentState[i][j].getNeighbors());
            }
        }
        setState(nextState);
    }
    public int[][][] convertToInt(){
        int[][][] Blah = new int[currentStep][size][size];
        for(int t=0; t<currentStep; t++){
            for(int i=0; i<size; i++){
                for(int j=0; j<size; j++){
                    Blah[t][i][j] = overTime[t][i][j];
                }
            }
        }
        return Blah;
    }
}
