/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;
import java.awt.LayoutManager;
import javax.swing.JPanel;  
/**
 *
 * @author PC
 */
public class TransparentPanel extends JPanel {
    public TransparentPanel() {
        this.setOpaque(false);
    }
    
    public TransparentPanel(LayoutManager layout) {
        this.setLayout(layout);
    }
}