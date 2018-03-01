package mind.hash;

import mind.hash.model.Car;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;

public class Solution {
    private Collection<Car> carsWithAssignedRides;

  public Solution(List<Car> cars){
    carsWithAssignedRides = cars;
  }

  public int score()
  {
    return carsWithAssignedRides.stream()
            .mapToInt( Car::getScore )
            .sum();
  }

    public void print() {
        try (FileWriter fileWriter = new FileWriter("solution.out");
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            for (Car car : carsWithAssignedRides) {
                printWriter.println(car.printAcceptedRides());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Collection<Car> getCarsWithAssignedRides() {
        return carsWithAssignedRides;
    }

    public Solution setCarsWithAssignedRides(Collection<Car> carsWithAssignedRides) {
        this.carsWithAssignedRides = carsWithAssignedRides;
        return this;
    }
}
