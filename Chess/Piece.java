package chessgame;

import java.util.ArrayList;

public abstract class Piece {
    String colour;
    int X;//x- coordinate (from 0-7)
    int Y;//y-coordinate (from 0-7)
    String notation="";
    Board board;
    String id="";
    ArrayList<Square>possibleMoves;

    Piece(){
        
    }
    
    public int getX() {
        return X;
    }

    public void setX(int X) {
        this.X = X;
    }

    public int getY() {
        return Y;
    }

    public void setY(int Y) {
        this.Y = Y;
    }
    
    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
    
    public ArrayList<Square> move(Square booardState[][]){
        
        return null;
        //whenever you move a piece make sure you change the hasPiece attribute of the square
    }
    
    // will mark all possible squares
    public void setPath(String currPos){
        
        
    }
    
    public void getPath()
    {
        
    }

    public String getId() {
        return id;
    }
    

}

