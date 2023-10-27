/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment2;

/**
 *
 * @author Daijimara Chan-Ting
 */

import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.event.*;

public class StudentView extends JFrame {
    // For simplicity, we're using a JTextArea to simulate the list of questions.
    //private JTextArea questionsArea;
    private JButton mainMenuButton;
    private JPanel studentPanel;
    
    public StudentView() {
        // Frame initialization
        setTitle("QA System - Student View");
        setSize(500, 400);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS)); // vertical layout
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        mainMenuButton = new JButton("Back to Main Menu");
        
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
        studentPanel = new JPanel();
        studentPanel.setLayout(new FlowLayout());
        
        studentPanel.add(mainMenuButton);
        //studentPanel.add(editButton);
        //studentPanel.add(deleteButton);
        studentPanel.add(mainMenuButton);
        // Add components to the frame
        //setContentPane(mainPanel);
        getContentPane().add(studentPanel);
        setSize(500,150);
        //setLocationRelativeTo(null);
        setVisible(true);

        // Retrieve and display questions from the Apache Derby database here.
    }
}

