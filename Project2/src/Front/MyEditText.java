
package Front;


import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Caret;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
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
    
    public void buttonPremisa(){
        Style style = textPane.addStyle(main.content._textEditor.getSelectedText(), null);
            StyleConstants.setForeground(style, Color.green);
            
            try{
                
                System.out.println("i= "+ main.content._textEditor.getSelectedText().length());
                doc.insertString(main.content._textEditor.getSelectionStart(), main.content._textEditor.getSelectedText(), style);
                doc.remove(main.content._textEditor.getSelectionStart(),main.content._textEditor.getSelectedText().length());
            }catch(Exception e){
                
            }
    }
}
