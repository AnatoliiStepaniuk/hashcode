package model;

public class AcceptedRide extends Ride {
    int actualStartTime;
    int actualFinishTime;

    public AcceptedRide(
            Position start,
            Position finish,
            int earliestStart,
            int latestFinish,
            int actualStartTime,
            int actualFinishTime,
            int id
    ) {
        super(start, finish, earliestStart, latestFinish, id);
        this.actualStartTime = actualStartTime;
        this.actualFinishTime = actualFinishTime;
    }

    public AcceptedRide(Ride ride, int actualStartTime, int actualFinishTime){
        super(ride);
        this.actualStartTime = actualStartTime;
        this.actualFinishTime = actualFinishTime;
    }
}
