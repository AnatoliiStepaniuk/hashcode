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
}
