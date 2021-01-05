package com.company;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int size = 3;
        Cell[][] universe = new Cell[size][size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Cell temp = new TempCell(new int[]{i, j}, rand.nextInt(2), true);
                universe[i][j] = temp;
            }
        }
        Universe uni = new Universe(10, universe);
        for (int i = 0; i < 9; i++) {
            uni.advance();
            uni.animate(9,0);
        }

        System.out.println(Arrays.deepToString(uni.overTime));
    }
}
