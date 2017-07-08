package JMenu;

import Front.Main;
import JMenu.Items.AbrirArchivo;
import JMenu.Items.CerrarArchivo;
import JMenu.Items.Info;
import JMenu.Items.NuevoArchivo;
import JMenu.Items.Salir;
import JMenu.Items.saveFile;
import javax.swing.JMenu;

public class File extends JMenu {

    private static final long serialVersionUID = -1789243588854884525L;
    private NuevoArchivo NuevoArchivo;
    private AbrirArchivo AbrirArchivo;
    private CerrarArchivo CerrarArchivo;
    private Salir salir;
    private Info info;
    private Main main;

    public File(Main main){
        super("File");
        this.main = main;
        this.NuevoArchivo = new NuevoArchivo();
        this.AbrirArchivo = new AbrirArchivo();
        this.CerrarArchivo = new CerrarArchivo();
        this.salir = new Salir();
        this.info = new Info();

        this.add(NuevoArchivo);
        this.add(AbrirArchivo);
        this.add(new saveFile(main));
        this.add(CerrarArchivo);
        this.add(salir);
        this.add(info);
    }
}
