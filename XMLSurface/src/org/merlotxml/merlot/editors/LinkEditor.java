/*
 
 	Author: Santiago Pina Ros

*/
package org.merlotxml.merlot.editors;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.merlotxml.merlot.MerlotDebug;
import org.merlotxml.util.xml.DTDConstants;
import org.merlotxml.util.xml.FieldNode;
import org.merlotxml.util.xml.GrammarSimpleType;


/**
 * @author Santiago Pina
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class LinkEditor extends SimpleTypeEditor {
    private JTextField text = null;
    private JButton button = null;

    public LinkEditor(ComplexTypeEditPanel complexTypeEditPanel, 
                             GrammarSimpleType grammarSimpleType) {
        super(complexTypeEditPanel, grammarSimpleType);
    }

    /**
     * Gets the component for editing this simple type.
     *
     * @return   The component value
     */
    public JComponent getComponent() {
        if (_component != null) {
            return _component;
        }
        MerlotDebug.msg("Getting component for " + _grammarSimpleType.getName());
        
        JPanel panel = new JPanel();
        text = new JTextField();
        text.setPreferredSize(new Dimension(400,30));
        button = new JButton("Browse");
        
        button.addActionListener(new ActionListener() {
        	      public void actionPerformed(ActionEvent e) {
        	        JFileChooser fileChooser = new JFileChooser();
        	        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        	        fileChooser.setAcceptAllFileFilterUsed(false);
        	        int rVal = fileChooser.showOpenDialog(null);
        	        if (rVal == JFileChooser.APPROVE_OPTION) {
        	          text.setText(fileChooser.getSelectedFile().toString());
        	        }
        	      }
        	    });

        
        
        panel.add(text);
        panel.add(button);
        
        _component = panel;
        
        return _component;
    }

    /**
     * Gets whether the component is currently disabled or not.
     *
     * @return   The editable value
     */
    public boolean getEditable() {
        return text.isEnabled();
    }

    /**
     * Retrieves the value from this component.
     *
     * @return   The value
     */
    public String getValue() {
        getComponent();
        String ret = text.getText();
        if (ret == null)
            ret = "";
        return ret;
        
    }

    /**
     * Sets the component to editable or read-only.
     *
     * @param editable  The new editable value
     */
    public void setEditable(boolean editable) {
        text.setEnabled(editable);
    }

    /**
     * Sets the value of the component.
     *
     * @param value  The new value value
     */
    public void setValue(String value) {
        getComponent();
        if (value != null) {
            text.setText(value);
        }
        else {
            value = _grammarSimpleType.getDefaultValue();
            if (value != null) {
                text.setText(value);
            }
        }
        if (_grammarSimpleType.getDefaultType() == DTDConstants.FIXED) {
            text.setEditable(false);
        }
    }
}
