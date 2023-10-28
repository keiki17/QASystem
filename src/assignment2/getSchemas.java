/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment2;

/**
 *
  * @author Daijimara Chan-Ting
 */
import java.sql.*;

public class getSchemas {
    public static void main(String[] args) {
        try {
            // Creating a connection to your Derby database
            Connection conn = DriverManager.getConnection("jdbc:derby:qna;create=true");

            // Retrieving the current schema
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet rs = dbmd.getSchemas();

            // Assume the schema you're looking for is the default (APP)
            String currentSchema = null;
            while (rs.next()) {
                if (rs.getBoolean("IS_DEFAULT")) {  // Checking if this is the default schema
                    currentSchema = rs.getString("TABLE_SCHEM");
                    break;
                }
            }

            if (currentSchema != null) {
                System.out.println("Current schema is: " + currentSchema);
            } else {
                System.out.println("No default schema found.");
            }

            // Clean-up
            rs.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace(); // Handle errors for JDBC
        }
    }
}

