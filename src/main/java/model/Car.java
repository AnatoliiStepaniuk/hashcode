package model;

import java.util.List;

public class Car {
    List<AcceptedRide> acceptedRideList;

    public Car(List<AcceptedRide> acceptedRideList) {
        this.acceptedRideList = acceptedRideList;
    }

    public boolean canFulfill(Ride ride){
        int carStartTime = acceptedRideList.isEmpty() ? 0 : acceptedRideList.get(acceptedRideList.size()-1).actualFinishTime;
        Position carStartPosition = acceptedRideList.isEmpty() ? new Position(0, 0) : acceptedRideList.get(acceptedRideList.size() - 1).start;

        int timeAtStartPoint = carStartTime + carStartPosition.distanceTo(ride.start);

        // TODO if willGetAtStartPoint <= ride.startTime we will get bonus!

        int timeAtFinishPoint = timeAtStartPoint + ride.start.distanceTo(ride.finish);

        // TODO CAREFUL with constraints!!!
        if(timeAtFinishPoint > ride.latestFinish)
            return false;

        return true;
    }
}
