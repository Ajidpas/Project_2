/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.textlines;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.textlines.textcomponents.TextComponentType;

/**
 *
 * @author Sasha
 */
public class TextLineBuilder implements LineBuilder {
    
    /** text line object */
    private TextLineFlyweight textLine;

    /** pattern object for parsing by single character */
    private final static Pattern SYMBOL_PATTERN = Pattern.compile(".");
    
    /** 
     * regular expression that respects to any letter of anglish and russian 
     * alphabet for separate words parsing
     */
    private final static String ANY_LETTER = "[A-Za-zА-Яа-я]";
    
    /**
     * Create new text line
     * @param line new text line
     */
    @Override
    public void createNewLine(String line) {
        textLine = new TextLineFlyweight();
        Matcher symbolMatcher = SYMBOL_PATTERN.matcher(line);
        StringBuilder newWord = new StringBuilder();
        String matchedSymbol;
        while (symbolMatcher.find()) {
            matchedSymbol = symbolMatcher.group();
            if (matchedSymbol.matches(ANY_LETTER)) {
                newWord.append(matchedSymbol);
            } else {
                if (newWord.length() > 0) {
                    textLine.addComponent(newWord.toString(), TextComponentType.WORD);
                    newWord = new StringBuilder();
                }
                textLine.addComponent(matchedSymbol, TextComponentType.PUNCTUATION_MARK);
            }
        }
        if (newWord.length() > 0) {
            textLine.addComponent(newWord.toString(), TextComponentType.WORD);
        }
    }

    /**
     * Get text line ready for use 
     * @return text line ready for use
     */
    @Override
    public Line getReadyLine() {
        return textLine;
    }
    
    
}
