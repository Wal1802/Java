package Front;


import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;


public class Game extends Canvas implements Runnable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2156860797447575242L;
	private final int WIDTH = 640, HEIGTH = WIDTH / 12 * 9;
	private Thread thread;
	private boolean running = false;
	private Main windown;
        
        
	
	
	public Game(Main main){
            this.windown=main;
            this.setVisible(true);
            this.setBounds(0, 0, 500, 500);
            

            
            //this.setBounds(50, 50, 500, 500);
            //this.setlo
		//this.addKeyListener(new KeyInput(handler));
		//this.setBounds(10, 400, 50,50);
		//windown=new Main();
		//windown.content.add(this);
		
		 
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
	    double ns = 1000000000 / amountOfTicks;
	    double delta = 0;
	    int frames = 0;
	    long timer = System.currentTimeMillis();
	
	    while(running){
	        long now = System.nanoTime();
	        delta += (now - lastTime) / ns;
	        lastTime = now;
	        if(delta >= 1){
	            tick();
	            delta--;
	        }
	        if(running && this.isDisplayable())
 	        	render();
	        frames++;
                if(frames >60)
                    
	
	        if(System.currentTimeMillis() - timer > 1000){
	            timer += 1000;
	            windown.setTitle("FPS: " + frames);
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
                g.setColor(Color.RED);
		g.drawOval(0, 0, 50, 50);
		//handler.render(g);
		
		g.dispose();
		bs.show();
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Game game = new Game();
		//game.start();
	}

}
