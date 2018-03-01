package mind.hash;

import mind.hash.model.Car;
import mind.hash.model.Ride;

import java.util.*;

public class GreedySolver implements Solver {

    private final List<Car> cars;
    private final List<Ride> rides;
    private final int bonus;

    public GreedySolver(List<Car> cars, List<Ride> rides, int bonus) {
        this.cars = cars;
        rides.sort(Comparator.comparingInt(r -> r.earliestStart));
        this.rides = rides;
        this.bonus = bonus;
    }

    public List<Car> solve(){
        List<Car> carsWithAssignedRides = new ArrayList(cars);

        for(Ride ride : rides){

            List<CarWithScore> carWithScores = new ArrayList<>();

            for(Car car : carsWithAssignedRides){
//                if(car.canFulfill(ride)){
//                    car.add(ride);
//                    break;
//                }

                carWithScores.add(new CarWithScore(car, car.getRelativeScore(ride, bonus)));
            }

            carWithScores.sort((c1, c2) -> c2.score - c1.score);
            carWithScores.get(0).car.add(ride);







        }

        return carsWithAssignedRides;
    }

}
