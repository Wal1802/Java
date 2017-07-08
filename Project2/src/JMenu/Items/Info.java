
package JMenu.Items;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;

public class Info extends JMenuItem {
    public Info(){
        super("Acerca de...");
        this.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e){
                System.out.println("Soy el boton de informacion");				
            }
	});
    }
}
