package Front;

import java.awt.Color;

import javax.swing.JToolBar;

import Button.bConclusion;
import Button.Create;
import Button.Open;
import Button.Redo;
import Button.bRegla;
import Button.Save;
import Button.Undo;
import Button.bPremisa;

public class buttonHolder extends JToolBar {

	private static final long serialVersionUID = -4751991953973098875L;
	public Main main;
        public Save save;
        public Create create;
	public buttonHolder(Main main){
		super();
		this.setBorder(null);
		this.setFloatable(false);
		this.setBackground(Color.DARK_GRAY);
		this.setEnabled(false);
		this.setBounds(0, 0, 794, 31);
		this.main=main;
		this.add(create = new Create(main));
		this.add(new Open(main));
		this.add(save=new Save(main));
		this.add(new Undo());
		this.add(new Redo());
		this.add(new bPremisa(main));
		this.add(new bRegla(main));
		this.add(new bConclusion(main));
		
	}
}
