package Button;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import Front.Main;
import Type.Conclusion;


public class bConclusion extends JButton {

    private static final long serialVersionUID = -1162271566827801713L;
    public Main main;
    public bConclusion(Main main){
        super();
        this.setToolTipText("Conclusion");
        this.setIcon(new ImageIcon(Main.class.getResource("/Icon/Conclusion.png")));
        this.setForeground(Color.DARK_GRAY);
        this.setBorderPainted(false);
        this.setBorder(null);
        this.setBackground(Color.DARK_GRAY);
        this.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e){
                main.seleccion.buttonConclusion();
                main.content._textEditor.setEditable(false);

                System.out.println("Soy el boton de Conclusion");				
            }
        });
    }
	
}
