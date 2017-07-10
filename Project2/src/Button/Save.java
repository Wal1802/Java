package Button;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import Front.Main;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Save extends JButton {

    private static final long serialVersionUID = -1162271566827801713L;
    private JFileChooser guardarArchivo;
    private Main main;
    
    public Save(Main main){
        super();
        this.addKeyListener(main);
        this.setToolTipText("Save");
        this.setIcon(new ImageIcon(Main.class.getResource("/Icon/Save.png")));
        this.setForeground(Color.DARK_GRAY);
        this.setBorderPainted(false);
        this.setBorder(null);
        this.main = main;
        this.setBackground(Color.DARK_GRAY);
        this.addMouseListener(new MouseAdapter() {
                public void mouseReleased(MouseEvent e){
                        save();

                }
        });

    }
    public void save(){
        guardarArchivo = new JFileChooser();
        guardarArchivo.setVisible(true);

        JFrame j = new JFrame();
        j.setSize(520, 520);
        j.add(guardarArchivo);
        j.setVisible(false);
        j.setAlwaysOnTop(true);

        guardarArchivo.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        guardarArchivo.setApproveButtonText("Save");

         FileNameExtensionFilter htmlFilter = new FileNameExtensionFilter("html files (*.html)", "html");
        guardarArchivo.addChoosableFileFilter(htmlFilter);                
        guardarArchivo.setFileFilter(htmlFilter);

         int seleccion = guardarArchivo.showOpenDialog( j );				

        if( seleccion == JFileChooser.APPROVE_OPTION )
        {
            java.io.File f;
            f= guardarArchivo.getSelectedFile();
            if(f== null){
                f =guardarArchivo.getCurrentDirectory();
            }  
            try{
                PrintWriter writer = new PrintWriter(f.getAbsolutePath()+".html", "UTF-8");
                writer.println(main.content._textEditor.getText());
                writer.close();
            } catch (IOException g) {
               // do something
            }
        }	   
    }
}
