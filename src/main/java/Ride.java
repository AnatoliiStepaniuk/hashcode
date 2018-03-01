import java.awt.*;

public class Ride {
    Position start;
    Position finish;
    int earliestStart;
    int latestFinish;

    public Ride(Position start, Position finish, int earliestStart, int latestFinish) {
        this.start = start;
        this.finish = finish;
        this.earliestStart = earliestStart;
        this.latestFinish = latestFinish;
    }

    public int getLength() {
        return Math.abs(start.x - finish.x) + Math.abs(start.y - finish.y);
    }
}
