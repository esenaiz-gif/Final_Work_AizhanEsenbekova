import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        DatabaseService service = new DatabaseService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== TOURISM DB MENU ===");
            System.out.println("1. Add");
            System.out.println("2. View");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("0. Exit");

            String choice = sc.nextLine();

            switch (choice) {
                case "1": service.addDestination(sc); break;
                case "2": service.viewAll(); break;
                case "3": service.update(sc); break;
                case "4": service.delete(sc); break;
                case "0": return;
                default: System.out.println("Invalid!");
            }
        }
    }
}