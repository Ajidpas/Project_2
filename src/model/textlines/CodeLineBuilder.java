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
public class CodeLineBuilder implements LineBuilder {

    /** code line object */
    private CodeLine codeLine;
    
    /**
     * Create new code line
     * @param line string value of the code line
     */
    @Override
    public void createNewLine(String line) {
        codeLine = new CodeLine(line);
    }

    /**
     * Get code line ready for use
     * @return code line ready for use
     */
    @Override
    public Line getReadyLine() {
        return codeLine;
    }
    
}
