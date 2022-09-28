import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Lift {
    public Integer maxFloor;

    public Integer minFloor;
    public LiftState liftState;

    public Direction direction;
    public Integer currentFloor;
    public boolean isDoorOpen;

    public PriorityQueue<Integer> upRequest = new PriorityQueue<Integer>();
    public PriorityQueue<Integer> downRequest = new PriorityQueue<Integer>(Comparator.reverseOrder());


    public Integer getMaxFloor() {
        return maxFloor;
    }

    public void setMaxFloor(Integer maxFloor) {
        this.maxFloor = maxFloor;
    }

    public LiftState getLiftState() {
        return liftState;
    }

    public void setLiftState(LiftState liftState) {
        this.liftState = liftState;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Integer getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(Integer currentFloor) {
        this.currentFloor = currentFloor;
    }

    public boolean isDoorOpen() {
        return isDoorOpen;
    }


    public Integer getMinFloor() {
        return minFloor;
    }

    public void setMinFloor(Integer minFloor) {
        this.minFloor = minFloor;
    }


    public void setDoorOpen(boolean doorOpen) {
        isDoorOpen = doorOpen;
    }

    public PriorityQueue<Integer> getUpRequest() {
        return upRequest;
    }

    public void setUpRequest(PriorityQueue<Integer> upRequest) {
        this.upRequest = upRequest;
    }

    public void addToUpRequest(Integer floor) throws Exception {
        if(floor < getMaxFloor())
            throw new Exception("Cant go beyond building floor");

        upRequest.add(floor);
        start();
    }

    public void addToDownRequest(Integer floor) throws Exception {
        if(floor < getMinFloor())
            throw new Exception("Cant go beyond below min floor");

        downRequest.add(floor);
        start();
    }

    public PriorityQueue<Integer> getDownRequest() {
        return downRequest;
    }

    public void setDownRequest(PriorityQueue<Integer> downRequest) {
        this.downRequest = downRequest;
    }


    public void goToFloor(Request request){
        if(request.getDirection() == Direction.UP){
            upRequest.add(request.getGoToFloor());
        }else{
            downRequest.add(request.getGoToFloor());
        }
    }

    public Lift(Structure structure){
        setCurrentFloor(structure.getMinFloor());
        setMaxFloor(structure.getMaxFloor());
    }

    public void start(){
        while(true){
            if(!upRequest.isEmpty()){
                changeDirection();
                processRequest(upRequest);
            }

            if(!downRequest.isEmpty()){
                changeDirection();
                processRequest(downRequest);
            }

            if(upRequest.isEmpty() || downRequest.isEmpty()){
                setLiftState(LiftState.IDLE);
                setDirection(Direction.HOLD);
                break;
            }
        }
    }

    private void changeDirection(){
        setDirection(getDirection().equals(Direction.DOWN) ? Direction.UP : Direction.DOWN);
    }

    private void processRequest(PriorityQueue<Integer> requestFloor){
        while(!requestFloor.isEmpty()){
            System.out.println("Lift has reached floor" + requestFloor.peek());
            currentFloor = requestFloor.poll();
        }
    }
}
