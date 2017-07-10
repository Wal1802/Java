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


/**
 *
 * @author OACS
 */
public class Triangle {
    
    final int SIZE, ID;
    public int xp[]= new int[5], yp[] = new int[5], sizef, x, y;
    public double distX, distY;
    public boolean clicked=false,regla,conclusion ,premisa=conclusion=regla=false, graph= true;
    public static int R[]= new int[4],G[]= new int[4],B[]= new int[4];
    public Triangle father;
    public String tag;
    public TypeTriangle type;
    
    //ARGUMENTOS
    public Conclusion c;
    public Premisa p; 
    public Regla r;
  
    //STATIC
    public static float zoom;
    static int id;
    /*
        RGB[0] ----> Triangulo
        RGB[1] ----> Texto Premisa
        RGB[2] ----> Texto Regla
        RGB[3] ----> Texto Conclusion
    */
    static{
        zoom=1;
        id=0;
        R[0]=252;
        G[0]=0;
        B[0]=0;
        
        R[1]=0;
        G[1]=252;
        B[1]=0;
        
        R[2]=250;
        G[2]=210;
        B[2]=1;
        
        R[3]=0;
        G[3]=0;
        B[3]=252;
    }   

    //CONSTRUCTORES
    public Triangle( int x, int y,int size, TypeTriangle type) {
        this.SIZE = (int)(size * zoom);
        this.x = x;
        this.y = y;
        this.distX=0-x;
        this.distY=0-y;
        ID=id++;
        this.type=type;
        tag= ""+ID;
        
        if(type!= TypeTriangle.Subordinado)    
            act();   
    }
    public Triangle(Triangle father) {
        this.SIZE = (int)(father.SIZE);
        ID=id++;
        this.type= TypeTriangle.Paralelo;        
        this.father= father;
        this.father.type= TypeTriangle.Paralelo;        
        tag= ""+ID;
        
        if(type!= TypeTriangle.Subordinado)    
            act();   
    }
    
    
    //SETTERS
    public void add(Premisa p){
        this.p=p;
        premisa=true;
    }
    
    public void add(Conclusion c){
        this.c=c;
        this.conclusion=true;
    }
    
    public void add(Regla r){
        this.r=r;
        this.regla=true;
    }
    
    //ACT LOS DATOS
    public void act(){
        this.sizef = (int)(SIZE * zoom);
        if(type== TypeTriangle.Basic || (type== TypeTriangle.Paralelo && father==null)){
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
        else{
            father.act();
            for(int i = 0 ; i< 5; i++){
                xp[i]=father.xp[i]+(father.sizef/64);
                yp[i]=father.yp[i]+(father.sizef/*/2*/);
            }
        }         
    }

    public Rectangle hitbox(){
        //System.err.println((size*zoom)+", " +(int)(size*zoom));
        return new Rectangle(x,y, (int)(SIZE*zoom), (int)(SIZE*zoom));
    }
    
    //DIBUJA
    public void draw(Graphics g) {
        if(graph){
            g.setColor(Color.BLACK);
             act();
            //g.drawString(""+ID, x, y);
            
            if(premisa){
                g.setColor(new Color(R[1], G[1],B[1]));
                g.drawString("P "+tag, xp[0]+15, yp[0]+15);
            }
            if(conclusion){
                g.setColor(new Color(R[3], G[3],B[3]));
                 g.drawString("C "+tag, xp[2]-10, yp[2]-15);
            }
            if(regla){
                g.setColor(new Color(R[2], G[2],B[2]));
                 g.drawString("R "+tag, xp[1]-10, yp[1]-45);
            }
            g.setColor(new Color(R[0], G[0],B[0]));
            g.drawPolyline(xp, yp, 5);
            //g.drawPolygon(new Triangle(40+i, 200+i, 100-i*2).polygon());
            g.setColor(Color.white);
            // g.drawLine(x, y+size-2, x+size, y+size-2);g.drawLine(x, y+size-1, x+size, y+size-1);g.drawLine(x, y+size-3, x+size, y+size-3);      
        }
    }
    
   
    
}
