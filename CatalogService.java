import java.util.*;

public class CatalogService {
    private List<Destination> list = new ArrayList<>();

    public void addDestination(Scanner sc) {
        System.out.println("Choose type: 1-Attraction 2-Accommodation 3-Activity");
        String type = sc.nextLine();

        System.out.print("Name: ");
        String name = validate(sc);

        System.out.print("Location: ");
        String location = validate(sc);

        System.out.print("Description: ");
        String desc = validate(sc);

        switch (type) {
            case "1":
                System.out.print("Type (lake/mountain): ");
                list.add(new Attraction(name, location, desc, validate(sc)));
                break;
            case "2":
                System.out.print("Price: ");
                double price = Double.parseDouble(sc.nextLine());
                list.add(new Accommodation(name, location, desc, price));
                break;
            case "3":
                System.out.print("Difficulty: ");
                list.add(new Activity(name, location, desc, validate(sc)));
                break;
            default:
                System.out.println("Invalid type!");
        }
    }

    public void viewAll() {
        if (list.isEmpty()) {
            System.out.println("No data.");
            return;
        }
        for (Destination d : list) {
            d.displayInfo();
        }
    }

    public void search(Scanner sc) {
        System.out.print("Enter name: ");
        String name = sc.nextLine();

        for (Destination d : list) {
            if (d.getName().equalsIgnoreCase(name)) {
                d.displayInfo();
                return;
            }
        }
        System.out.println("Not found.");
    }

    public void update(Scanner sc) {
        System.out.print("Enter name to update: ");
        String name = sc.nextLine();

        for (Destination d : list) {
            if (d.getName().equalsIgnoreCase(name)) {
                System.out.print("New name: ");
                d.setName(validate(sc));
                System.out.println("Updated!");
                return;
            }
        }
        System.out.println("Not found.");
    }

    public void delete(Scanner sc) {
        System.out.print("Enter name to delete: ");
        String name = sc.nextLine();

        list.removeIf(d -> d.getName().equalsIgnoreCase(name));
        System.out.println("Deleted if existed.");
    }

    public void saveToFile() {
        FileManager.save(list);
    }

    public void loadFromFile() {
        list = FileManager.load();
        System.out.println("Data loaded.");
    }

    private String validate(Scanner sc) {
        String input = sc.nextLine();
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("Input cannot be empty!");
        }
        return input;
    }
    public List<Destination> getList() {
        return list;
    }

}
