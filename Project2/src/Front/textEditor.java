package Front;

import Button.bRegla;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JEditorPane;

import Type.Conclusion;
import Type.Premisa;
import Type.Regla;
import Type.Type;
import Type.basicType;
import java.awt.PopupMenu;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;
import javax.swing.JTextPane;
import javax.swing.text.DefaultStyledDocument;


public class textEditor extends JTextPane implements KeyListener{
        public Main main;
	private static final long serialVersionUID = 6001669765747941266L;
       
   
        

	private ArrayList<basicType> unselected = new ArrayList<basicType>();
        private ArrayList<basicType> argumentos = new ArrayList<basicType>();
	private Thread printHtml = new Thread(()->notClear());	
	
	public textEditor(DefaultStyledDocument doc, Main main){
		super();
                this.main=main;
		this.setBackground(Color.DARK_GRAY);
		this.setCaretColor(Color.WHITE);
		this.setBounds(10, 42, 371, 366);
		this.setEditable(false);
		printHtml.start();
		
	}

	
	// TODO agregar Premisa WIP
	public void add(Premisa p){
		unselected.add(p);						
	}
        
       /* public void setTextIterator(){
            Iterator<String> i = this.text.iterator();
            System.err.println(this.getText());
            this.setText(i.next());           
            System.err.println(this.getText());
            while(i.hasNext()){
                 System.err.println(this.getText());
                this.setText(this.getText()+ i.next());
           
            }
        }*/
	
	// TODO agregar Regla WIP
	public void add(Regla r){
		unselected.add(r);
	}
	
	// TODO agregar conclusion WIP
	public void add(Conclusion c){
            
            while(!unselected.isEmpty()){
                basicType temp= unselected.remove(0);
                if(temp.type== Type.Premisa)
                    c.add((Premisa)temp);
                else
                    if(temp.type== Type.Regla)
                    c.add((Regla)temp);
                }
              
		argumentos.add(c);
                System.err.println("Test");
                main.content.graph.addC(c);
	}
        public boolean key =false;
	private void notClear(){
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println(this.getText());
			//System.out.println(this.getText().split("<body color=\"white\">\n  ")[1].split("</body>")[0].length());
		}
	}
          @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                         System.err.println("True");
                        switch(e.getKeyCode()){
                            case KeyEvent.VK_CONTROL: key=true; break;
                            default: ;
                        }

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                        if(key){
                            switch(e.getKeyCode()){    
                                case KeyEvent.VK_CONTROL: key=false; break;
                                case KeyEvent.VK_N: main._buttonHolder.create.buttonPress();
                                case KeyEvent.VK_P: main.seleccion.buttonPremisa();  break;
                                default: ;
                            }
                            System.err.println("True");
                        }
                        System.err.println("False");
                    }

    private static class Triangle extends PopupMenu {

        public Triangle() {
        }
    }



    

}
