package com.company;

import com.company.Cell;

import java.util.Random;

public class Universe {
    public int size;
    public boolean borders;
    private Cell[][] currentState;
    private int nSteps;
    public Cell[][][] overTime;
    private int currentStep = 0;

    public Universe(int size, int nSteps) {
        this.nSteps=nSteps;
        this.size = size;
        this.borders = true;
        this.overTime = new Cell[nSteps][size][size];
        setState(createUniverse());
    }
    public Universe(int size, int nSteps, Cell[][] startState) {
        this.nSteps=nSteps;
        this.size = size;
        this.borders = true;
        this.overTime = new Cell[nSteps][size][size];
        setState(startState);
    }

    public void setBorders(String borders){ //set borders **useless***
        if (borders == "cyclic"){
            this.borders = true;
        }
        else if ((borders == "constant" ) || (borders == "const")){
            this.borders = false;
        }
    }
    public void setState(Cell[][] state){
        this.currentState = state;
        overTime[currentStep] = state;
        state[0][0].setReference(state);
        currentStep++;
    }

    public Cell[][] createUniverse() {
        Random rand = new Random();
        int p = rand.nextInt(2);
        Cell[][] uni = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int k = 0; k < size; k++) {
                int[] temp = {i, k};

                uni[i][k] = new Cell(temp, rand.nextInt(2)); /////////
            }
        }
        return uni;
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
    

    public int[][][] blah(){
        int[][][] Blah = new int[currentStep][size][size];
        for(int t=0; t<currentStep; t++){
            for(int i=0; i<size; i++){
                for(int j=0; j<size; j++){
                    Blah[t][i][j] = overTime[t][i][j].state;
                }
            }
        }
        return Blah;
    }




}
