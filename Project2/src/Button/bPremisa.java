package Button;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import Front.Main;
import Type.Premisa;

public class bPremisa extends JButton {

    private static final long serialVersionUID = -1162271566827801713L;
    public Main main;

    public bPremisa(Main main){
        super();                
        this.setToolTipText("Premisa");
        this.setIcon(new ImageIcon(Main.class.getResource("/Icon/Premisa.png")));
        this.setForeground(Color.DARK_GRAY);
        this.setBorderPainted(false);
        this.setBorder(null);
        this.setBackground(Color.DARK_GRAY);
        this.main=main;
        this.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e){
                System.out.println("Soy el boton de Premisa");	
                main.content._textEditor.setEditable(false);
                main.seleccion.buttonPremisa();
                //main.content._textEditor.add(new Premisa(main.content._textEditor.getSelectedText()));
            }
        });
    }
	
}
