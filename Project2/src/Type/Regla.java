package Type;

// java.util.ArrayList;

public class Regla extends basicType {
    private static int id;	// ID para regla
    private final int ID;	// ID en general de una regla
    private String indice;	// Ejemplo: R1
    //private int subIndice;	// Cantidad de premisas que lo apoyan (Se puede eliminar si usamos ArrayList.size() )
    //private Regla father;	// Regla a la que apoya esta regla
    //private ArrayList<Regla> premisaApoyo;	//Arreglo de reglas que apoyan esta regla

    //private boolean debug = false;	// Modo Debug

    // ID estatica para llevar control de la cantidad de premisas directas
    static{
            id=0;	
    }
    //Premisa directa
    public Regla( String text) {
        super(4, text);
        this.color = "#F7FE2E";
        this.type = Type.Regla;
        //this.premisaApoyo = new ArrayList<Regla>();
        ID=++id;
        this.indice= ""+ID;
        //this.subIndice= 0;
        //father = null;
    }
    //Premisa directa
    public Regla(int letterSize, String text) {
        super(letterSize, text);
        this.color = "#F7FE2E";
        this.type = Type.Regla;
        //this.premisaApoyo = new ArrayList<Regla>();
        ID=++id;
        this.indice= ""+ID;
        //this.subIndice= 0;
        //father = null;
    }

    public String getIndice() {
            return indice;
    }

    /*
    //Regla directa que apoya a otra regla
    public Regla(int letterSize, String text, Regla father) {
            super(letterSize, text);
            this.color = "#58FA5B";
            this.type = Type.Premisa;
            //this.premisaApoyo = new ArrayList<Regla>();
            this.ID = ++this.father.subIndice;
            this.indice = father.ID + "."+ this.ID ;
            this.subIndice = 0;
            this.father = father;

    }*/


/*
    //Agregar premisa de Apoyo directo
    public void addPremisaAD(Regla pad){
            this.premisaApoyo.add(pad);
            if(debug){
                    System.out.println("ID(" + pad.indice + "):" + pad.getText() + "<- fue agregada como premisa que apoya directamente a ->" + this.getText() + ":ID(" + pad.indice + ")");
                    System.out.println("((ID:" + indice + ")premisaApoyo)Size" + this.premisaApoyo.size());
            }
    }
    */
	
}
