import java.util.ArrayList;
import java.util.Objects;

public class Structure {
    public ArrayList<Lift> lifts;

    public Integer maxFloor;
    public Integer minFloor;

    public Integer getMaxFloor() {
        return maxFloor;
    }

    public void setMaxFloor(Integer maxFloor) {
        this.maxFloor = maxFloor;
    }

    public Integer getMinFloor() {
        return minFloor;
    }

    public void setMinFloor(Integer minFloor) {
        this.minFloor = minFloor;
    }

    public ArrayList<Lift> getLifts() {
        return lifts;
    }

    public void setLifts(ArrayList<Lift> lifts) {
        this.lifts = lifts;
    }

    public Structure(Integer maxFloor, Integer minFloor){
        this.maxFloor = maxFloor;
        this.minFloor = minFloor;
    }

    public void installLifts(int noOfLift){
        for(int i=0;i<noOfLift; i++){
            Lift lift = new Lift(this);
            lifts.add(lift);
        }
    }
}
