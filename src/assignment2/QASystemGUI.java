/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Daijimara Chan-Ting
 */

package assignment2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QASystemGUI extends JFrame {

    private int userID = -1; // -1 means not logged in
    
    // Components of the GUI
    private JButton staffLoginButton;
    private JButton studentLoginButton;
    private JButton homeButton;
    private JLabel titleLabel;
    private JPanel mainPanel;
    
    public QASystemGUI() {
        initComponents();
    }

    private void initComponents() {
        setTitle("QA System 2023");
        setSize(300, 200);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Initialize components
        // Create a title label
        titleLabel = new JLabel("Please choose your role", SwingConstants.CENTER);
        add(titleLabel, BorderLayout.NORTH);
        
        //JLabel mainLabel = new JLabel("MAIN MENU");
        staffLoginButton = new JButton("Login as Staff");
        studentLoginButton = new JButton("Login as Student");
        homeButton = new JButton("Main Menu");

        // Set up layout        
        mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());
        
        mainPanel.add(titleLabel);
        mainPanel.add(staffLoginButton);
        mainPanel.add(studentLoginButton);
        //mainPanel.add(homeButton);
        
              
        // Add components to the frame
        //setContentPane(mainPanel);
        getContentPane().add(mainPanel);
        pack();
        //setLocationRelativeTo(null);
        setVisible(true);
        
        // Set up action listeners
        staffLoginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                userID = 1; // Staff login
                openStaffMenu();
            }
        });

        studentLoginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                userID = 2; // Student login
                openStudentMenu();
            }
        });

        homeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openMainMenu();
            }
        });
    }

    private void openStaffMenu() {
        // Implement staff menu GUI
        titleLabel.setText("Staff View");
        
        mainPanel.remove(staffLoginButton);
        mainPanel.remove(studentLoginButton);
        mainPanel.add(homeButton);
    }

    private void openStudentMenu() {
        // Implement student menu GUI
        titleLabel.setText("Student View");
        
        mainPanel.remove(staffLoginButton);
        mainPanel.remove(studentLoginButton);
        mainPanel.add(homeButton);
    }

    private void openMainMenu() {
        // Implement student menu GUI
        titleLabel.setText("Student View");
        
        mainPanel.add(staffLoginButton);
        mainPanel.add(studentLoginButton);
        mainPanel.remove(homeButton);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new QASystemGUI();
            }
        });
    }
}
