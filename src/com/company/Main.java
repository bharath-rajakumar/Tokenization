package com.company;
import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String cranfield_path = "";
        HashMap<String, Integer> myDictionary = new HashMap<String, Integer>();
        Scanner in = new Scanner(System.in);
    // Get the path of Cranfield folder from the user
        System.out.println("Enter the complete path of the Cranfield documents directory");
        cranfield_path = in.next();

    // populate the file names of all document present inside the Cranfield directory in an ArrayList
        File cranfield_folder = new File(cranfield_path);
        File[] listOfFiles = cranfield_folder.listFiles();

        for(int i = 0; i < listOfFiles.length; i++) {
            System.out.println("Reading " + listOfFiles[i].getName());
            // Read each file and perform tokenization on each line except for the tags
            String fileName = listOfFiles[i].getAbsolutePath();
            try {
                BufferedReader br = new BufferedReader(new FileReader(fileName));
                String currentLine;
                while((currentLine = br.readLine()) != null) {
                    System.out.println(currentLine);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("End of File");
            System.out.println("--");
        }
    }

}
