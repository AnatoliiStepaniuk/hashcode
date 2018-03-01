import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Denys on 2018-03-01.
 */
public class FIleParse {

    public void parse(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
