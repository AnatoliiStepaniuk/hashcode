package mind.hash.model;

import mind.hash.model.Position;
import mind.hash.model.Ride;

import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Optimizer {
    public static final Position START = new Position(0, 0);

    TreeSet<Ride> getSortedRides(
            Position currentPosition,
            List<Ride> rides,
            final int currentStep,
            final int stepsLeft
    ) {
        if (currentPosition == null) {
            currentPosition = START;
        }
        Position finalStart = currentPosition;
        TreeSet<Ride> sortedRides = new TreeSet<>(
                (r1, r2) -> {
                    int scoreRide1 = finalStart.distanceTo(r1.start);
                    int scoreRide2 = finalStart.distanceTo(r2.start);
                    scoreRide1 += currentStep - r1.earliestStart;
                    scoreRide2 += currentStep - r2.earliestStart;
                    scoreRide1 -= r1.getLength();
                    scoreRide2 -= r2.getLength();
                    return Integer.compare(scoreRide1, scoreRide2);
                }
        );
        sortedRides.addAll(
                rides.stream().filter(
                        ride -> ride.latestFinish < currentStep || ride.getLength() < stepsLeft
                ).collect(Collectors.toList())
        );
        return sortedRides;
    }

//    List<RidePath> getPerspectivePath(TreeSet<Ride> sortedRides, int steps, int cars) {
//        List<RidePath> perspectivePath = new ArrayList<>();
//        int i = 0;
//        for (Ride ride: sortedRides) {
//            if (i == cars) {
//                break;
//            } else {
//                // removing perspective ride
//                sortedRides.remove(ride);
//                perspectivePath.add(new RidePath(ride, null, null));
//            }
//        }
//        return perspectivePath;
//    }
//
//    List<RidePath> createPath(List<Ride> perspectivePath, TreeSet<Ride> sortedRides, int steps, int cars) {
//        List<RidePath> perspectivePath = new ArrayList<>();
//        int i = 0;
//        for (Ride ride: sortedRides) {
//            if (i == cars) {
//                break;
//            } else {
//                // removing perspective ride
//                sortedRides.remove(ride);
//                perspectivePath.add(new RidePath(ride, null, null));
//            }
//        }
//        return perspectivePath;
//    }
}
