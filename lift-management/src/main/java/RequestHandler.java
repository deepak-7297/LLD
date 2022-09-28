

import javax.jws.Oneway;
import java.util.*;
import java.util.PriorityQueue;

public class RequestHandler {
    public Queue<Request> pendingRequest;
    public Structure structure;

    public RequestHandler(Structure structure){
        this.structure = structure;
    }

    public void startProcessingRequest() throws Exception {
        for(Request request: pendingRequest){
            boolean liftAssigned = assignIfLiftOnRequestedFloor(request);
            if(liftAssigned)
                continue;

            assignClosestLift(request);
        }
    }


    public Queue<Request> getPendingRequest() {
        return pendingRequest;
    }

    public void setPendingRequest(Queue<Request> pendingRequest)  throws Exception {
        this.pendingRequest = pendingRequest;
        startProcessingRequest();
    }

    public void addRequest(Request request)  throws Exception {
        pendingRequest.add(request);
        startProcessingRequest();
    }

    private boolean assignIfLiftOnRequestedFloor(Request request) throws Exception {
        for(Lift lift : structure.getLifts()){
            if(lift.getCurrentFloor().equals(request.getFromFloor()) && lift.getLiftState().equals(LiftState.IDLE)){
                lift.setDoorOpen(true);
                if(request.getDirection().equals(Direction.UP)){
                    lift.addToUpRequest(request.getGoToFloor());
                }
                else{
                    lift.addToDownRequest(request.getGoToFloor());
                }

                return true;
            }
        }
        return false;
    }

    private void assignClosestLift(Request request) throws Exception {
        PriorityQueue<AbstractMap.SimpleEntry<Integer, Lift>> distanceToLift =
                new PriorityQueue<>((a, b) -> Integer.compare(a.getKey(), b.getKey()));

        for(Lift lift: structure.getLifts()){
            AbstractMap.SimpleEntry<Integer, Lift> map = new AbstractMap.SimpleEntry<Integer, Lift>(calculateDistance(request, lift), lift);
            distanceToLift.add(map);
        }

        Lift lift = distanceToLift.peek().getValue();
        if(request.getDirection().equals(Direction.UP)){
            lift.addToUpRequest(request.getGoToFloor());
        }
        else{
            lift.addToDownRequest(request.getGoToFloor());
        }
    }


    private boolean floorAlreadyCrossed(Request request, Lift lift){
        if(lift.getDirection().equals(Direction.UP)){
            return Integer.compare(request.getFromFloor(), lift.getCurrentFloor()) < 0;
        }
        else {
            return Integer.compare(request.getFromFloor(), lift.getCurrentFloor()) < 0;
        }
    }

    private int calculateDistance(Request request, Lift lift){
        Integer distance;
        if(lift.getDirection().equals(Direction.UP))
            distance = (lift.getMaxFloor() - request.getFromFloor());
        else
            distance = (request.getFromFloor() - lift.getMinFloor());

        if(floorAlreadyCrossed(request, lift))
            return distance*2;
        else
            return distance;
    }
}
