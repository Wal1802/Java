
package JMenu.Items;

import Front.Main;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;


public class SubButtonIndigo extends JMenuItem {
    private Main main;
    public SubButtonIndigo(Main main){
        super("Indigo Ocean");
        this.main = main;
        this.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e){
                System.out.println("Soy el boton TWILIGHT");
                main.content.setBackground(new Color(12, 146, 184));
                main.content._textEditor.setBackground(new Color(42, 117, 131));
                main._buttonHolder.setBackground(new Color(42, 117, 131));
                main._buttonHolder.create.setBackground(new Color(42, 117, 131));
                main._buttonHolder.regla.setBackground(new Color(42, 117, 131));
                main._buttonHolder.premisa.setBackground(new Color(42, 117, 131));
                main._buttonHolder.conclusion.setBackground(new Color(42, 117, 131));
                main._buttonHolder.undo.setBackground(new Color(42, 117, 131));
                main._buttonHolder.redo.setBackground(new Color(42, 117, 131));
                main._buttonHolder.save.setBackground(new Color(42, 117, 131));
                main._buttonHolder.open.setBackground(new Color(42, 117, 131));
                
            }
        });      
    }
}
