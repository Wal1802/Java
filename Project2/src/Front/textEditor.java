package Front;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JEditorPane;

import Type.Conclusion;
import Type.Premisa;
import Type.Regla;
import Type.basicType;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;
import javax.swing.JTextPane;
import javax.swing.text.DefaultStyledDocument;


public class textEditor extends JTextPane implements KeyListener{
        public Main main;
	private static final long serialVersionUID = 6001669765747941266L;

       // private ArrayList<String> text= new ArrayList<String>();
        private String start = "<html><head></head><body color=\"white\">\n", end ="</body></html>";

        

	private ArrayList<basicType> argumento = new ArrayList<basicType>();
	private Thread printHtml = new Thread(()->notClear());
	
	
	public textEditor(DefaultStyledDocument doc, Main main){
		super();
                this.main=main;
		//text.add(0, start);
                
                //text.add(2, end);
		this.setBackground(Color.DARK_GRAY);
		//this.setContentType("text/html");
               // this.setTextIterator();
		this.setCaretColor(Color.WHITE);
		this.setBounds(10, 42, 371, 366);
		this.setEditable(false);
                this.setText(start+new Premisa("hola").getHtml()+end);
		printHtml.start();
		
	}

	
	// TODO agregar Premisa WIP
	public void add(Premisa p){
		argumento.add(p);
		String buffer[], start[]= this.getText().split("<body color=\"white\">");
		buffer=start[1].split(p.getText());
		
		int length =start[1].length();
		int index= start[1].indexOf(p.getText());
		
		int cont = buffer[0].length();
		System.out.println("Start[0]="+start[0]+" Index:"+index+" Length="+length+" Contador:"+cont);
		int i= 0, max= buffer.length, Start=this.getSelectionStart();
		this.setText(start[0]+"<body color=\"white\">");
		while(cont<Start){
			this.setText(this.getText()+buffer[i++]+p.getText());
			cont+=buffer[i].length();
		}
		this.setText(this.getText()+buffer[i++]+p.getHtml());
		while(i<max){
			this.setText(this.getText()+buffer[i++]);
		}
		
		
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
		argumento.add(r);
	}
	
	// TODO agregar conclusion WIP
	public void add(Conclusion c){
		argumento.add(c);
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

    

}
