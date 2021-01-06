package CAwOOP;

public abstract class Cell {

    public static int universeSize;
    protected static Cell[][] reference;
    public final int[] pos;
    public final int state;

    public Cell(int[] pos, int state) {
        this.pos = pos;
        this.state = state;
    }

    public void setReference(Cell[][] newReference) {
        reference = newReference;
        universeSize = newReference.length;
    }

    /**
     * Moore-Neighborhood search with radius 1.
     *
     * @return array of the neighbors' positions.
     */
    public Cell[] getNeighbors() {

        Cell[] neighbors = new Cell[8];
        int i = this.pos[0];
        int j = this.pos[1];
        int s = universeSize;

        int count = 0;
        for (int I = -1; I < 2; I++) {
            for (int K = -1; K < 2; K++) {
                if (I != 0 || K != 0) {
                    neighbors[count++] = reference[((i + I) % s + s) % s][((j + K) % s + s) % s];
                }
            }
        }

        return neighbors;
    }

    public Cell nextState(Cell[] neighbors) {
        return this;
    }
}

