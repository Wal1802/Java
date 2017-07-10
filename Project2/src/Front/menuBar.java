package Front;

import java.awt.Color;

import javax.swing.JMenuBar;

import JMenu.File;
import JMenu.Opciones;

public class menuBar extends JMenuBar {

    private static final long serialVersionUID = -5471751719196673964L;

    public menuBar(Main main){
        super();
        this.setForeground(Color.GRAY);
        this.setBackground(Color.WHITE);
        this.add(new File(main));
        this.add(new Opciones(main));
    }
}
