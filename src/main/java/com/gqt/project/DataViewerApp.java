package com.gqt.project;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class DataViewerApp extends JFrame {

    private JTable table;
    private DefaultTableModel tableModel;
    private JButton openFileButton;

    public DataViewerApp() {
        setTitle("Employee Data Viewer");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        openFileButton = new JButton("Choose File");
        topPanel.add(openFileButton);
        add(topPanel, BorderLayout.NORTH);

        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
        
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        openFileButton.addActionListener(e -> openFileChooser());
    }

    private void openFileChooser() {
        JFileChooser fileChooser = new JFileChooser();
        
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            loadDataIntoTable(selectedFile);
        }
    }

    private void loadDataIntoTable(File file) {
        tableModel.setRowCount(0);
        tableModel.setColumnCount(0);

        try (FileReader fr = new FileReader(file);
             Scanner scan = new Scanner(fr)) {

            boolean isHeader = true;

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                
                if (line.trim().isEmpty()) { continue;}

                String[] data = line.split(",");

                if (data.length == 5) {
                    if (isHeader) {
                        tableModel.setColumnIdentifiers(data);
                        isHeader = false;
                    } else {
                        tableModel.addRow(data);
                    }
                }
            }
            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,"Error reading file: " + e.getMessage(),"File Error",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DataViewerApp app = new DataViewerApp();
            app.setVisible(true);
        });
    }
}