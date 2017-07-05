package Front;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Main extends JFrame implements KeyListener {
	
	private static final long serialVersionUID = -4055868826129244329L;
	public menuBar _menuBar;
	public Content content;
	public buttonHolder _buttonHolder;
        public MyEditText seleccion;
         private boolean key=false;
	public Main(){
		setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/Icon/Logo.png")));
		setTitle("Arguments Helper");
		setAutoRequestFocus(false);
		setAlwaysOnTop(true);
		setForeground(Color.BLACK);
		setResizable(false);
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 469);
		this.setJMenuBar(_menuBar =new menuBar(this));
		this.setContentPane(content =new Content(this));
		this.add(_buttonHolder = new buttonHolder(this));
		this.addKeyListener(this); 
                this.setFocusable(true);
                this.setFocusTraversalKeysEnabled(false);
                seleccion = new MyEditText(this);
        }
	
	public static void main(String[] args) throws InterruptedException {
		Main main = new Main();
              
		main.setVisible(true);
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
                                case KeyEvent.VK_N: _buttonHolder.create.buttonPress();
                                case KeyEvent.VK_P: this.seleccion.buttonPremisa();  break;
                                default: ;
                            }
                            System.err.println("True");
                        }
                        System.err.println("False");
                    }
                                
   
    


}
