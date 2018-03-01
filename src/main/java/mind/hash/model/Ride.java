package mind.hash.model;

public class Ride {
    Position start;
    Position finish;
    int earliestStart;
    int latestFinish;
    int id;

    public Ride(Position start, Position finish, int earliestStart, int latestFinish, int id) {
        this.start = start;
        this.finish = finish;
        this.earliestStart = earliestStart;
        this.latestFinish = latestFinish;
        this.id = id;
    }

    public int getLength() {
        return start.distanceTo( finish );
    }

    @Override
    public String toString()
    {
        return "ride from " + start + " to " + finish + ", earliest start " + earliestStart + ", latest finish " + latestFinish;
    }
}
