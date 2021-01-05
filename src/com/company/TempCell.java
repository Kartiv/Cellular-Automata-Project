package com.company;

public class TempCell extends Cell {

    public TempCell(int[] pos, int state, boolean moore){
        super(pos,state,moore);
    }

    public TempCell(int[] pos, int state) {
        super(pos, state);
    }



    @Override
    public Cell nextState(int[][] neighbors) {
        return new TempCell(pos, (reference[neighbors[0][0]][neighbors[0][1]].state + 1)%2);
    }

}
