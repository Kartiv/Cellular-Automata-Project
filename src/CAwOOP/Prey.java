package CAwOOP;

public class Prey extends Cell {


    public int moveIntention = 0; //for empty cells to use

    public Prey(int[] pos) { //why the fuck cant i set my own state reeeeeeeeeee
        this.pos = pos;
        this.state = 1;
    }



    private int[] predatorSearch(){

        int north = 0;
        int south = 0;
        int east = 0;
        int west = 0;

        for(int i = 1; i<3; i++){ //3 = r+1 if we want to make it more general later
            for(int j=-i; j<i+1; j++){
                if(reference[pos[1] + i][pos[0] + j].state == 2){
                    north+=1;
                }
                if(reference[pos[1] + j][pos[0] + i].state == 2){
                    east+=1;
                }
                if(reference[pos[1] - i][pos[0] + j].state == 2){
                    south+=1;
                }
                if(reference[pos[1] + i][pos[0] - j].state == 2){
                    west+=1;
                }
            }
        }

        return(new int[] {north, east, south, west});
    }


    @Override
    public Cell[] getNeighbors() {

        // von neumann neighborhood


    }

    @Override
    public Cell nextState() {

        int[] predatorList = predatorSearch();

        //find a place you can move to


    }
}
