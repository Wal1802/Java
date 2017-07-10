/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CanvasItems;

import Type.Conclusion;
import Type.Premisa;
import Type.Regla;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;


/**
 *
 * @author OACS
 */
public class TriangleParalel extends Triangle{
     
    public ArrayList<Triangle> triangle;
    public ArrayList<Rectangle> rectangle; 

    //CONSTRUCTORES
    public TriangleParalel(int x, int y, int size,Triangle t[]) {
        super(x,y,size,TypeTriangle.Paralelo);
        triangle= new ArrayList<Triangle>();
        rectangle= new ArrayList<Rectangle>(); 
        for(int i = 0; i< t.length ; i++){
            triangle.add(t[i]); 
            rectangle.add(new Rectangle(20,20));
        }    
        super.xp= new int[6];
        super.yp= new int[6];
        act();   
    }
    
    
    //ACT LOS DATOS
    @Override
    public void act(){
        this.sizef = (int)(SIZE * zoom);
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
        yp[5]=yp[0];
        xp[5]=xp[0];
        if(triangle.size()>2){
            
        }
        else
        {
            
        }
        
    }
    
    //DIBUJA
    @Override
    public void draw(Graphics g) {
        if(graph){
            g.setColor(Color.BLACK);
             act();
            //g.drawString(""+ID, x, y);
            g.setColor(Color.blue);
            if(premisa)
                g.drawString("P "+tag, xp[0]+15, yp[0]+15);
            if(conclusion)
                g.drawString("C "+tag, xp[2]-10, yp[2]-15);
            if(regla)
                g.drawString("R "+tag, xp[1]-10, yp[1]-45);
            g.setColor(Color.red);
            g.drawPolyline(xp, yp, 6);
            if(triangle.size()>2){
                g.drawRect(xp[0]-1, yp[0]-5, (int)(30*zoom), (int)(10*zoom));
                g.setColor(Color.white);
                g.fillRect(xp[0], yp[0]-4, (int)(29*zoom), (int)(9*zoom));
            }
            else{
                g.drawRect(xp[0]-1, yp[0]-5, (int)(10*zoom), (int)(10*zoom));                
                g.drawRect(xp[0]+18, yp[0]-5, (int)(10*zoom), (int)(10*zoom));
                g.setColor(Color.white);
                g.fillRect(xp[0], yp[0]-4, (int)(9*zoom), (int)(9*zoom));
                g.fillRect(xp[0]+19, yp[0]-4, (int)(9*zoom), (int)(9*zoom));
            }
            //g.drawPolygon(new Triangle(40+i, 200+i, 100-i*2).polygon());
            g.setColor(Color.white);
            // g.drawLine(x, y+size-2, x+size, y+size-2);g.drawLine(x, y+size-1, x+size, y+size-1);g.drawLine(x, y+size-3, x+size, y+size-3);      
        }
    }
    
   
    
}
