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
import javax.swing.*;
import java.awt.event.*;

public class StaffView extends JFrame {
    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;

    public StaffView() {
        // Frame initialization
        setTitle("Staff View");
        setSize(300, 150);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addButton = new JButton("Add Question");
        editButton = new JButton("Edit Question");
        deleteButton = new JButton("Delete Question");

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

        add(addButton);
        add(editButton);
        add(deleteButton);
    }
}

