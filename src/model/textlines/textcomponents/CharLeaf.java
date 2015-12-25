/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.textlines.textcomponents;

/**
 *
 * @author Sasha
 */
public class CharLeaf implements TextComponent {

    /** character */
    private final char character;
    
    /** component type */
    private static final TextComponentType TYPE = TextComponentType.PUNCTUATION_MARK;
    
    public CharLeaf(String string) {
        character = string.charAt(0);
    }
    
    /**
     * Get character with string type
     * @return character with string type
     */
    @Override
    public String getString() {
        return Character.toString(character);
    }

    /**
     * Get type
     * @return type
     */
    @Override
    public TextComponentType getType() {
        return TYPE;
    }
    
}
