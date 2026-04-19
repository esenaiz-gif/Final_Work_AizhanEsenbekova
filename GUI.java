import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class GUI extends JFrame {

    private JTable table;
    private DefaultTableModel model;

    public GUI() {
        setTitle("Tourist Catalog (MySQL)");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // TABLE
        model = new DefaultTableModel();
        table = new JTable(model);

        model.addColumn("ID");
        model.addColumn("Type");
        model.addColumn("Name");
        model.addColumn("Location");
        model.addColumn("Description");
        model.addColumn("Extra");

        add(new JScrollPane(table), BorderLayout.CENTER);

        // BUTTON PANEL
        JPanel panel = new JPanel();

        JButton loadBtn = new JButton("Load");
        JButton addBtn = new JButton("Add");
        JButton deleteBtn = new JButton("Delete");

        panel.add(loadBtn);
        panel.add(addBtn);
        panel.add(deleteBtn);

        add(panel, BorderLayout.SOUTH);

        // ACTIONS
        loadBtn.addActionListener(e -> loadData());
        addBtn.addActionListener(e -> addData());
        deleteBtn.addActionListener(e -> deleteData());

        setVisible(true);
    }

    private void loadData() {
        try (Connection conn = DatabaseManager.connect()) {

            // ALWAYS clear first
            model.setRowCount(0);

            String sql = "SELECT * FROM destinations";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("id"),
                        rs.getString("type"),
                        rs.getString("name"),
                        rs.getString("location"),
                        rs.getString("description"),
                        rs.getString("extra")
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ADD DATA
    private void addData() {
        try (Connection conn = DatabaseManager.connect()) {

            String type = JOptionPane.showInputDialog("Type:");
            String name = JOptionPane.showInputDialog("Name:");
            String location = JOptionPane.showInputDialog("Location:");
            String desc = JOptionPane.showInputDialog("Description:");
            String extra = JOptionPane.showInputDialog("Extra:");

            String sql = "INSERT INTO destinations (type, name, location, description, extra) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, type);
            stmt.setString(2, name);
            stmt.setString(3, location);
            stmt.setString(4, desc);
            stmt.setString(5, extra);

            stmt.executeUpdate();

            loadData(); // refresh table

            JOptionPane.showMessageDialog(this, "Added!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE SELECTED ROW
    private void deleteData() {
        try (Connection conn = DatabaseManager.connect()) {

            int row = table.getSelectedRow();

            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Select a row first!");
                return;
            }

            int id = (int) model.getValueAt(row, 0);

            String sql = "DELETE FROM destinations WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            stmt.executeUpdate();

            loadData(); // refresh table

            JOptionPane.showMessageDialog(this, "Deleted!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new GUI();
    }
}