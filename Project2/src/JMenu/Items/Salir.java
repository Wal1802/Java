
package JMenu.Items;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;

public class Salir extends JMenuItem {
    public Salir(){
        super("Salir");
        this.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e){
                System.out.println("Soy el boton de Salir");				
            }
	});
    }
}
