package Front;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.text.DefaultStyledDocument;

public class Content extends JPanel {

	private static final long serialVersionUID = -6100804496614598165L;
        DefaultStyledDocument document = new DefaultStyledDocument();
	public textEditor _textEditor;
	public Graph game;
	public Main main;
	public Content(Main main){
		super();
		this.setVisible(true);
		this.setBackground(Color.GRAY);
		this.setBorder(null);		
		this.setLayout(null);
                game = new Graph(main);
                game.start();
		this.add(_textEditor = new textEditor(document, main));
                
                JPanel panel = new JPanel();
                panel.setLayout(null);
                panel.setBounds(400, 40, 500, 500);
                panel.setBackground(Color.DARK_GRAY);
                
               
		this.add(panel);
                panel.add(game);
		
	}
}
