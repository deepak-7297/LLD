

public class Request {
    public Integer goToFloor;

    public Integer getGoToFloor() {
        return goToFloor;
    }

    public void setGoToFloor(Integer goToFloor) {
        this.goToFloor = goToFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Integer getFromFloor() {
        return fromFloor;
    }

    public void setFromFloor(Integer fromFloor) {
        this.fromFloor = fromFloor;
    }

    public Direction direction;
    public Integer fromFloor;


    public void callLiftToCurrentFloor(Integer floor){

    }
}
