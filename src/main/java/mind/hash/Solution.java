package mind.hash;

import mind.hash.model.Car;

import java.util.Collection;

public class Solution
{
  private Collection<Car> carsWithAssignedRides;

  public int score()
  {
    return carsWithAssignedRides.stream()
            .mapToInt( Car::getScore )
            .sum();
  }

  public void print()
  {
    int counter = 1;
    for (Car car : carsWithAssignedRides) {
      printCar(counter++, car);
    }
  }

  private void printCar( int counter, Car car ) {
    System.out.println(counter + " " + car.printAcceptedRides());
  }

  public Collection<Car> getCarsWithAssignedRides() {
    return carsWithAssignedRides;
  }

  public Solution setCarsWithAssignedRides(Collection<Car> carsWithAssignedRides) {
    this.carsWithAssignedRides = carsWithAssignedRides;
    return this;
  }
}
