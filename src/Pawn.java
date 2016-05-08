package chessgame;

import java.util.ArrayList;
import java.util.HashMap;

public class Pawn extends Piece {
    
    int count;
    Pawn(String id,int x,int y,String colour){
        this.X = x;
        this.Y = y;
        this.notation = "";
        count = 0;
        this.id = id;
        possibleMoves = new ArrayList<>();
        this.idToPath = new HashMap<>();
        this.colour = colour;
        
        if(colour.equals(WHITE)){
            setIdToPath(id,"2.png");
        }
        else
            setIdToPath(id,"1.png");
    }

    @Override
    public ArrayList<Square> move(Square[][] currentState) {
            
        possibleMoves.clear();
        //WHITE PAWNS
        if(this.getColour().equals(WHITE))
        {
            //PAWNS MOVING FIRST TIME
            if(this.X == 6)
            {
                if(currentState[this.X-1][this.Y].getPiece() == null && currentState[this.X-2][this.Y].getPiece() == null)
                {
                    currentState[this.X-2][this.Y].highlight = true;
                    possibleMoves.add(currentState[this.X-2][this.Y]);
                }
            }

            //Move straight upwards
            if(this.X-1>=0 && currentState[this.X-1][this.Y].getPiece() == null)
            {
                currentState[this.X-1][this.Y].highlight = true;
                possibleMoves.add(currentState[this.X-1][this.Y]);
            }

            //Move diagonally left upwards
            if(this.X-1>=0 && this.Y-1>=0 && currentState[this.X-1][this.Y-1].getPiece()!=null)
            {
                if(!currentState[this.X-1][this.Y-1].getPiece().getColour().equals(this.getColour()))
                {
                    currentState[this.X-1][this.Y-1].highlight =  true;
                    possibleMoves.add(currentState[this.X-1][this.Y-1]);
                }
            }

             //Move diagonally right upwards
            if(this.X-1>=0 && this.Y+1<=7 && currentState[this.X-1][this.Y+1].getPiece()!=null)
            {
                if(!currentState[this.X-1][this.Y+1].getPiece().getColour().equals(this.getColour()))
                {
                    currentState[this.X-1][this.Y+1].highlight =  true;
                    possibleMoves.add(currentState[this.X-1][this.Y+1]);
                }
            }
        }
        
         /******************************************************************/
        
        //BLACK PAWNS
        else
        {
            //Moving first time
            if(this.X == 1)
            {
                if(currentState[this.X+1][this.Y].getPiece() == null && currentState[this.X+2][this.Y].getPiece() == null)
                {
                    currentState[this.X+2][this.Y].highlight = true;
                    possibleMoves.add(currentState[this.X+2][this.Y]);
                }
            }
            
            //Move straight downwards
            if(this.X+1<=7 && currentState[this.X+1][this.Y].getPiece() == null)
            {
                currentState[this.X+1][this.Y].highlight = true;
                possibleMoves.add(currentState[this.X+1][this.Y]);
            }

            //Move diagonally left downwards
            if(this.X+1<=7 && this.Y-1>=0 && currentState[this.X+1][this.Y-1].getPiece()!=null)
            {
                if(!currentState[this.X+1][this.Y-1].getPiece().getColour().equals(this.getColour()))
                {
                    currentState[this.X+1][this.Y-1].highlight =  true;
                    possibleMoves.add(currentState[this.X+1][this.Y-1]);
                }
            }

             //Move diagonally right downwards
            if(this.X+1<=7 && this.Y+1<=7 && currentState[this.X+1][this.Y+1].getPiece()!=null)
            {
                if(!currentState[this.X+1][this.Y+1].getPiece().getColour().equals(this.getColour()))
                {
                    currentState[this.X+1][this.Y+1].highlight =  true;
                    possibleMoves.add(currentState[this.X+1][this.Y+1]);
                }
            }
        }
        return possibleMoves;
    }
    
    @Override
    public String getIdToPath(String id) {
        
        return this.idToPath.get(id);
    }

    @Override
    public void setIdToPath(String id,String imageName) {
        this.idToPath.put(id,imageName);
    }
}
