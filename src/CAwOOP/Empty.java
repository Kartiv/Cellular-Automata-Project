package CAwOOP;
import java.util.Random;
public class Empty extends Cell{

    public int intentState =0;
    private static float preyChance = 0.25f;
    private static float predatorChance = 0.2f;

    public Empty(int[] pos){
        super(pos,0);
    }


    private int[] neighborCounts(){
        Cell[] neighbors = getNeighbors();
        int predatorCount = 0;
        int preyCount = 0;

        for(int i=1; i<neighbors.length; i++){
            if(neighbors[i] instanceof Prey){
                preyCount ++;
            }
            else if(neighbors[i] instanceof Predator){
                predatorCount++;
            }
        }

        return new int[] {predatorCount, preyCount} ;
    }

    @Override
    public Cell nextState() {
        if(pos[0] ==0 || pos[1]==0 || pos[0]==universeSize-1 || pos[1]==universeSize-1){
            return this;
        }
        if(intentState==0){
            Random random = new Random();

            float s = random.nextFloat();

            int[] counts = neighborCounts();
            float preyMultiplier = counts[1];
            float predatorMultiplier = counts[0];


            if (s<preyChance*preyMultiplier) {
                return new Prey(this.pos);
            }
            else if(s<preyChance*preyMultiplier + predatorChance*predatorMultiplier){
                return new Predator(this.pos);
            }
            return this;
        }
        else{
            if(intentState==2){
                return new Predator(this.pos);
            }
            else if(intentState==1){
                return new Prey(this.pos);
            }
        }
        return this;
    }
}
