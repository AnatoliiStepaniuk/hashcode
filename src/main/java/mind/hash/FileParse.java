package mind.hash;

import mind.hash.model.Position;
import mind.hash.model.Problem;
import mind.hash.model.Ride;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Denys on 2018-03-01.
 */
public class FileParse
{

    public Problem parse(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        Problem problem = null;
        int rideId = 0;
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                if (problem == null) {
                    problem = parseProblem(scanner.nextLine());
                    continue;
                }
                String row = scanner.nextLine();
                problem.getRides().add(parseRide(rideId, row));
                rideId++;
            }
            return problem;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Problem parseProblem(String header) {
        String[] problemParts = header.split(" ");
        return new Problem()
                .setRows(Integer.parseInt(problemParts[0]))
                .setColumns(Integer.parseInt(problemParts[1]))
                .setVehicles(Integer.parseInt(problemParts[2]))
                .setRides(new ArrayList<>(Integer.parseInt(problemParts[3])))
                .setBonus(Integer.parseInt(problemParts[4]))
                .setSteps(Integer.parseInt(problemParts[5]));
    }

    private Ride parseRide(int id, String row) {
        String[] ride = row.split(" ");
        return new Ride(
                new Position(Integer.parseInt(ride[0]), Integer.parseInt(ride[1])),
                new Position(Integer.parseInt(ride[2]), Integer.parseInt(ride[3])),
                Integer.parseInt(ride[4]),
                Integer.parseInt(ride[5]),
                id
        );
    }
}
