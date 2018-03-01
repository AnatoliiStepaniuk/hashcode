package mind.hash.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Car {
    List<AcceptedRide> acceptedRideList;

    public Car(){
        acceptedRideList = new ArrayList<>();
    }

    public Car(List<AcceptedRide> acceptedRideList) {
        this.acceptedRideList = acceptedRideList;
    }

    public boolean canFulfill(Ride ride){
        int carStartTime = getAvailableTime();
        Position carStartPosition = getAvailableStartPosition();

        int timeAtStartPoint = carStartTime + carStartPosition.distanceTo(ride.start);

        // TODO if willGetAtStartPoint <= ride.startTime we will get bonus!

        int timeAtFinishPoint = timeAtStartPoint + ride.start.distanceTo(ride.finish);

        // TODO CAREFUL with constraints!!!
        if(timeAtFinishPoint > ride.latestFinish)
            return false;

        return true;
    }

    public int getAvailableTime(){
        return acceptedRideList.isEmpty() ? 0 : acceptedRideList.get(acceptedRideList.size()-1).actualFinishTime;
    }

    public Position getAvailableStartPosition(){
        return acceptedRideList.isEmpty() ? new Position(0, 0) : acceptedRideList.get(acceptedRideList.size() - 1).start;
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

  public void add(Ride ride){
      int actualStartTime = getAvailableTime() + getAvailableStartPosition().distanceTo(ride.start);
      int actualFinishTime = actualStartTime + ride.start.distanceTo(ride.finish);
      AcceptedRide acceptedRide = new AcceptedRide(ride, actualStartTime, actualFinishTime);
      acceptedRideList.add(acceptedRide);
  }

    public String printAcceptedRides() {
        return this.acceptedRideList.stream()
                .map(acceptedRide -> acceptedRide.id)
                .map(Object::toString)
                .collect(Collectors.joining( " " ));
    }
}
