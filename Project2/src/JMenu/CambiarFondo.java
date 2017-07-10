/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JMenu;

import Front.Main;
import JMenu.Items.SubButtonDark;
import JMenu.Items.SubButtonLight;
import JMenu.Items.SubButtonIndigo;
import javax.swing.JMenu;



public class CambiarFondo extends JMenu {
    private SubButtonDark dark;
    private SubButtonLight light;
    private SubButtonIndigo twilight;
    private Main main;
    
    
        public CambiarFondo(Main main){
            super("Cambiar Fondo");
            this.main = main;
            this.dark = new SubButtonDark(main);
            this.light = new SubButtonLight(main);
            this.twilight = new SubButtonIndigo(main);
            
            
            this.add(dark);
            this.add(light);
            this.add(twilight);
            
            
            
    
        }
}
