
package JMenu;

import Front.Main;
import javax.swing.JMenu;

public class Opciones extends JMenu{
    private CambiarFondo fondo;
    private Main main;  
    
    public Opciones(Main main){
        super ("Opciones");
        this.main = main;
        this.fondo = new CambiarFondo(main);
        
        
        this.add(fondo);
        
    }
    
}
