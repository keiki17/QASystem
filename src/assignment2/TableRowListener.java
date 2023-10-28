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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.*;

public class TableRowListener {
    
    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Data and columns for the table
        Object[][] rowData = {
                {1, "Data1"},
                {2, "Data2"},
                {3, "Data3"},
                // add your data here
        };
        Object[] columnNames = {"ID", "Data"};

        // Create table with data
        JTable table = new JTable(rowData, columnNames);

        // Method 1: Add a list selection listener to detect row selection changes
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) { // this event is triggered twice, this check helps to skip one
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow >= 0) {
                        Object selectedRowId = table.getValueAt(selectedRow, 0); // 0 for "ID" column
                        System.out.println("Row selected with ID: " + selectedRowId);
                        // perform your actions based on the selected row with the ID
                    }
                }
            }
        });

        // Method 2: Add a mouse event listener to detect clicks
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) { // detect double-click
                    JTable target = (JTable) e.getSource();
                    int selectedRow = target.getSelectedRow();
                    if (selectedRow >= 0) {
                        Object selectedRowId = table.getValueAt(selectedRow, 0); // 0 for "ID" column
                        System.out.println("Double-clicked on row with ID: " + selectedRowId);
                        // perform your actions based on the clicked row with the ID
                    }
                }
            }
        });

        // Set up the frame and display it
        frame.setLayout(new BorderLayout());
        frame.add(new JScrollPane(table), BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null); // center the frame
        frame.setVisible(true);
    }
}

