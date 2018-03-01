public class AcceptedRide extends Ride {
    int actualStep;
    int finishStep;

    public AcceptedRide(
            Position start,
            Position finish,
            int earliestStart,
            int latestFinish,
            int actualStep,
            int finishStep
    ) {
        super(start, finish, earliestStart, latestFinish);
        this.actualStep = actualStep;
        this.finishStep = finishStep;
    }
}
