package model;

import java.util.List;

public class Car {
    List<AcceptedRide> acceptedRideList;

    public Car(List<AcceptedRide> acceptedRideList) {
        this.acceptedRideList = acceptedRideList;
    }

    public boolean canFulfill(Ride ride){
        // TODO when will finish? is it <= ride finish time?
//        int startTime = acceptedRideList.isEmpty() ?
        return true;
    }
}
