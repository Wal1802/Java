package Button;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import Front.Main;
import javax.swing.*;

public class Create extends JButton {

	private static final long serialVersionUID = -1162271566827801713L;
        public Main main;
	
	public Create(Main main){
		super();
		this.setToolTipText("Create");
		this.setIcon(new ImageIcon(Main.class.getResource("/Icon/Create.png")));
		this.setForeground(Color.DARK_GRAY);
		this.setBorderPainted(false);
		this.setBorder(null);
		this.setBackground(Color.DARK_GRAY);
                this.main=main;
                main.content._textEditor.setText("");
		this.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e){
                            buttonPress();
                        }
		});
                
	}
        public void buttonPress(){
            System.out.println("Soy el boton de Create");
            main.content.panel.setVisible(true);
            main.content._textEditor.setVisible(true);
            main.content.game.start();
            if ( main.content._textEditor.getText().toString().length() > 0){
                main.setAlwaysOnTop(false);
               try{
               int op = JOptionPane.showConfirmDialog(null, "Se perdera el progreso, ¿Desea guardar?", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
               if (op == JOptionPane.YES_OPTION){
                   main._buttonHolder.save.save();
                   System.err.println("Limpiame");
               }
               else{

               }
               }catch(Exception ee){
                   System.out.println();
               }                                
                main.content._textEditor.setEditable(true);

            }
            else{
                if(main.content._textEditor.getText().toString().length()<=73){
                    main.content._textEditor.setEditable(true);

                }

            }
			
                    
        }
	
}
