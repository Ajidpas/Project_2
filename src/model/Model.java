/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.textlines.TextLineFlyweight;
import model.textlines.Line;
import model.textlines.LineDirector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.textlines.textcomponents.CharLeaf;
import model.textlines.textcomponents.TextComponent;
import model.textlines.textcomponents.TextComponentType;
import model.textlines.textcomponents.WordComposit;

/**
 *
 * @author Sasha
 */
public class Model {
    
    /** array list of text lines */
    private ArrayList<Line> lines;
    
    /** regular expression for code line when we can define the code just by one line */
    private static final Pattern CODE_ONE_LINE_PATTERN = Pattern.compile("^\\s*((\\/\\/)|(\\/\\*)|(\\/\\*\\*)|(\\*)|(\\*\\/)|(\\{.*\\})|(import)|(package)|(System)|(public))");
    
    /** regular expression of open curly brace in the java code */
    //private static final Pattern CODE_OPEN_CURLY_BRACE_PATTERN = Pattern.compile("^\\s*.*\\{");
    private static final Pattern CODE_OPEN_CURLY_BRACE_PATTERN = Pattern.compile("\\{");
    
    /** regular expression of close curly brace in the java code */
    //private static final Pattern CODE_CLOSE_CURLY_BRACE_PATTERN = Pattern.compile("^\\s*.*\\}");
    private static final Pattern CODE_CLOSE_CURLY_BRACE_PATTERN = Pattern.compile("\\}");
    
    /** count open and close curly braces to define is here the code or text */
    private static int curlyBraceCount = 0;
    
    /**
     * Constructor
     */
    public Model() {
        lines = new ArrayList<>();
    }
    
    /**
     * Parse line into the text components and add all components into the lines 
     * array list int the natural order
     * @param line text line
     */
    public void parseLine(String line) {
        Matcher codeOneLineMatcher = CODE_ONE_LINE_PATTERN.matcher(line);
        Matcher codeOpenCurlyBraceMatcher = CODE_OPEN_CURLY_BRACE_PATTERN.matcher(line);
        Matcher codeCloseCurlyBraceMatcher = CODE_CLOSE_CURLY_BRACE_PATTERN.matcher(line);
        
        if ((line == null) || line.equals("")) {
            return;
        }        
        if (codeOpenCurlyBraceMatcher.find()) {
            addLineThroughDirector(line, LineType.CODE_LINE);
            do {
                curlyBraceCount++;
            } while(codeOpenCurlyBraceMatcher.find());
            return;
        }
        if (codeCloseCurlyBraceMatcher.find()) {
            addLineThroughDirector(line, LineType.CODE_LINE);
            do {
                curlyBraceCount--;
            } while(codeCloseCurlyBraceMatcher.find());
            return;
        }
        if (codeOneLineMatcher.find()) {
            addLineThroughDirector(line, LineType.CODE_LINE);
            return;
        }
        if (curlyBraceCount == 0) {
            addLineThroughDirector(line, LineType.TEXT_LINE);
        } else {
            addLineThroughDirector(line, LineType.CODE_LINE);
        }
    }
    
    /**
     * add new line with help og the director
     * @param line string line have gotten from the file
     * @param lineType type of the line
     */
    private void addLineThroughDirector(String line, LineType lineType) {
        LineDirector lineDirector = new LineDirector(lineType);
        Line newLine = lineDirector.construct(line);
        lines.add(newLine);
    }
    
    /**
     * Get all lines was created
     * @return array list with text lines
     */
    public ArrayList<Line> getAllLines() {
        return lines;
    }
    
    /**
     * Convetr text according to the rule of conctrete task
     */
    public void textConversion() {
        ArrayList<TextComponent> textComponents;
        for (Line line : lines) {
            if (line.getType() == LineType.TEXT_LINE) {
                textComponents = ((TextLineFlyweight) line).getAllComponents();
                for (TextComponent textComponent : textComponents) {
                    if (textComponent.getType() == TextComponentType.WORD) {
                        removeFirstLast((WordComposit) textComponent);
                    }
                }
            }
        }
    }
    
    /**
     * Remove next first (and previous last) chars in the word
     * @param word current word
     */
    private void removeFirstLast(WordComposit word) {
        ArrayList<CharLeaf> allCharLeafs = word.getAllChars();
        if (allCharLeafs.size() <= 1) {
            return;
        }
        CharLeaf firstCharLeaf = word.getCharLeaf(0);
        CharLeaf lastCharLeaf = word.getCharLeaf(allCharLeafs.size() - 1);
        if (firstCharLeaf.getString().equals(lastCharLeaf.getString())) {
            removeFirst(word, firstCharLeaf);
        } else {
            removeFirst(word, firstCharLeaf);
            removeLast(word, lastCharLeaf);
        }
    }
    
    /**
     * Remove next first chars in the word
     * @param word current word
     * @param firstCharLeaf first char of this word
     */
    private void removeFirst(WordComposit word, CharLeaf firstCharLeaf) {
        int arraySize = word.getAllChars().size();
        for (int i = arraySize - 1; i > 0; i--) {
            if (word.getCharLeaf(i).getString().equals(firstCharLeaf.getString())) {
                word.removeCharLeaf(i);
            } 
        }
    }
    
    /**
     * Remove previous last chars in the word
     * @param word current word
     * @param lastCharLeaf first char of this word
     */
    private void removeLast(WordComposit word, CharLeaf lastCharLeaf) {
        int arraySize = word.getAllChars().size();
        for (int i = arraySize - 2; i >= 0; i--) {
            if (word.getCharLeaf(i).getString().equals(lastCharLeaf.getString())) {
                word.removeCharLeaf(i);
            } 
        }
    }
    
    /**
     * clean array list with lines 
     */
    public void clear() {
        lines.clear();
        curlyBraceCount = 0;
    }
}
