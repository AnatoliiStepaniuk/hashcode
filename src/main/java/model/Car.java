package model;

import java.util.Comparator;
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

  public int getScore()
  {
    Position current = new Position( 0, 0 );
    int currentStep = 0;

    acceptedRideList.sort( Comparator.comparingInt( ride -> ride.actualStep ) );

    int score = 0;
    for( AcceptedRide acceptedRide : acceptedRideList )
    {
      score += acceptedRide.getLength();

      int stepsToStart = current.distanceTo( acceptedRide.start );
      if( (currentStep += stepsToStart) <= acceptedRide.earliestStart )
      {
        score += new Problem().bonus;
      }
    }

    return score;
  }
}
