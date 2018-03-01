import model.Car;
import model.Ride;

import java.util.List;

public class Greedy { // And stupid

    public static void solve(List<Car> cars, List<Ride> rides){

        for(Ride ride : rides){

            for(Car car : cars){
                if(car.canFulfill(ride)){
                    car.add(ride);
                    break;
                }
            }

        }

    }

}
