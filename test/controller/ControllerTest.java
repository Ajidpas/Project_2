/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sasha
 */
public class ControllerTest {
    
    public ControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of run method, of class Controller.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        Controller instance = new Controller();
        instance.run();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getTextFromFile method, of class Controller.
     */
    @Test
    public void testGetTextFromFile() {
        System.out.println("getTextFromFile");
        Controller instance = new Controller();
        instance.getTextFromFile();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of printToFile method, of class Controller.
     */
    @Test
    public void testPrintToFile() {
        System.out.println("printToFile");
        Controller instance = new Controller();
        instance.printToFile();
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
