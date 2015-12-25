/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.textlines;

/**
 *
 * @author Sasha
 */
public interface LineBuilder {
    
    /**
     * Create new line
     * @param line string value of the line
     */
    void createNewLine(String line);
    
    /**
     * Get line ready for use
     * @return text line
     */
    Line getReadyLine();
}
