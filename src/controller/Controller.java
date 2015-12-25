/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import model.Model;
import model.textlines.Line;

/**
 *
 * @author Sasha
 */
public class Controller {
    
    /** model object */
    private final Model model;
    
    /**
     * Constructor
     */
    public Controller() {
        model = new Model();
    }
    
    /**
     * Programm starts from this method
     */
    public void run() {
        getTextFromFile();
        model.textConversion();
        printToFile();
    }
    
    /**
     * Get text from file
     */
    public void getTextFromFile() {
        try (BufferedReader input = new BufferedReader(new FileReader("text\\TextFile.txt"))) {
            String s;
            while ((s = input.readLine()) != null) {
                model.parseLine(s);
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
    
    /**
     * Print to file all lines
     */
    public void printToFile() {
        ArrayList<Line> lines = model.getAllLines();
        try (BufferedWriter output = new BufferedWriter(new FileWriter("text\\TextFile2.txt"))) {
            for (Iterator it = lines.iterator(); it.hasNext();) {
                output.write(((Line) it.next()).getString());
                output.write("\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
}
