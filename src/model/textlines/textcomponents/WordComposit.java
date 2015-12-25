/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.textlines.textcomponents;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Sasha
 */
public class WordComposit implements TextComponent {

    /** char array of the word */
    private ArrayList<CharLeaf> chars;
    
    /** component type */
    private static final TextComponentType TYPE = TextComponentType.WORD;
    
    /**
     * Constructor
     */
    public WordComposit() {
        chars = new ArrayList<>();
    }
    
    /**
     * Get string consists from char array
     * @return string value consists from char array
     */
    @Override
    public String getString() {
        StringBuilder string = new StringBuilder();
        for (Iterator it = chars.iterator(); it.hasNext();) {
            string.append(((CharLeaf)it.next()).getString());
        }
        return string.toString();
    }

    /**
     * Get component type
     * @return component type
     */
    @Override
    public TextComponentType getType() {
        return TYPE;
    }
    
    /**
     * Add char leaf to the char array
     * @param chl char leaf variable might be added to the char array
     */
    public void addCharLeaf(CharLeaf chl) {
        chars.add(chl);
    }
    
    /**
     * Get all chars of the word
     * @return word chars
     */
    public ArrayList<CharLeaf> getAllChars() {
        return chars;
    }
    
    /**
     * Remove char leaf by index
     * @param index index of char leaf required to be removed
     */
    public void removeCharLeaf(int index) {
        chars.remove(index);
    }
    
    public CharLeaf getCharLeaf(int index) {
        if (chars != null) {
            return chars.get(index);
        }
        return null;
    }
}
