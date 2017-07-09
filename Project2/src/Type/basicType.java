package Type;

public class basicType {
    private int letterSize = 52; //Tama�o de la letra segun Ascii
    private final int LETTER_MIN_SIZE = 52; //Tama�o minimo en Ascii (52 == 4)
    protected String color="White";
    public String text;
    public Type type;
    public int start, end;



    public basicType(int letterSize, String text, int start, int end) {
        super();
        this.end=end;
        this.start=start;
        this.letterSize = letterSize;
        this.text = text;
        this.type= Type.Basic;
    }
    public basicType(String text, int start, int end) {
        super();
        this.text = text;
        this.type= Type.Basic;
        this.end=end;
        this.start=start;
    }

    public void setSize(int Size){
        if(Size<this.LETTER_MIN_SIZE)
            this.letterSize=this.LETTER_MIN_SIZE;
        else
            this.letterSize=Size;
    }	

    public Type getType() {
        return type;
    }

    public String getColor() {
        return color;
    }


    public void setColor(String color) {
        this.color = color;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
