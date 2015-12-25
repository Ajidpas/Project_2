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
public class LineDirector {
    
    /** concrete line builder */
    private LineBuilder lineBuilder;
    
    /**
     * Constructor
     * @param lineType type of the line required to be created
     */
    public LineDirector(LineType lineType) {
        switch (lineType) {
            case CODE_LINE:
                lineBuilder = new CodeLineBuilder();
                break;
            case TEXT_LINE:
                lineBuilder = new TextLineBuilder();
        }
    }
    
    /**
     * Create and get new line
     * @param line string value of new line
     * @return new line basis on the line variable
     */
    public Line construct(String line) {
        lineBuilder.createNewLine(line);
        return lineBuilder.getReadyLine();
    }
}
