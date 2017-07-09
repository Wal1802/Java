/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JMenu.Items;

import Front.Main;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;


public class SubButtonDark extends JMenuItem {
    private Main main;
    
    public SubButtonDark(Main main){
        super("Dark");
        this.main = main;
        this.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e){
                System.out.println("Soy el boton de DARK");
                
                main.content.setBackground(Color.GRAY);
                main.content._textEditor.setBackground(Color.DARK_GRAY);
                main._buttonHolder.setBackground(Color.darkGray);
                main._buttonHolder.create.setBackground(Color.darkGray);
                main._buttonHolder.regla.setBackground(Color.darkGray);
                main._buttonHolder.premisa.setBackground(Color.darkGray);
                main._buttonHolder.conclusion.setBackground(Color.darkGray);
                main._buttonHolder.undo.setBackground(Color.darkGray);
                main._buttonHolder.redo.setBackground(Color.darkGray);
                main._buttonHolder.save.setBackground(Color.darkGray);
                main._buttonHolder.open.setBackground(Color.darkGray);
            }
        });      
    }
    
}
