package chessgame;

public class Square {
    
    public String WHITE = "white";
    public String BLACK = "black";
    int X;
    int Y;
    String colour;
    String notation="";
    Piece piece = null;
    boolean highlight;
    
    //Default Constructor
    Square(){
        
    }

    Square(int x,int y,boolean squareColour){
        this.X = x;
        this.Y = y;
        this.highlight = false;
        
        
        //SQUARE-COLOUR
        if(squareColour == true)
            this.colour = WHITE;
        
        else
            this.colour = BLACK;
        
        //SQUARE-NOTATION
        this.notation = Character.toString((char)(97+x));
        this.notation += (char)(y+48+1);//since 0 based indexing of board
        System.out.println("square notation = "+notation);
    }

    public int getX() {
        return this.X;
    }

    public int getY() {
        return this.Y;
    }

    public String getColour() {
        return this.colour;
    }
    
    public void removePiece(){
        Piece p = this.piece;
        setPiece(p);
        this.piece = null;
    }
    
    public void setPiece(Piece p){
        this.piece = p;
    }

    public Piece getPiece() {
        return piece;
    }
    
    
}
