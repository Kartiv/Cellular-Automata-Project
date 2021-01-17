package CAwOOP;

public class TempCell extends Cell {

    public TempCell(int[] pos, int state) {
        super(pos, state);
    }

    @Override
    public Cell[] getNeighbors() {
        return super.getNeighbors();
    }

    @Override
    public Cell nextState(Cell[] neighbors) {
        return new TempCell(pos, (neighbors[0].state + 1) % 3);
    }
}
