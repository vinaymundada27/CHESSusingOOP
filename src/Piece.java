package chessgame;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Piece {
    String colour;
    int X;//x- coordinate (from 0-7)
    int Y;//y-coordinate (from 0-7)
    String notation="";
    Board board;
    String id="";
    ArrayList<Square>possibleMoves;
    HashMap<String,String> idToPath;
    public final String WHITE = "white";
    public final String BLACK = "black";

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
    
    public String getId() {
        return id;
    }
    
    public String getIdToPath(String id){
        return null;
    }
    
    public void setIdToPath(String id,String imageName){
        
    }

}

