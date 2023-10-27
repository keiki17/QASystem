/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment2;

/**
 *
 * @author Daijimara Chan-Ting
 */
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.event.*;

public class RoleSelectionFrame extends JFrame {
    private JButton studentButton;
    private JButton staffButton;
    private JPanel mainPanel;
    
    public RoleSelectionFrame() {
        // Frame initialization
        setTitle("QA System - Main Menu");
        setSize(400, 200);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        // Student button
        studentButton = new JButton("Student");
        studentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Proceed to student view
                StudentView studentView = new StudentView();
                studentView.setVisible(true);
                // Hide and dispose of the current window
                setVisible(false);
                dispose();
            }
        });

        // Staff button
        staffButton = new JButton("Staff");
        staffButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Proceed to staff view
                StaffView staffView = new StaffView();
                staffView.setVisible(true);
                // Hide and dispose of the current window
                setVisible(false);
                dispose();
            }
        });
        
        // Set up layout        
        mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());
        
        mainPanel.add(studentButton);
        mainPanel.add(staffButton);
        // Add components to the frame
        //setContentPane(mainPanel);
        getContentPane().add(mainPanel);
        setSize(500,150);
        //setLocationRelativeTo(null);
        setVisible(true);
    }
}

