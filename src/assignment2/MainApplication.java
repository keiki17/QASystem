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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class MainApplication {
    /*
    DatabaseManager dbManager;
    Connection conn;
    Statement statement;
    
    public MainApplication() {
        dbManager = new DatabaseManager();
        conn = dbManager.getConnection();
        System.out.println("MainApp checkpoint");
        try {
            statement = conn.createStatement();
            System.out.println("MainApp try ");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + " catch msg here <--");
        }
    
    }*/
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
        
        
   
        /*/MainApplication mainApp = new MainApplication(); 
        System.out.println("Running mainApp");
        try {
            
            dbManager.updateDB("CREATE TABLE QA (Question VARCHAR(255), Answer VARCHAR(255))");
            mainApp.statement.addBatch("INSERT INTO QA VALUES ('Where can i find my class schedule?', 'On our moodle system'),\n"
                    + "('How can i find out about student loans?', 'In your inception brochure'),\n"
                    + "('Where can i find vegetarian restaurants on campus?', 'Our AUT app'),\n"
                    + "('When can i get my exam schedule?', 'In 2 weeks time')");
            mainApp.statement.executeBatch();
           
            System.out.println(mainApp.statement);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + " error le mea :-(");
        }
        //mainApp.closeConnection();
        */
    }
    /*
    public void closeConnection() {
        this.dbManager.closeConnections();
    } */
    
}

