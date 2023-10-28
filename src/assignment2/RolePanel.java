/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment2;

/**
 *
 * @author Daijimara Chan-Ting
 */

// StudentPanel.java

import javax.swing.*;

public class RolePanel extends JPanel {
    // DatabaseManager represents the connection to the database.
    //private DatabaseManager dbManager = new DatabaseManager();
    private JLabel titleLabel;
    
    public RolePanel() {
        // Here, you would initiate the components (like buttons, lists, etc.)
        // and set up the panel's layout. You would also add event listeners
        // for your buttons to handle add/edit/delete actions, which would
        // involve calling the appropriate DatabaseManager methods.
        // This is a placeholder for your UI setup.
        
    }
    
    public void setTitle(String title){
        titleLabel = new JLabel(title, SwingConstants.CENTER);
        this.add(titleLabel);
    }
    // Methods to add, edit, delete, and refresh questions from the database will go here.
    
    public void questionAnswerList(){
        
    }
}
