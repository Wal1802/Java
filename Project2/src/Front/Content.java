package Front;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

public class Content extends JPanel {

	private static final long serialVersionUID = -6100804496614598165L;
        DefaultStyledDocument document = new DefaultStyledDocument();
       
       
	public textEditor _textEditor;
	public Graph game;
	public Main main;
        public  JPanel panel;
	public Content(Main main){
		super();
		this.setVisible(true);
		this.setBackground(Color.GRAY);
		this.setBorder(null);		
		this.setLayout(null);
                game = new Graph(main);
              //  game.start();
                
                
		this.add(_textEditor = new textEditor(document, main));
                   
                _textEditor.setVisible(false); // para que no salga de unare la pantalla de texto
                panel = new JPanel();
                panel.setLayout(null);
                panel.setBounds(400, 40, 500, 500);
                panel.setBackground(Color.DARK_GRAY);
                
               
		this.add(panel);
                panel.add(game);
                panel.setVisible(false);
		
	}
}
