package com.company;

public abstract class Cell {

    public int[] pos;
    protected static Cell[][] reference;
    public int state;
    public static int size;
    protected boolean moore = true;

    public Cell(int[] pos , int state , boolean moore){
        this.pos = pos;
        this.state = state;
        this.moore = moore;
    }

    public Cell(int[] pos, int state) {
        this.pos = pos;
        this.state = state;
    }


    public void setReference(Cell[][] reference1) {
        reference = reference1;
        size = reference1.length;
    }

    public int[][] getNeighbors() { //default Neumann

        int[][] neighbors;
        int i = this.pos[0];
        int j = this.pos[1];

        if(moore){
            neighbors = new int[8][2];

            int count = 0;
            for(int I=-1;I<2; I++){
                for(int K=-1; K<2; K++){
                    if(I!=0 || K!=0){
                        neighbors[count] = new int[] {((i+I)%3+3)%3 ,((j+K)%3+3)%3};
                    }
                }
            }

        }
        else {
            neighbors = new int[4][2];

            neighbors[0] = new int[]{i, ((j - 1) % size + size) % size};
            neighbors[1] = new int[]{((i - 1) % (size + 1) + size) % size, j};
            neighbors[2] = new int[]{i, ((j + 1) % size + size) % size};
            neighbors[3] = new int[]{((i + 1) % size + size) % size, j};
        }
        return neighbors;
    }


    public Cell nextState(int[][] neighbors) {
        return this;
    }
}

