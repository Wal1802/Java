package Front;


import CanvasItems.Triangle;
import Type.Conclusion;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;


public class Graph extends Canvas implements Runnable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2156860797447575242L;
	private final int WIDTH = 640, HEIGTH = WIDTH / 12 * 9;
	private Thread thread;
	private boolean running = false;
	private Main main;
        private MouseListener m;
        private int size =40;
        private ArrayList<Triangle> triangle = new ArrayList<Triangle>();
	private Triangle t=new Triangle(0,0,1,new Conclusion("")), move=t;
        private int refX=0, refY=0;
	private int cont =0;
        private boolean clickOnTriangle=false, clicked = false;
        private int clickedTriangle;
	public Graph(Main main){
     
            this.main=main;
            this.setVisible(true);
            this.setBounds(0, 0, 500, 500);
            triangle.add(t);
             triangle.add(t);
            this.addMouseWheelListener(new MouseWheelListener() {
                @Override
                public void mouseWheelMoved(MouseWheelEvent e) {
                    System.err.println(e.getWheelRotation());
                    Iterator i =triangle.iterator();
                    while(i.hasNext()){
                        ((Triangle)i.next()).zoom +=0.01*e.getWheelRotation();
                        System.err.println(t.zoom); }
                }
            });
            this.addMouseMotionListener(new MouseMotionListener() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    
                    if(!clicked){
                        clicked=true;
                     Triangle auxT=null;
                        Iterator i =triangle.iterator();
                        int j=0;
                        while(i.hasNext()){
                            auxT=(Triangle)i.next();
                            if(auxT.hitbox().contains(e.getPoint())){                                                        
                                System.err.println("Click triangle "+ j);
                                auxT.clicked=true;
                                clickOnTriangle=true;
                                clickedTriangle=j;
                                break;
                            }
                        j++; }
                        move=auxT;
                    }
                    
                       
                       if(move!=t && move.clicked){
                         
                        move.distX=-1*e.getX();
                        move.distY=-1*e.getY();
                    }
                       else{
                           move.clicked=false;
                           clicked=false;
                       }
                        
                    } 
                    

                @Override
                public void mouseMoved(MouseEvent e) {
                    
                }
            });
            this.addMouseListener(m=new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    
                  //clicked=true;
                }

                @Override
                public void mousePressed(MouseEvent e) {
                   
                       
                    
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    if(cont<3 && clickOnTriangle==false){
                        triangle.add(new Triangle(e.getX(), e.getY(), 40));
                    clickOnTriangle=true;
                    System.err.println(e.getX()+", "+ e.getY()+", "+ 40+", "+ refX+", "+refY);
                    cont++;
                    
                    }
                    System.err.println("Mouse Release");
                    move=t;
                    move.clicked=false;
                    clicked=false;
                    clickOnTriangle=false;
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    
                }
            });
            //this.setBounds(50, 50, 500, 500);
            //this.setlo
		//this.addKeyListener(new KeyInput(handler));
		//this.setBounds(10, 400, 50,50);
		//windown=new Main();
		//windown.content.add(this);
		
		 
	}
        
        public void addC(Conclusion c){
            this.triangle.add(new Triangle(50,50,100, c));   
            System.err.println(triangle.size());
        }

	public synchronized void start(){
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop(){
		try {
			thread.join();
			running = false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public void run(){
		
	    long lastTime = System.nanoTime();
	    final double amountOfTicks = 60.0;
	    double ns = 1000000000 / amountOfTicks; // cuantos nano segundos ocupa cada frame
	    double delta = 0; // tiempo transcurrido desde el ultimo frame
	    int frames = 0;
	    long timer = System.currentTimeMillis(); // tiempo del sistema
	
	    while(running){
                
	        long now = System.nanoTime();
	        delta += (now - lastTime) / ns; // calculo el delta
	        lastTime = now; 
                
                
	        if(delta >= 1){ // Master de los frames y act per seg
	            tick();
	            delta--;
                    if(running && this.isDisplayable())
 	        	render();
                    frames++;
	        }
	        

	        if(System.currentTimeMillis() - timer > 1000){
	            timer += 1000;
	            main.setTitle("FPS: " + frames);
	            frames = 0;
                    
	        }
                
	    }
	    stop();
	}
	
	public void tick(){
		//handler.tick();
	}
	
	public void render(){
            
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
                    
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.WIDTH, this.HEIGTH);
                g.setColor(Color.red);
		//handler.render(g);
                //new Triangle(40, 200, 100).draw(g);
                  g.setColor(Color.red);
              
                Iterator i =triangle.iterator();
                i.forEachRemaining(new Consumer() {
                    @Override
                    public void accept(Object t) {
                        Triangle test=(Triangle)t;
                        test.draw(g);
                    }
                });
                /*while(i.hasNext()){
                    g.setColor(Color.red);
                    //((Triangle)i.next()).act();
                    test=((Triangle)i.next());
                    test.draw(g);
                    test2=test.hitbox();
                     g.setColor(Color.blue);
                    //g.drawRect(test2.x, test2.y, test2.width, test2.height);
                    g.setColor(Color.WHITE);
                }*/
                
		g.dispose();
		bs.show();
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Game game = new Game();
		//game.start();
	}

}
