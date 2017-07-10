
package JMenu.Items;

import Front.Main;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;

public class SubButtonLight extends JMenuItem {
    private Main main;
    
        public SubButtonLight(Main main){
        super("Light");
        this.main = main;
        this.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e){
                System.out.println("Soy el boton LIGHT");	
                
                main.content.setBackground(Color.lightGray);
                main.content._textEditor.setBackground(Color.WHITE);
                main._buttonHolder.setBackground(Color.gray);
                main._buttonHolder.create.setBackground(Color.gray);
                main._buttonHolder.regla.setBackground(Color.gray);
                main._buttonHolder.premisa.setBackground(Color.gray);
                main._buttonHolder.conclusion.setBackground(Color.gray);
                main._buttonHolder.undo.setBackground(Color.gray);
                main._buttonHolder.redo.setBackground(Color.gray);
                main._buttonHolder.save.setBackground(Color.gray);
                main._buttonHolder.open.setBackground(Color.gray);
                
            }
        });      
    }
    
}
