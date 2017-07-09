package Type;

import java.util.ArrayList;

// Work in progress
public class Conclusion extends basicType {
    private static int id;	// ID para conclusiones
    private final int ID;	// ID en general de una conclusion
    private String indice;	// Ejemplo: C1
    private ArrayList<Premisa> premisa;	//Arreglo de premisas que apoyan esta conclusion
    private ArrayList<Regla> regla;	//Arreglo de premisas que apoyan esta conclusion

    private boolean debug = false;	// Modo Debug

    // ID estatica para llevar control de la cantidad de premisas directas
    static{
        id=1;	
    }

    public Conclusion( String text, int start, int end) {
        super(4, text,  start,  end);
        this.color = "#58FA5B";
        this.type = Type.Premisa;
        this.premisa = new ArrayList<Premisa>();
        this.regla = new ArrayList<Regla>();
        ID=++Conclusion.id;
        this.indice= ""+ID;
    }
    //Conclusion
    public Conclusion(int letterSize, String text, int start, int end) {
        super(letterSize, text,  start,  end);
        this.color = "#58FA5B";
        this.type = Type.Premisa;
        this.premisa = new ArrayList<Premisa>();
        this.regla = new ArrayList<Regla>();
        ID=++Conclusion.id;
        this.indice= ""+ID;
    }


    //Agregar premisa
    public void add(Premisa p){
        this.premisa.add(p);
        if(debug){
            System.out.println("ID(" + p.getIndice() + "):" + p.getText() + "<- fue agregada como premisa que apoya a ->" + this.getText() + ":ID(" + this.indice + ")");
            System.out.println("((ID:" + indice + ")premisa)Size" + this.premisa.size());
        }
    }

    //Agregar regla
    public void add(Regla r){
        this.regla.add(r);
        if(debug){
            System.out.println("ID(" + r.getIndice() + "):" + r.getText() + "<- fue agregada como premisa que apoya a ->" + this.getText() + ":ID(" + this.indice + ")");
            System.out.println("((ID:" + indice + ")premisa)Size" + this.premisa.size());
        }
    }


}
