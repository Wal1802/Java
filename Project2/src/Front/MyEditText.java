
package Front;


import CanvasItems.Triangle;
import Type.Conclusion;
import Type.Premisa;
import Type.Regla;
import java.awt.Color;
import java.util.function.Consumer;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;



public class MyEditText {
    JTextPane textPane;
    StyledDocument doc;
    Main main;
    Triangle aux;
    
    public MyEditText(Main main){
        this.main=main;
        textPane = main.content._textEditor;
        doc = textPane.getStyledDocument();
          
    }
    public void buttonCreate(){
        Style style = textPane.addStyle(main.content._textEditor.getText(), null);
        StyleConstants.setForeground(style, Color.white);

        try{
            doc.insertString(0, " ", style);
            main.content._textEditor.setText("");
            main.content._textEditor.moveCaretPosition(1);
        }catch(Exception e){
        }
    }
    
    boolean flag= true;
    boolean equals =false;
    public boolean checkP(int start, int end){
        flag=true;
      
        main.content.graph.triangle.forEach((Object t) -> {
            Triangle tmp = (Triangle)t;    
            if(tmp.premisa){
                Premisa premisa= tmp.p;
                
                if(premisa.start<=start && premisa.end>=start || premisa.start<=end && premisa.end>=end){
                    flag=false;
                    return;
                }  
            }
        });
        return flag;
    }
    public boolean checkR(int start, int end){
        flag=true;
        main.content.graph.triangle.forEach((Object t) -> {
            Triangle tmp = (Triangle)t;
            if(tmp.regla){
                Regla regla= tmp.r;
                if(regla.start<=start && regla.end>=start || regla.start<=end && regla.end>=end){
                    flag=false;
                    return;
                }    
            }               
        });
        return flag;
    }
    public boolean checkC(int start, int end){
        flag=true;
        equals=false;
        main.content.graph.triangle.forEach((Object t) -> {
            Triangle tmp = (Triangle)t;
            
            if(tmp.conclusion){
                if(tmp.c.start==start && tmp.c.end== end){
                    flag=false;
                    aux=tmp;
                    equals=true;
                    return;
                }
                if(tmp.c.start<start && tmp.c.end>start || tmp.c.start<end && tmp.c.end>end){
                    flag=false;
                    return;
                }              
            }
        });
        return flag;
    }
    public void buttonPremisa(){
        Premisa p;
        int start= main.content._textEditor.getSelectionStart(), end=main.content._textEditor.getSelectionEnd();
        System.out.println("TODO - POP UP");
        if(!checkP(start, end)){
            main.setAlwaysOnTop(false);
            String[] options = {"Aceptar", "Sustituir", "Cancelar"};
            int i = JOptionPane.showOptionDialog(null, "Es necesario que seleccione una opcion", "Titulo", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (i == 0){
                System.out.println ("Escogiste Aceptar");
            }
            else{
                if(i == 1){
                    System.out.println ("Escogiste Sustituir");
                }
        }
        }else
        if(!checkR(start, end)){
            System.out.println("TODO - POP UP");
            main.setAlwaysOnTop(false);
            String[] options = {"Borrar", "Cancelar"};
            int i = JOptionPane.showOptionDialog(null, "Has seleccionado una regla deseas borrar la regla?", "", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (i == 0){
                System.out.println ("Borrar regla");
            }
            
        }else
        if(!checkC(start, end)){
            if(equals){
                String[] options = {"Aceptar", "Cancelar"};
                int i = JOptionPane.showOptionDialog(null, "Has seleccionado una conclusion existente deseas hacer un argumento subordinado?", "Titulo", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                if (i == 0){
                    System.out.println ("Escogiste Aceptar"); Style style = textPane.addStyle(main.content._textEditor.getSelectedText(), null);
                StyleConstants.setForeground(style, Color.green);
                main.content._textEditor.add(p=new Premisa(main.content._textEditor.getSelectedText(), main.content._textEditor.getSelectionStart(), main.content._textEditor.getSelectionEnd()));
                main.content.graph.addP(p, aux);
               
                }
                else{

               
                }
            }
            else{
                System.err.println("TODO - POP UP");
            }
        }else{
            Style style = textPane.addStyle(main.content._textEditor.getSelectedText(), null);
            StyleConstants.setForeground(style, Color.green);
            main.content._textEditor.add(p=new Premisa(main.content._textEditor.getSelectedText(), main.content._textEditor.getSelectionStart(), main.content._textEditor.getSelectionEnd()));
            main.content.graph.addP(p);
            try{
                doc.insertString(main.content._textEditor.getSelectionStart(), main.content._textEditor.getSelectedText(), style);
                doc.remove(main.content._textEditor.getSelectionStart(),main.content._textEditor.getSelectedText().length());
            }catch(Exception e){

            }
        }
    }
    public void buttonRegla(){
        Regla r;
        int start= main.content._textEditor.getSelectionStart(), end=main.content._textEditor.getSelectionEnd();
        if(!checkR(start, end)){
            System.out.println("No se puede chamita");
        }
        Style style = textPane.addStyle(main.content._textEditor.getSelectedText(), null);
        StyleConstants.setForeground(style, Color.yellow);
        main.content._textEditor.add(r=new Regla(main.content._textEditor.getSelectedText(), main.content._textEditor.getSelectionStart(), main.content._textEditor.getSelectionEnd()));
        main.content.graph.addR(r);
        try{
            System.out.println("i= "+ main.content._textEditor.getSelectedText().length());
            doc.insertString(main.content._textEditor.getSelectionStart(), main.content._textEditor.getSelectedText(), style);
            doc.remove(main.content._textEditor.getSelectionStart(),main.content._textEditor.getSelectedText().length());
        }catch(Exception e){

        }finally{
            style = textPane.addStyle(main.content._textEditor.getText(), null);
            StyleConstants.setForeground(style, Color.white);
        }
    }
    public void buttonConclusion(){
        Conclusion c;
        int start= main.content._textEditor.getSelectionStart(), end=main.content._textEditor.getSelectionEnd();
        if(!checkC(start, end)){
            System.out.println("No se puede chamita");
        }
        Style style = textPane.addStyle(main.content._textEditor.getSelectedText(), null);
        StyleConstants.setForeground(style, Color.cyan);
        main.content._textEditor.add(c=new Conclusion(main.content._textEditor.getSelectedText(), main.content._textEditor.getSelectionStart(), main.content._textEditor.getSelectionEnd()));
        main.content.graph.addC(c);
        try{
            System.out.println("i= "+ main.content._textEditor.getSelectedText().length());
            doc.insertString(main.content._textEditor.getSelectionStart(), main.content._textEditor.getSelectedText(), style);
            doc.remove(main.content._textEditor.getSelectionStart(),main.content._textEditor.getSelectedText().length());
        }catch(Exception e){

        }finally {
            style = textPane.addStyle(main.content._textEditor.getText(), null);
            StyleConstants.setForeground(style, Color.white);
        }
    }
}
