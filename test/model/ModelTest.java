/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import model.textlines.Line;
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
public class ModelTest {
    
    public ModelTest() {
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
     * Test of parseLine method, of class Model.
     */
    @Test
    public void testParseLine() {
        System.out.println("parseLine");
        String line;
        Model model = new Model();
        
        line = "";
        model.parseLine(line);
        assertEquals(model.getAllLines().size(), 0);
        
        line = "public";
        model.parseLine(line);
        assertEquals(LineType.CODE_LINE, model.getAllLines().get(0).getType());
        
        model.clear();
        line = "{}"; // index 1
        model.parseLine(line);
        assertEquals(LineType.CODE_LINE, model.getAllLines().get(0).getType());
        
        model.clear();
        line = "{"; // index 0
        model.parseLine(line);
        line = "some text"; // index 1
        model.parseLine(line);
        assertEquals(LineType.CODE_LINE, model.getAllLines().get(1).getType());
        line = "}"; // index 2
        model.parseLine(line);
        line = "some text"; // index 3
        model.parseLine(line);
        assertEquals(LineType.TEXT_LINE, model.getAllLines().get(3).getType());
        
        model.clear();
        line = "text//**//";
        model.parseLine(line);
        assertEquals(LineType.TEXT_LINE, model.getAllLines().get(0).getType());
        
        model.clear();
        line = "public//**//";
        model.parseLine(line);
        assertEquals(LineType.CODE_LINE, model.getAllLines().get(0).getType());
    }

    /**
     * Test of getAllLines method, of class Model.
     */
    @Test
    public void testGetAllLines() {
        System.out.println("getAllLines");
        Model model = new Model();
        String line;
        model.clear();
        line = "line 1";
        model.parseLine(line);
        line = "line 2";
        model.parseLine(line);
        line = "line 3";
        model.parseLine(line);
        line = "line 4";
        model.parseLine(line);
        ArrayList<Line> result = model.getAllLines();
        assertEquals(4, result.size());
    }

    /**
     * Test of textConversion method, of class Model.
     */
    @Test
    public void testTextConversion() {
        System.out.println("textConversion");
        Model model = new Model();
        String line = "abababababbbaabaabbaabbbaaabbabababbab";
        model.parseLine(line);
        model.textConversion();
        String lineExpected = "ab";
        String lineResult = model.getAllLines().get(0).getString();
        assertEquals(lineExpected, lineResult);
        
        model.clear();
        line = "I";
        model.parseLine(line);
        model.textConversion();
        lineExpected = "I";
        lineResult = model.getAllLines().get(0).getString();
        assertEquals(lineExpected, lineResult);
        
        model.clear();
        line = "abCd";
        model.parseLine(line);
        model.textConversion();
        lineExpected = "abCd";
        lineResult = model.getAllLines().get(0).getString();
        assertEquals(lineExpected, lineResult);
    }
}
