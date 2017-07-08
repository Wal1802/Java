/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CanvasItems;

import Type.Conclusion;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.text.AttributedCharacterIterator;

/**
 *
 * @author OACS
 */
public class Triangle {
    public int xp[]= new int[5], yp[] = new int[5], sizef, x, y;
    public Conclusion c;
    public double distX, distY;
    final int size, ID;
    public static float zoom;
    public boolean clicked=false;
    static int id;
    
    static{
        zoom=1;
        id=0;
    }
    String premisa, regla, conclusion;
    public Triangle( int x, int y,int size) {
        this.size = (int)(size * zoom);
        this.x = x;
        this.y = y;
        this.distX=0-x;
        this.distY=0-y;
        ID=id++;
        act();   
    }
    
    public Triangle( int x, int y,int size, Conclusion c) {
        this.size = (int)(size * zoom);
        this.c=c;
        this.x = x;
        this.y = y;
        this.distX=0-x;
        this.distY=0-y;
        ID=id++;
        act();   
    }
    
    
    
    public void act(){
         this.sizef = (int)(size * zoom);
         x=(int)(distX*zoom);
         y=(int)(distY*zoom);
         if(x<0)x*=-1;
         if(y<0)y*=-1;
         xp[0]=x+(sizef/4);
        xp[1]=x;
        xp[2]=(sizef/2)+x;
        xp[3]=sizef+x;
        xp[4]=x+(3*sizef/4);
        yp[0]=yp[4]=yp[1]=yp[3]=y+sizef;
        yp[2]=y;
    }


    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
         act();
        g.drawString(""+ID, x, y);
        g.setColor(Color.blue);        
        g.drawString(c.getText(), xp[0], yp[0]+15);
        g.setColor(Color.red);
        g.drawPolyline(xp, yp, 5);
		//g.drawPolygon(new Triangle(40+i, 200+i, 100-i*2).polygon());
        g.setColor(Color.white);
       // g.drawLine(x, y+size-2, x+size, y+size-2);g.drawLine(x, y+size-1, x+size, y+size-1);g.drawLine(x, y+size-3, x+size, y+size-3);
    }
    
    public Rectangle hitbox(){
        //System.err.println((size*zoom)+", " +(int)(size*zoom));
        return new Rectangle(x,y, (int)(size*zoom), (int)(size*zoom));
    }
    
    
}
