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

    public Ride(Ride other){
        this.start = other.start;
        this.finish = other.finish;
        this.earliestStart = other.earliestStart;
        this.latestFinish = other.latestFinish;
        this.id = other.id;
    }

    public int getLength() {
        return start.distanceTo( finish );
    }
}
