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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QASystemGUI extends JFrame {

    private int userID = -1; // -1 means not logged in

    public QASystemGUI() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        // Initialize components
        JLabel mainLabel = new JLabel("MAIN MENU");
        JButton staffLoginButton = new JButton("Login as Staff");
        JButton studentLoginButton = new JButton("Login as Student");
        JButton quitButton = new JButton("Quit");

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

        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Goodbye!");
                System.exit(0);
            }
        });

        // Set up layout
        JPanel mainPanel = new JPanel();
        mainPanel.add(mainLabel);
        mainPanel.add(staffLoginButton);
        mainPanel.add(studentLoginButton);
        mainPanel.add(quitButton);

        // Add components to the frame
        getContentPane().add(mainPanel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void openStaffMenu() {
        // Implement staff menu GUI
        // You can create a new JFrame or a panel for staff operations
    }

    private void openStudentMenu() {
        // Implement student menu GUI
        // You can create a new JFrame or a panel for student operations
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new QASystemGUI();
            }
        });
    }
}
