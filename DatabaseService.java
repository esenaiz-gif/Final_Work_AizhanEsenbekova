import java.sql.*;
import java.util.Scanner;

public class DatabaseService {

    public void addDestination(Scanner sc) {
        try (Connection conn = DatabaseManager.connect()) {

            System.out.print("Type (Attraction/Accommodation/Activity): ");
            String type = sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Location: ");
            String location = sc.nextLine();

            System.out.print("Description: ");
            String desc = sc.nextLine();

            System.out.print("Extra (type/price/difficulty): ");
            String extra = sc.nextLine();

            String sql = "INSERT INTO destinations (type, name, location, description, extra) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, type);
            stmt.setString(2, name);
            stmt.setString(3, location);
            stmt.setString(4, desc);
            stmt.setString(5, extra);

            stmt.executeUpdate();

            System.out.println("Added successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewAll() {
        try (Connection conn = DatabaseManager.connect()) {

            String sql = "SELECT * FROM destinations";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("type") + " | " +
                                rs.getString("name") + " | " +
                                rs.getString("location") + " | " +
                                rs.getString("extra")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Scanner sc) {
        try (Connection conn = DatabaseManager.connect()) {

            System.out.print("Enter name to delete: ");
            String name = sc.nextLine();

            String sql = "DELETE FROM destinations WHERE name = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);

            int rows = stmt.executeUpdate();

            if (rows > 0)
                System.out.println("Deleted!");
            else
                System.out.println("Not found.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Scanner sc) {
        try (Connection conn = DatabaseManager.connect()) {

            System.out.print("Enter name to update: ");
            String name = sc.nextLine();

            System.out.print("New name: ");
            String newName = sc.nextLine();

            String sql = "UPDATE destinations SET name = ? WHERE name = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, newName);
            stmt.setString(2, name);

            int rows = stmt.executeUpdate();

            if (rows > 0)
                System.out.println("Updated!");
            else
                System.out.println("Not found.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}