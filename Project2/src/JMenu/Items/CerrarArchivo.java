
package JMenu.Items;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;


public class CerrarArchivo extends JMenuItem {
    public CerrarArchivo(){
        super("Cerrar Archivo");
        this.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e){
                System.out.println("Soy el boton de Cerrar archivo");				
            }
        });
    }
    
}
