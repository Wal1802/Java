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
    public bRegla regla;
    public bPremisa premisa;
    public bConclusion conclusion;
    public Redo redo;
    public Undo undo;
    public Open open;
    public buttonHolder(Main main){
        super();
        this.addKeyListener(main);
        this.setBorder(null);
        this.setFloatable(false);
        this.setBackground(Color.DARK_GRAY);
        this.setEnabled(false);
        this.setBounds(0, 0, 794, 31);
        this.main=main;
        this.setPreferredSize(new Dimension(main.getWidth(), main.getHeight()));
        this.add(create = new Create(main));
        this.add(open =new Open(main));
        this.add(save=new Save(main));
        this.add(undo=new Undo(main));
        this.add(redo=new Redo(main));
        this.add(premisa=new bPremisa(main));
        this.add(regla=new bRegla(main));
        this.add(conclusion=new bConclusion(main));
    }
}
