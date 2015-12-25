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
public class CodeLine implements Line {

    /** string value of the code line */
    private String string;
    
    /** type of this line */
    private static final LineType LINE_TYPE = LineType.CODE_LINE;
    
    /**
     * Constructor
     * @param string string value of the code line
     */
    public CodeLine(String string) {
        this.string = string;
    }
    
    /**
     * Get string value of the code line
     * @return string value of the code line
     */
    @Override
    public String getString() {
        return string;
    }

    /**
     * Get type of this line
     * @return type of this line
     */
    @Override
    public LineType getType() {
        return LINE_TYPE;
    }
}
