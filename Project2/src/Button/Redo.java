package Button;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import Front.Main;

public class Redo extends JButton {

    private static final long serialVersionUID = -1162271566827801713L;
    public Main main;
    public Redo(Main main){
        super();
        this.main=main;
        this.addKeyListener(main);
        this.setToolTipText("Redo");
        this.setIcon(new ImageIcon(Main.class.getResource("/Icon/Redo.png")));
        this.setForeground(Color.DARK_GRAY);
        this.setBorderPainted(false);
        this.setBorder(null);
        this.setBackground(Color.DARK_GRAY);
        this.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e){
                System.out.println("Soy el boton de Redo");				
            }
        });
    }
	
}
