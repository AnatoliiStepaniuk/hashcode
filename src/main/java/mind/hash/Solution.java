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
    System.out.println( "LOL FU" );
  }
}
