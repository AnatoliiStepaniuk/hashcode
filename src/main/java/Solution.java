import model.Car;

import java.util.Collection;

public class Solution
{
  public static int score( Collection<Car> cars )
  {
    return cars.stream()
            .mapToInt( Car::getScore )
            .sum();
  }
}
