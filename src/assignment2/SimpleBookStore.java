/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment2;

/**
 *
 * @author Daijimara Chan-Ting
 */
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SimpleBookStore {

    SimpleDBManager dbManager;
    Connection conn;
    Statement statement;

    public SimpleBookStore() {
        dbManager = new SimpleDBManager();
        conn = dbManager.getConnection();
        try {
            statement = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void main(String[] args) {
        SimpleBookStore sbs = new SimpleBookStore();
        System.out.println("Running sbs");
        
        //dbManager.
        try {
            sbs.statement.addBatch("CREATE TABLE QA (Question VARCHAR(255), Answer VARCHAR(255))");
            sbs.statement.addBatch("INSERT INTO QA VALUES (1,'Where can i find my class schedule?', 'On our moodle system'),\n"
                    + "(2,How can i find out about student loans?', 'In your inception brochure'),\n"
                    + "(3,'Where can i find vegetarian restaurants on campus?', 'Our AUT app'),\n"
                    + "(4'When can i get my exam schedule?', 'In 2 weeks time')");
            sbs.statement.executeBatch();
            System.out.println("executed Batch sbs");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + " no gooda");
        }
        sbs.closeConnection();
    }
    
    public void closeConnection() {
        this.dbManager.closeConnections();
    }

}