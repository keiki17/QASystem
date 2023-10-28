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
import javax.swing.border.EmptyBorder;

public class MainApplicationFrame extends JFrame {
    private CardLayout cardLayout = new CardLayout();
    private JPanel mainPanel = new JPanel(cardLayout);
    private RolePanel studentPanel = new RolePanel();
    private RolePanel staffPanel = new RolePanel();
    private RolePanel staffAddPanel = new RolePanel();
    private DatabaseManager dbManager = new DatabaseManager();
    private ResultSet rs;
    
    Connection conn;
    Statement statement;
    
    public MainApplicationFrame() {
        // Set up the main panel with CardLayout.        
        mainPanel.add(studentPanel, "StudentPanel");
        mainPanel.add(staffPanel, "StaffPanel");
        mainPanel.add(staffAddPanel, "StaffAddPanel");
        
        studentPanel.setTitle("Student Panel");
        staffPanel.setTitle("Staff Panel");
        staffAddPanel.setTitle("Staff Panel - Add question and answer.");
        staffAddPanel.setLayout(new GridLayout(5, 1));
        
        // Create buttons to switch between student and staff views.
        JPanel buttonPanel = new JPanel(); // for nav buttons
        
        JButton studentButton = new JButton("Login as Student");
        JButton staffButton = new JButton("Login as Staff");
        JButton mainMenuButton = new JButton("Logout");
        mainMenuButton.setEnabled(false);
        
        //Create staff editing options
        JButton addButton = new JButton("Add new question");
        JTextField questionText = new JTextField("Type question here",16);
        questionText.setForeground(Color.GRAY);
        questionText.setBounds(100,20,165,25);
        
        JTextField answerText = new JTextField("Type answer here",16);
        answerText.setForeground(Color.GRAY);
        questionText.setBounds(100,20,165,25);
        
        // Creating a button
        JButton saveButton = new JButton("Save");
        //saveButton.setBounds(10, 80, 120, 25);
        
        staffAddPanel.add(questionText,BorderLayout.CENTER);
        staffAddPanel.add(answerText,BorderLayout.CENTER);
        staffAddPanel.add(saveButton,BorderLayout.CENTER);
        
        staffPanel.add(addButton);
        
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
            //stmt.executeUpdate("update qa set question = 'Does AUT have an app?', answer = 'It is available on android and apple stores' where question = 'Does AUT'");
            //stmt.executeUpdate("insert into qa values('where is my exam schedule?','on your event calendar')");
            // Query the table and add the results to a vector
            ResultSet rs = stmt.executeQuery("SELECT * FROM qa");
            while (rs.next()) {
                //data.add(rs.getString("question"));
                //int id  = rs.getInt("id");
                String question = rs.getString("question");
                String answer = rs.getString("answer");
                //System.out.println("answer = " + answer);
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

        studentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //System.out.println("student button pressed");
                
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
        
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainPanel.setVisible(true);
                cardLayout.show(mainPanel, "StaffAddPanel");
                //System.out.println("Double-clicked -> ");
            }
        });
                
        // Action listener for the button
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (questionText.getText().trim().isEmpty() || answerText.getText().trim().isEmpty() || questionText.getText().equals("Type question here") || answerText.getText().equals("Type answer here")) {
                    // Show alert message
                    JOptionPane.showMessageDialog(staffAddPanel,
                            "Please provide both a question and answer!",
                            "Warning",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    // Getting text from JTextField and storing it in a variable
                    String question = questionText.getText();
                    String answer = answerText.getText();
                    // Here, you would typically do something with the text: save it, print it, etc.
                    //System.out.println(text);
                    // Database query
                    try {
                        // Load the embedded database driver
                        Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();

                        // Connect to the database (it will be created if it doesn't exist)
                        String url = "jdbc:derby:qna;create=true";
                        Connection conn = DriverManager.getConnection(url);
                        // Create a statement to execute SQL queries
                        Statement stmt = conn.createStatement();

                        // Insert some sample data (you should skip this step if you have your own data)
                        stmt.executeUpdate("Insert into qa values('" + question + "','" + answer + "')");

                        // Clean-up environment
                        //rs.close();
                        stmt.close();
                        conn.close();
                        } catch (Exception f) {
                            f.printStackTrace(); // Handle errors (like a missing driver or SQL exception)
                        }
                    //mainPanel.setVisible(true);
                    cardLayout.show(mainPanel, "StaffPanel");
                }
                
            }
        });
                
        
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.out.println("Double-clicked -> " + e.getClickCount());
                if (e.getClickCount() == 2) { // detect double-click
                    JTable target = (JTable) e.getSource();
                    int selectedRow = target.getSelectedRow();
                    if (selectedRow >= 0) {
                        Object selectedRowId = table.getValueAt(selectedRow, 0); // 0 for "ID" column
                        System.out.println("Double-clicked on row with ID: " + selectedRowId);
                        // perform your actions based on the clicked row with the ID
                    }
                }
            }
        });
        
        // Add focus listeners to handle the placeholder logic
        questionText.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (questionText.getText().equals("Type question here")) {
                    questionText.setText("");
                    questionText.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (questionText.getText().isEmpty()) {
                    questionText.setForeground(Color.GRAY);
                    questionText.setText("Type question here");
                }
            }
        });
        
        answerText.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (answerText.getText().equals("Type answer here")) {
                    answerText.setText("");
                    answerText.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (answerText.getText().isEmpty()) {
                    answerText.setForeground(Color.GRAY);
                    answerText.setText("Type answer here");
                }
            }
        });
        
        buttonPanel.add(studentButton);
        buttonPanel.add(staffButton);
        buttonPanel.add(mainMenuButton);
        
        // Add padding to the content panel
        int padding = 10; // for example, 10 pixels of padding
        mainPanel.setBorder(new EmptyBorder(padding, padding, padding, padding));
        
        //mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        //studentPanel.setLayout(new BoxLayout(studentPanel, BoxLayout.Y_AXIS));
        //staffPanel.setLayout(new BoxLayout(staffPanel, BoxLayout.Y_AXIS));
        //staffAddPanel.setLayout(new BoxLayout(staffAddPanel, BoxLayout.Y_AXIS));
        
        // Add panels to the frame.
        this.add(buttonPanel,BorderLayout.NORTH);
        this.add(mainPanel,BorderLayout.CENTER);
        //studentPanel.setLayout(new BoxLayout(studentPanel, BoxLayout.Y_AXIS));
        //staffPanel.setLayout(new BoxLayout(studentPanel, BoxLayout.Y_AXIS));
        mainPanel.setVisible(false);
        
        // Add the scroll pane to the frame and show the frame
        studentPanel.add(scrollPane);
        //staffPanel.add(scrollPane);
        
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
