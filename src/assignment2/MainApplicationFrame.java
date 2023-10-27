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

public class MainApplicationFrame extends JFrame {
    private CardLayout cardLayout = new CardLayout();
    private JPanel mainPanel = new JPanel(cardLayout);
    private RolePanel studentPanel = new RolePanel();
    private RolePanel staffPanel = new RolePanel();

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
        
        studentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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
}
