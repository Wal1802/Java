package Type;

import java.util.ArrayList;

public class Premisa extends basicType {
	private static int id;	// ID para premisas directas
	private final int ID;	// ID en general de una premisa
	private String indice;	// Ejemplo: P1.1.2
	private int subIndice;	// Cantidad de premisas que lo apoyan (Se puede eliminar si usamos ArrayList.size() )
	private Premisa father;	// Premisa a la que apoya esta premisa
	private ArrayList<Premisa> premisaApoyo;	//Arreglo de premisas que apoyan esta premisa
	
	private boolean debug = false;	// Modo Debug
	
	// ID estatica para llevar control de la cantidad de premisas directas
	static{
		id=0;	
	}
	
	//Premisa directa
	public Premisa(int letterSize, String text) {
		super(letterSize, text);
		this.color = "#58FA5B";
		this.type = Type.Premisa;
		this.premisaApoyo = new ArrayList<Premisa>();
		ID=++Premisa.id;
		this.indice= ""+ID;
		this.subIndice= 0;
		father = null;
	}
	public Premisa( String text) {
		super( text);
		this.color = "#58FA5B";
		this.type = Type.Premisa;
		this.premisaApoyo = new ArrayList<Premisa>();
		ID=++Premisa.id;
		this.indice= ""+ID;
		this.subIndice= 0;
		father = null;
	}
	
	
	//Premisa directa que apoya a otra premisa
	public Premisa(int letterSize, String text, Premisa father) {
		super(letterSize, text);
		this.color = "#58FA5B";
		this.type = Type.Premisa;
		this.premisaApoyo = new ArrayList<Premisa>();
		this.ID = ++this.father.subIndice;
		this.indice = father.ID + "."+ this.ID ;
		this.subIndice = 0;
		this.father = father;
		
	}



	//Agregar premisa de Apoyo directo
	public void addPremisaAD(Premisa pad){
		this.premisaApoyo.add(pad);
		if(debug){
			System.out.println("ID(" + pad.indice + "):" + pad.getText() + "<- fue agregada como premisa que apoya directamente a ->" + this.getText() + ":ID(" + pad.indice + ")");
			System.out.println("((ID:" + indice + ")premisaApoyo)Size" + this.premisaApoyo.size());
		}
	}


	public String getIndice() {
		return indice;
	}
	
}
