
package Front;


import Type.Conclusion;
import Type.Premisa;
import Type.Regla;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;



public class MyEditText {
    JTextPane textPane;
    StyledDocument doc;
    Main main;
    
    
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
    
    public void buttonPremisa(){
        Premisa p;
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
    public void buttonRegla(){
        Regla r;
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
