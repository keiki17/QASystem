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

public class MainApplication {
    public static void main(String[] args) {
        // Start the main application frame here
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Create the main application frame.
        MainApplicationFrame mainFrame = new MainApplicationFrame();
        mainFrame.setTitle("QA System");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(600, 400);
        mainFrame.setLocationRelativeTo(null); // Center the frame
        mainFrame.setVisible(true);
    }
    
}

