package mind.hash.model;

public class Ride {
    public Position start;
    public Position finish;
    public int earliestStart;
    public int latestFinish;
    public int id;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ride ride = (Ride) o;

        if (earliestStart != ride.earliestStart) return false;
        if (latestFinish != ride.latestFinish) return false;
        if (id != ride.id) return false;
        if (start != null ? !start.equals(ride.start) : ride.start != null) return false;
        return finish != null ? finish.equals(ride.finish) : ride.finish == null;
    }

    @Override
    public int hashCode() {
        int result = start != null ? start.hashCode() : 0;
        result = 31 * result + (finish != null ? finish.hashCode() : 0);
        result = 31 * result + earliestStart;
        result = 31 * result + latestFinish;
        result = 31 * result + id;
        return result;
    }

    @Override
    public String toString()
    {
        return "ride from " + start + " to " + finish + ", earliest start " + earliestStart + ", latest finish " + latestFinish;
    }
}
