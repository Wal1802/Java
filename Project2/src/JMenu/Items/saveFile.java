/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JMenu.Items;


import Front.Main;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;

/**
 *
 * @author OACS
 */
public class saveFile extends JMenuItem{
    private Main main;
    public saveFile(Main main){
        super();
        this.setText("Guardar Archivo");
        this.main = main;
        this.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e){
                main._buttonHolder.save.save();						
            }
        });
    }
}
