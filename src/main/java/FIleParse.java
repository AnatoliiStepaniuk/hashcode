import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Denys on 2018-03-01.
 */
public class FIleParse {

    public void parse(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        boolean headerParsed = false;
        List<Object> rides = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                if (!headerParsed) {

                }
                String row = scanner.nextLine();
                rides.add(parseRide(row));
            }
            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Object parseRide(String row) {
        String[] ride = row.split(" ");
    }
}
