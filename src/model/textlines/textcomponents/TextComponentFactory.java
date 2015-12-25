/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.textlines.textcomponents;

import java.util.HashMap;

/**
 *
 * @author Sasha
 */
public class TextComponentFactory {
    
    /** all words have been used */
    private HashMap<String, TextComponent> words;
    
    /** all punctuanion marks have been used */
    private HashMap<String, TextComponent> punctuationMarks;
    
    /** all characters from which words consists */
    private HashMap<String, TextComponent> chars;
    
    /**
     * Get text component
     * @param string string value of the text
     * @param type type of the text component: word or punctuation mark
     * @return object of the required text component
     */
    public TextComponent getTextComponent(String string, TextComponentType type) {
        switch (type) {
            case PUNCTUATION_MARK:
                return getPunctuationMark(string);
            case WORD:
                return getWord(string);
            default:
                return null;
        }
    }
    
    /**
     * Get punctuayion mark object
     * @param string string value of punctuation mark
     * @return punctuation mark object
     */
    private TextComponent getPunctuationMark(String string) {
        if (punctuationMarks == null) {
            punctuationMarks = new HashMap<>();
        }
        if (punctuationMarks.containsKey(string)) {
            return punctuationMarks.get(string);
        } else {
            TextComponent newComponent = new CharLeaf(string);
            punctuationMarks.put(string, newComponent);
            return newComponent;
        }
    }
    
    /**
     * Get word object
     * @param stringstring value of word
     * @return word object
     */
    private TextComponent getWord(String string) {
        if (words == null) {
            words = new HashMap<>();
        }
        if (words.containsKey(string)) {
            return words.get(string);
        } else {
            TextComponent newWord = new WordComposit();
            for (int i = 0; i < string.length(); i++) {
                String symbol = Character.toString(string.charAt(i));
                CharLeaf charLeaf = getCharLeaf(symbol);
                ((WordComposit) newWord).addCharLeaf(charLeaf);
            }
            words.put(string, newWord);
            return newWord;
        }
    }
    
    /**
     * Get char leaf object
     * @param string value of char leaf
     * @return char leaf object
     */
    private CharLeaf getCharLeaf(String symbol) {
        if (chars == null) {
            chars = new HashMap<>();
        }
        if (chars.containsKey(symbol)) {
            return (CharLeaf) chars.get(symbol);
        } else {
            CharLeaf newCharLeaf = new CharLeaf(symbol);
            chars.put(symbol, newCharLeaf);
            return newCharLeaf;
        }
    }
}
