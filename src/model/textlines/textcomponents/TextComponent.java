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
public interface TextComponent {
    
    /**
     * Get string value
     * @return string value
     */
    String getString();
    
    /**
     * Get text component type
     * @return text component type
     */
    TextComponentType getType();
    
}
