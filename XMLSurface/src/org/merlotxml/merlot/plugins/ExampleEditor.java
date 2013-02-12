package org.merlotxml.merlot.plugins;

import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.beans.PropertyVetoException;
import org.merlotxml.merlot.*;
import org.merlotxml.util.xml.*;


public class ExampleEditor implements MerlotDOMEditor 
{
    /**
     * Returns a set of menu items for any special actions for 
     * this particular editor
     * that it wants in the popup menu. Standard stuff like cut, copy, paste
     * is taken care of by other objects. If nothing needs added,
     * can return null.
     * 
     * @param node the node for which to get the menu items
     */
    public  JMenuItem[] getMenuItems(MerlotDOMNode node)
    {
    return null;
    }
    
    /**
     * returns a panel for editing this type of component.
     */
    public JPanel getEditPanel(MerlotDOMNode node) 
    {
      System.out.println("Custom edit panel");
      // this function must create an *EditPanel, so just use the vanilla one
    return new GenericDOMEditPanel(node);
    }
    
    /**
     * called by the editor when the user has chosen to save their
     * changes in a panel. 
     * @param p the panel that was retreived with getEditPanel(node);
     *
     */
    public void savePanel(JPanel p)
    throws PropertyVetoException
    {
    if (p instanceof GenericDOMEditPanel) {
        (( GenericDOMEditPanel)p).save();
    }
    }
    
    
    /**
     * Tells the edit panel it's gaining focus, so it can put the cursor in the first
     * field. XXX this should probably be handled by event listening instead
     */
    public void grabFocus(JPanel p)
    {
    }
    
    /**
     * Returns true if the component editor wants a particular node hidden
     * from the user. If the editor wants to filter 
     * what the user sees in their display, it should look at the
     * given node, otherwise it should return false. This is usefull
     * particularly if the editor handles its children. It can hide
     * the children nodes from the user's view.
     */
    public boolean suppressNode(MerlotDOMNode node) 
    {
    return false;
    }
    
    /**
     * allows the plugin to hide certain items on the add-> menu. For
     * example, the plugin for the accessibility permissions might not
     * want the user to be able to directly add an "access" element, so
     * it can request that that be suppressed.
     */
    public boolean suppressAddType(DTDElement el)
    {
    return false;
    }

    /**
     * allows the plugin to hide certain items on the add-> menu. For
     * example, the plugin for the accessibility permissions might not
     * want the user to be able to directly add an "access" element, so
     * it can request that that be suppressed.
     */
    public boolean suppressAddType(GrammarComplexType el) 
    {
        return false;
    }  
}
