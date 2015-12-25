/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.textlines;

import model.LineType;

/**
 *
 * @author Sasha
 */
public interface Line {
    
    /**
     * Get string value of entire line
     * @return 
     */
    String getString();
    
    /**
     * Get line type
     * @return line type
     */
    LineType getType();
}
