/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment2;

/**
 *
 * @author Daijimara Chan-Ting
 */
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class DatabaseQueryApp {

    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("Database Contents");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Create table model and table based on it.
        DefaultTableModel tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);

        // Add columns to the table model.
        //tableModel.addColumn("ID");
        tableModel.addColumn("Question");
        tableModel.addColumn("Answer");
        
        // Database query
        Vector<String> data = new Vector<>();
        try {
            // Load the embedded database driver
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();

            // Connect to the database (it will be created if it doesn't exist)
            String url = "jdbc:derby:qna;create=true";
            Connection conn = DriverManager.getConnection(url);

            // Create a statement to execute SQL queries
            Statement stmt = conn.createStatement();
            
            stmt.executeUpdate("DROP TABLE QA");
            // Create a table for demonstration (you should skip this step if the table already exists)
            stmt.executeUpdate("CREATE TABLE QA (Question VARCHAR(255), Answer VARCHAR(255))");
            
            // Insert some sample data (you should skip this step if you have your own data)
            stmt.executeUpdate("insert into qa values('what color is the sky','sky is blue')");
            stmt.executeUpdate("insert into qa values('where is my exam schedule?','on your event calendar')");
            // Query the table and add the results to a vector
            ResultSet rs = stmt.executeQuery("SELECT * FROM qa");
            while (rs.next()) {
                //data.add(rs.getString("question"));
                //int id  = rs.getInt("id");
                String question = rs.getString("question");
                String answer = rs.getString("answer");
                System.out.println("answer = " + answer);
                // Add each row to the table.
                tableModel.addRow(new Object[]{question, answer});
            }
            //rs.gets
            // Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace(); // Handle errors (like a missing driver or SQL exception)
        }
        
        // Create a JList filled with data retrieved from the database
        JList<String> dataList = new JList<>(data);

        // Add the table to a scrolling pane, then add the pane to the frame.
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        //add(scrollPane);

        // Add the scroll pane to the frame and show the frame
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}

