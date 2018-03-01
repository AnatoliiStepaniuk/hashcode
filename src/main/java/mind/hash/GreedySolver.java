package mind.hash;

import mind.hash.model.Car;
import mind.hash.model.Optimizer;
import mind.hash.model.Ride;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class GreedySolver implements Solver {

    private final List<Car> cars;
    private final Collection<Ride> rides;

    public GreedySolver(List<Car> cars, Collection<Ride> rides) {
        this.cars = cars;
        this.rides = rides;
    }

    public List<Car> solve(){
        List<Car> carsWithAssignedRides = new ArrayList(cars);

        for(Ride ride : rides){

            for(Car car : carsWithAssignedRides){
                if(car.canFulfill(ride)){
                    car.add(ride);
                    break;
                }
            }

        }

        return carsWithAssignedRides;
    }

}
