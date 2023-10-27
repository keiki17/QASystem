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

public class StaffView extends JFrame {
    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;
    private JButton mainMenuButton;
    private JPanel staffPanel;
    
    public StaffView() {
        // Frame initialization
        setTitle("QA System - Staff View");
        setSize(500, 400);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addButton = new JButton("Add Question");
        editButton = new JButton("Edit Question");
        deleteButton = new JButton("Delete Question");
        mainMenuButton = new JButton("Back to Main Menu");
        
        // Here we're just adding basic click listeners.
        // In a real application, these would open up more complex interfaces 
        // allowing the staff to perform the respective operations.
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Logic for adding a question
                JOptionPane.showMessageDialog(StaffView.this, "Add question logic!");
            }
        });

        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Logic for editing a question
                JOptionPane.showMessageDialog(StaffView.this, "Edit question logic!");
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Logic for deleting a question
                JOptionPane.showMessageDialog(StaffView.this, "Delete question logic!");
            }
        });
        
        mainMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Proceed to staff view
                RoleSelectionFrame roleSelectionFrame = new RoleSelectionFrame();
                roleSelectionFrame.setVisible(true);
                // Hide and dispose of the current window
                setVisible(false);
                dispose();
            }
        });

        // Set up layout        
        staffPanel = new JPanel();
        staffPanel.setLayout(new FlowLayout());
        
        staffPanel.add(addButton);
        staffPanel.add(editButton);
        staffPanel.add(deleteButton);
        staffPanel.add(mainMenuButton);
        // Add components to the frame
        //setContentPane(mainPanel);
        getContentPane().add(staffPanel);
        setSize(500,150);
        //setLocationRelativeTo(null);
        setVisible(true);
    }
}

