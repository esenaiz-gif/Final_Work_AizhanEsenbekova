import java.io.*;
import java.util.*;

public class FileManager {
    private static final String FILE_NAME = "data.csv";

    public static void save(List<Destination> list) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Destination d : list) {
                writer.println(d.toFileFormat());
            }
            System.out.println("Data saved!");
        } catch (IOException e) {
            System.out.println("Error saving file!");
        }
    }

    public static List<Destination> load() {
        List<Destination> list = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                switch (parts[0]) {
                    case "Attraction":
                        list.add(new Attraction(parts[1], parts[2], parts[3], parts[4]));
                        break;
                    case "Accommodation":
                        list.add(new Accommodation(parts[1], parts[2], parts[3], Double.parseDouble(parts[4])));
                        break;
                    case "Activity":
                        list.add(new Activity(parts[1], parts[2], parts[3], parts[4]));
                        break;
                    default:
                        list.add(new Destination(parts[1], parts[2], parts[3]));
                }
            }
        } catch (IOException e) {
            System.out.println("No previous data found.");
        }

        return list;
    }
}