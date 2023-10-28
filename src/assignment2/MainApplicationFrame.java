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
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class MainApplicationFrame extends JFrame {
    private CardLayout cardLayout = new CardLayout();
    private JPanel mainPanel = new JPanel(cardLayout);
    private RolePanel studentPanel = new RolePanel();
    private RolePanel staffPanel = new RolePanel();
    private DatabaseManager dbManager = new DatabaseManager();
    private ResultSet rs;
    Connection conn;
    Statement statement;
    
    public MainApplicationFrame() {
        // Set up the main panel with CardLayout.        
        mainPanel.add(studentPanel, "StudentPanel");
        mainPanel.add(staffPanel, "StaffPanel");
        studentPanel.setTitle("Student Panel");
        staffPanel.setTitle("Staff Panel");
        
        // Create buttons to switch between student and staff views.
        JPanel buttonPanel = new JPanel();
        JButton studentButton = new JButton("Login as Student");
        JButton staffButton = new JButton("Login as Staff");
        JButton mainMenuButton = new JButton("Logout");
        mainMenuButton.setEnabled(false);
        
        // Create table model and table based on it.
        DefaultTableModel tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);

        // Add columns to the table model.
        //tableModel.addColumn("ID");
        tableModel.addColumn("Question");
        tableModel.addColumn("Answer");
        
        // Database query
        try {
            // Load the embedded database driver
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();

            // Connect to the database (it will be created if it doesn't exist)
            String url = "jdbc:derby:qna;create=true";
            Connection conn = DriverManager.getConnection(url);

            // Create a statement to execute SQL queries
            Statement stmt = conn.createStatement();
            
            //stmt.executeUpdate("DROP TABLE QA");
            // Create a table for demonstration (you should skip this step if the table already exists)
            //stmt.executeUpdate("CREATE TABLE QA (Question VARCHAR(255), Answer VARCHAR(255))");
            
            // Insert some sample data (you should skip this step if you have your own data)
            //stmt.executeUpdate("insert into qa values('what color is the sky','sky is blue')");
            //stmt.executeUpdate("insert into qa values('where is my exam schedule?','on your event calendar')");
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

        // Add the table to a scrolling pane, then add the pane to the frame.
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        //add(scrollPane);

        // Add the scroll pane to the frame and show the frame
        studentPanel.add(scrollPane, BorderLayout.CENTER);
        
        
        //dbManager.updateDB("INSERT INTO QA VALUES ('O le a le aso nei?', 'O le aso lua')");
        
        studentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("student button pressed");
                
                /*    
                try{

                    rs = dbManager.queryDB("SELECT count(*) FROM QA as total");
                    System.out.println("record count is = " + rs.getInt("total"));
                    while (rs.next()) {
                            int id  = rs.getInt("id");
                            String question = rs.getString("question");
                            String answer = rs.getString("answer");
                            System.out.println("answer = " + answer);
                            // Add each row to the table.
                            tableModel.addRow(new Object[]{id, question, answer});
                        }
                } catch (SQLException ex) {
                    System.out.println("error ->>>>  ");
                    System.out.println(ex.getMessage());
                }    
                
                // Add the table to a scrolling pane, then add the pane to the frame.
                JScrollPane scrollPane = new JScrollPane(table);
                table.setFillsViewportHeight(true);
                mainPanel.add(scrollPane);
                */
                mainPanel.setVisible(true);
                cardLayout.show(mainPanel, "StudentPanel");
                staffButton.setEnabled(false);
                studentButton.setEnabled(false);
                mainMenuButton.setEnabled(true);
            }
        });
        
        staffButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                mainPanel.setVisible(true);
                cardLayout.show(mainPanel, "StaffPanel");
                staffButton.setEnabled(false);
                studentButton.setEnabled(false);
                mainMenuButton.setEnabled(true);
            }
        });

        mainMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainPanel.setVisible(false);
                staffButton.setEnabled(true);
                studentButton.setEnabled(true);
                mainMenuButton.setEnabled(false);
            }
        });
        
        
        buttonPanel.add(studentButton);
        buttonPanel.add(staffButton);
        buttonPanel.add(mainMenuButton);

        // Add panels to the frame.
        this.add(mainPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.NORTH);
        
        mainPanel.setVisible(false);
    }
    
    
    public void closeConnection() {
        this.dbManager.closeConnections();
    }
    
    public void createTableModel(){
        // Create table model and table based on it.
        DefaultTableModel tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);
        
        // Add columns to the table model.
        tableModel.addColumn("ID");
        tableModel.addColumn("Question");
        tableModel.addColumn("Answer");
    }
}
