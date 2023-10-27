/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {

    // Components of the GUI
    private JButton staffButton;
    private JButton studentButton;
    private JLabel titleLabel;
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem exitMenuItem;

    public LoginFrame() {
        // Set up the frame
        setTitle("Login System");
        setSize(300, 200);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a title label
        titleLabel = new JLabel("Please choose your role", SwingConstants.CENTER);
        add(titleLabel, BorderLayout.NORTH);

        // Create a panel to hold buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        // Create buttons and add them to the panel
        staffButton = new JButton("Login as Staff");
        studentButton = new JButton("Login as Student");

        buttonPanel.add(staffButton);
        buttonPanel.add(studentButton);

        add(buttonPanel, BorderLayout.CENTER);

        // Create a menu bar
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        exitMenuItem = new JMenuItem("Exit");

        fileMenu.add(exitMenuItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        // Action listeners for the buttons
        staffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                staffLogin();
            }
        });

        studentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                studentLogin();
            }
        });

        // Action listener for the exit menu item
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Terminate the application
                System.exit(0);
            }
        });
    }

    private void staffLogin() {
        titleLabel.setText("Staff View");
        // You can add more staff-specific menu items or change the interface as required
    }

    private void studentLogin() {
        titleLabel.setText("Student View");
        // You can add more student-specific menu items or change the interface as required
    }

    public static void main(String[] args) {
        // Schedule a job for the event dispatching thread: creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Create and set up the window.
                JFrame frame = new LoginFrame();
                // Display the window.
                frame.setVisible(true);
            }
        });
    }
}
