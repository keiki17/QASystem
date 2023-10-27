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

public class StudentView extends JFrame {
    // For simplicity, we're using a JTextArea to simulate the list of questions.
    private JTextArea questionsArea;

    public StudentView() {
        // Frame initialization
        setTitle("Student View");
        setSize(500, 400);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS)); // vertical layout
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        questionsArea = new JTextArea("Here will be a list of questions and answers...");
        questionsArea.setEditable(false); // so it cannot be modified
        add(new JScrollPane(questionsArea)); // enable scrolling

        // In a full application, you would retrieve and display questions from the Apache Derby database here.
    }
}

