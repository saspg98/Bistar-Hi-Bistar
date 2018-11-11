/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custom.components;

import java.awt.FlowLayout;
import java.awt.LayoutManager;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author Sarthak
 */
public class PButton extends JComponent {
    JPanel outer;
    JButton button;
    boolean isSelected=false;
    
    public PButton(){
        super();
        outer= new JPanel();
        button = new JButton("Button");
        button.setSize(300, 100);
        outer.add(button);
        outer.setLayout(new FlowLayout(FlowLayout.RIGHT));
    }
}
