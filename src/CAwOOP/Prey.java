package CAwOOP;

import java.util.Arrays;

public class Prey extends Cell {

    public boolean dead = false;

    public Prey(int[] pos) {
        super(pos, 1);
    }

    private float[] predatorSearch() {

        int north = 0;
        int south = 0;
        int east = 0;
        int west = 0;

        for (int i = 1; i < 3; i++) { // 3 = r+1 if we want to make it more general later
            for (int j = -i; j < i + 1; j++) {

                if (pos[0] + j >= 0 && pos[0] + j < universeSize && pos[1] + i < universeSize) {
                    if (reference[pos[1] + i][pos[0] + j].state == 2) {
                        north += 1;
                    }
                }

                if (pos[1] + j >= 0 && pos[1] + j < universeSize && pos[0] + i < universeSize) {
                    if (reference[pos[1] + j][pos[0] + i].state == 2) {
                        east += 1;
                    }
                }

                if (pos[0] + j >= 0 && pos[1] - i >= 0 && pos[1] - i < universeSize && pos[0] + j < universeSize) {
                    if (reference[pos[1] - i][pos[0] + j].state == 2) {
                        south += 1;
                    }
                }

                if (pos[0] - j >= 0 && pos[1] + i < universeSize && pos[0] - j < universeSize) {
                    if (reference[pos[1] + i][pos[0] - j].state == 2) {
                        west += 1;
                    }
                }
            }
        }

        north += 0.1;
        east += 0.2;
        south += 0.3;
        float[] list = {north, east, south, west};
        Arrays.sort(list);
        return (list);
    }


    @Override
    public Cell[] getNeighbors() {
        // von neumann neighborhood
        Cell[] neighbors = new Cell[4];
        int i = this.pos[0];
        int j = this.pos[1];

        neighbors[0] = reference[i][j - 1];
        neighbors[1] = reference[i - 1][j];
        neighbors[2] = reference[i][j + 1];
        neighbors[3] = reference[i + 1][j];
        return neighbors;
    }

    @Override
    public Cell nextState() {

        if (dead) {
            return new Predator(this.pos);
        }
        Cell[] neighbors = getNeighbors();
        float[] intentArray = predatorSearch();

        for (int i = 3; i >= 0; i--) {
            Cell temp = neighbors[(int) (10 * (intentArray[i] - Math.floor(intentArray[i])))];
            if (temp instanceof Empty) {
                if (temp.pos[0] == 0 || temp.pos[1] == 0 || temp.pos[0] == universeSize - 1 || temp.pos[1] == universeSize - 1) {
                    return this;
                } else {
                    if (((Empty) temp).intentState < 1) {
                        ((Empty) temp).intentState = 1;
                    }
                    return new Empty(this.pos);
                }
            }
        }
        return this;
    }
}
