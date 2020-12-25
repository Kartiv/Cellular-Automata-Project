package com.company;

public abstract class Cell {
    public int[] pos;
    public static Cell[][] reference;
    public int state;//////////////////////////////

    public Cell(int[] pos, int state){
        this.pos = pos;
        this.state=state;
    }

    public void setReference(Cell[][] reference1){
        reference = reference1;
    }

    public int[][] getNeighbors(){
        return new int[][] {{}};
    }


    public Cell nextState(int [][] neighbors){

        this.state = state+1;
        return this;
    }
}
