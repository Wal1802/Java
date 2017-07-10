package Button;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import Front.Main;
import Type.basicType;

public class Open extends JButton {
	
	
    private static final long serialVersionUID = -1162271566827801713L;
    public Main main;
    private String text;
    JFileChooser abrirArchivo;
    public Open(Main main){
        super();
        this.addKeyListener(main);
        this.setToolTipText("Open");
        this.setIcon(new ImageIcon(Main.class.getResource("/Icon/Open.png")));
        this.setForeground(Color.DARK_GRAY);
        this.setBorderPainted(false);
        this.setBorder(null);
        this.main=main;
        this.setBackground(Color.DARK_GRAY);
        this.addMouseListener(new MouseAdapter() {

            public void mouseReleased(MouseEvent e){
                abrirArchivo = new JFileChooser();
                abrirArchivo.setVisible(true);
                JFrame j = new JFrame();
                j.setSize(520, 520);
                j.add(abrirArchivo);
                j.setVisible(false);
                j.setAlwaysOnTop(true);
                abrirArchivo.setFileSelectionMode( JFileChooser.FILES_ONLY );
                int seleccion = abrirArchivo.showOpenDialog( j );
                
                //Con esto solamente podamos abrir archivos
                abrirArchivo.setFileSelectionMode( JFileChooser.FILES_ONLY );
                if( seleccion == JFileChooser.APPROVE_OPTION )
                {
                    java.io.File f = abrirArchivo.getSelectedFile();
                    try
                    {
                        String path = f.getAbsolutePath();
                        String contenido = getArchivo( path );
                        //Colocamos en el titulo de la aplicacion el 
                        //nombre del archivo
                        //.setTitle( nombre );
                        basicType b ;
                      if(path.contains(".doc")){ 
                          parseDoc(path); 
                          //b= new basicType(text);
                          main.content._textEditor.setText(text );
                                                }
                      if(path.contains(".docx")){ 
                          parseDocx(path);
                          //b= new basicType(text);
                          main.content._textEditor.setText( text );
                      }

                     if(path.contains(".txt")){ 
                         //b= new basicType(contenido); 
                         main.content._textEditor.setText(contenido);          

                     }
                        //En el editor de texto colocamos su contenido

                    }catch( Exception exp){}
                }
            }
        });
    }
	
/*public void parsePdf(String pdf, String txt) throws IOException 
{
   PdfReader reader = new PdfReader(pdf);
   PdfReaderContentParser parser = new PdfReaderContentParser(reader);
   PrintWriter out = new PrintWriter(new FileOutputStream(txt));
   TextExtractionStrategy strategy;
   for (int i = 1; i <= reader.getNumberOfPages(); i++) {
       strategy = parser.processContent(i, new SimpleTextExtractionStrategy());
       out.println(strategy.getResultantText());
   }
   File file = new File("/home/rishi/Downloads/sweetjs.pdf");
   String fileType = Files.probeContentType(file.toPath());
   out.flush();
   out.close();
   reader.close();
}*/
    
    public void parseDoc(String PREFACE)
    {
        POIFSFileSystem fs = null;
        try {
            fs = new POIFSFileSystem(new FileInputStream(PREFACE));
            // File file = new File("C:\\Users\\Oscar\\Desktop\\sda");
            //  String fileType = Files.probeContentType(file.toPath());
            HWPFDocument doc = new HWPFDocument(fs);
            @SuppressWarnings("resource")
            WordExtractor we = new WordExtractor(doc);
            text = we.getText();
            //File fil = new File("C:\\Users\\OACS\\Pictures\\Pictureshello.txt");
            //Writer output = new BufferedWriter(new FileWriter(fil));
            //output.write(text);
            // output.close();
         } catch (Exception exep) {
                  //System.out.println(exep);
         }
    }

    public void parseDocx(String PREFACE){

        File file = null;
        try {
            file = new File(PREFACE);
            //String fileType = Files.probeContentType(file.toPath());
            FileInputStream fis = new FileInputStream(file);
            XWPFDocument doc = new XWPFDocument(fis);
            @SuppressWarnings("resource")
            XWPFWordExtractor ex = new XWPFWordExtractor(doc);
            text = ex.getText();
            //File fil = new File("C:\\Users\\OACS\\Pictures\\Pictureshello.txt");
            //Writer output = new BufferedWriter(new FileWriter(fil));
            //output.write(text);
            //output.close();
        } catch (Exception exep) {
            //System.out.println(exep);
        }
    }

	
    public String getArchivo( String ruta ){
        FileReader fr = null;
        BufferedReader br = null;
        //Cadena de texto donde se guardara el contenido del archivo
        String contenido = "";
        try
        {
            //ruta puede ser de tipo String o tipo File
            fr = new FileReader( ruta );
            br = new BufferedReader( fr );

            String linea;
            //Obtenemos el contenido del archivo linea por linea
            while( ( linea = br.readLine() ) != null ){ 
                contenido += linea + "\n";
            }

        }catch( Exception e ){  }
        //finally se utiliza para que si todo ocurre correctamente o si ocurre 
        //algun error se cierre el archivo que anteriormente abrimos
        finally
        {
            try{
                br.close();
            }catch( Exception ex ){}
        }
        return contenido;
    }
	
}
