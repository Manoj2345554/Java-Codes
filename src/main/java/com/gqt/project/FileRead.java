package com.gqt.project;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileRead {

    public static void main(String[] args) {
        String p1 = "C:\\Users\\manoj\\.gemini\\antigravity-ide\\scratch\\DataViewerApp\\data.txt";
        
        System.out.println("Reading and formatting the data...\n");

        try  {
        	
        		FileReader fr = new FileReader(p1);
            Scanner scan = new Scanner(fr);
            
            boolean isHeader = true;
            while (scan.hasNextLine()) {
                String temp = scan.nextLine();
                String[] data = temp.split(",");
                
                if (data.length == 5) {
                    System.out.printf("%-5s | %-16s | %-12s | %-22s | %-8s%n",data[0], data[1], data[2], data[3], data[4]);
                    
                    if (isHeader) {
                        System.out.println("--------------------------------------------------------------------------");
                        isHeader = false;
                    }
                }
               
            }
            scan.close();
            fr.close();
            
        } catch (IOException e) {
            System.err.println("An error occurred while trying to read the file.");
            e.printStackTrace();
        }
    }
}