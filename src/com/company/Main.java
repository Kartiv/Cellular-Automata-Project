package com.company;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Cell[][] universe = new Cell[2][2];
        Random rand = new Random();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Cell temp = new TempCell(new int[]{i, j}, rand.nextInt(2));
                universe[i][j] = temp;
            }
        }
        Universe uni = new Universe(2, 10, universe);
        for (int i = 0; i < 9; i++) {
            uni.advance();
            System.out.println(Arrays.deepToString(uni.convertToInt()));
        }

        System.out.println(Arrays.deepToString(uni.convertToInt()));
    }
}
