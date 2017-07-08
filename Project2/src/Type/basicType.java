package Type;

public class basicType {
    private int letterSize = 52; //Tama�o de la letra segun Ascii
    private final int LETTER_MIN_SIZE = 52; //Tama�o minimo en Ascii (52 == 4)
    protected String color="White";
    public String init="<font color=\""+color+"\" size=\""+(char)letterSize +"\">", end= "</font>";
    public String text;
    public Type type;
    protected int Start, End;



    public basicType(int letterSize, String text) {
        super();
        this.letterSize = letterSize;
        this.text = text;
        this.type= Type.Basic;
    }
    public basicType(String text) {
        super();
        this.text = text;
        this.type= Type.Basic;
    }

    public void setSize(int Size){
        if(Size<this.LETTER_MIN_SIZE)
            this.letterSize=this.LETTER_MIN_SIZE;
        else
            this.letterSize=Size;
    }	


    public int getStart() {
        return Start;
    }

    public int getEnd() {
        return End;
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

    public String getHtml(){
        init="<font color=\""+color+"\" size=\""+(char)letterSize +"\">"; end= "</font>";
        return init+text+end;
    }
}
