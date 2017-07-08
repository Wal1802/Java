
package JMenu.Items;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;


public class NuevoArchivo extends JMenuItem {
    
    public NuevoArchivo(){
        super("Nuevo Archivo");
        this.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e){
                System.out.println("Soy el boton de Nuevo archivo");				
            }
        });        
    }    
}
