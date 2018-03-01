package mind.hash;

import mind.hash.model.Car;
import mind.hash.model.Position;
import mind.hash.model.Ride;

import java.util.ArrayList;
import java.util.List;

public class GreedySolver implements Solver {

    private final List<Car> cars;
    private final List<Ride> rides;

    public GreedySolver(List<Car> cars, List<Ride> rides) {
        this.cars = cars;
        this.rides = rides;
    }

    public static Ride getBestRide(List<Ride> rides, Ride ride, Car car) {
        Position startPos = new Position(0, 0);
        if (ride != null) {
            startPos = ride.start;
        }
        int score = -1;
        Ride best = null;
        for (Ride r : rides) {
            if (!r.equals(ride) && car.canFulfill(r) && (score == -1 || r.start.distanceTo(startPos) < score)) {
                score = r.start.distanceTo(startPos);
                best = r;
            }
        }
        return best;
    }

    public List<Car> solve() {
        List<Car> carsWithAssignedRides = new ArrayList(cars);
        List<Ride> alreadyUsed = new ArrayList<>();
        for (Car car : carsWithAssignedRides) {
            Ride best = getBestRide(
                    rides,
                    car.acceptedRideList.isEmpty()
                            ? null
                            : car.acceptedRideList.get(car.acceptedRideList.size() - 1),
                    car
            );
            if (alreadyUsed.contains(best)) {
                rides.remove(best);
            }
            while (best != null) {
                if (!alreadyUsed.contains(best)) {
                    car.add(best);
                } else {
                    rides.remove(best);
                }
                alreadyUsed.add(best);
                best = getBestRide(
                        rides,
                        car.acceptedRideList.isEmpty()
                        ? null
                        : car.acceptedRideList.get(car.acceptedRideList.size() - 1),
                        car
                );
            }
        }

        return carsWithAssignedRides;
    }

}
