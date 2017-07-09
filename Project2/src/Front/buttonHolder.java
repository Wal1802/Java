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
import java.awt.Dimension;

public class buttonHolder extends JToolBar {

    private static final long serialVersionUID = -4751991953973098875L;
    public Main main;
    public Save save;
    public Create create;
    public Open open;
    public Redo redo;
    public Undo undo;
    public bConclusion conclusion;
    public bPremisa premisa;
    public bRegla regla;
    
    
    public buttonHolder(Main main){
        super();
        this.setBorder(null);
        this.setFloatable(false);
        this.setBackground(Color.DARK_GRAY);
        this.setEnabled(false);
        this.setBounds(0, 0, 794, 31);
        this.main=main;
        this.setPreferredSize(new Dimension(main.getWidth(), main.getHeight()));
        this.add(create = new Create(main));
        this.add(open = new Open(main));
        this.add(save=new Save(main));
        this.add(undo = new Undo());
        this.add(redo = new Redo());
        this.add(premisa = new bPremisa(main));
        this.add(regla = new bRegla(main));
        this.add(conclusion = new bConclusion(main));
    }
}
