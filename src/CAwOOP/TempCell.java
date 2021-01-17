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
    public Cell nextState() {
        return new TempCell(pos, (getNeighbors()[0].state + 1) % 3);
    }
}
