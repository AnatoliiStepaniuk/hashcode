package mind.hash.model;

import java.util.Comparator;
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

  public int getScore()
  {
    Position current = new Position( 0, 0 );
    int currentStep = 0;

    acceptedRideList.sort( Comparator.comparingInt( ride -> ride.actualStartTime ) );

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
