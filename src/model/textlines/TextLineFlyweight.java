/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.textlines;

import java.util.ArrayList;
import java.util.Iterator;
import model.LineType;
import model.textlines.textcomponents.TextComponent;
import model.textlines.textcomponents.TextComponentFactory;
import model.textlines.textcomponents.TextComponentType;

/**
 *
 * @author Sasha
 */
public class TextLineFlyweight implements Line {

    /** all text components of this line */
    private ArrayList<TextComponent> textComponents;
    
    /** type of this line */
    private static final LineType LINE_TYPE = LineType.TEXT_LINE;
    
    /**
     * Constructor
     */
    public TextLineFlyweight() {
        textComponents = new ArrayList<>();
    }
    
    /**
     * Get string of entire text line
     * @return string of entire text line
     */
    @Override
    public String getString() {
        StringBuilder string = new StringBuilder();
        for (Iterator it = textComponents.iterator(); it.hasNext();) {
            string.append(((TextComponent) it.next()).getString());
        }
        return string.toString();
    }
    
    /**
     * Add text component to the array list
     * @param string string value of the text component
     * @param type text component type
     */
    public void addComponent(String string, TextComponentType type) {
        TextComponentFactory factory = new TextComponentFactory();
        TextComponent newTextComponent = factory.getTextComponent(string, type);
        if (newTextComponent != null) {
            textComponents.add(newTextComponent);
        }
    }

    /**
     * Get type of this line
     * @return type of this line
     */
    @Override
    public LineType getType() {
        return LINE_TYPE;
    }
    
    /**
     * Get all text components of this line
     * @return all text components of this line
     */
    public ArrayList<TextComponent> getAllComponents() {
        return textComponents;
    }
}
