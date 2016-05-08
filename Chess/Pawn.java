package chessgame;

import java.util.ArrayList;

public class Pawn extends Piece {
    
    int count;
    Pawn(String id,int x,int y){
        this.X = x;
        this.Y = y;
        this.notation = "";
        count = 0;
        this.id = id;
        possibleMoves = new ArrayList<>();
    }

    @Override
    public ArrayList<Square> move(Square[][] currentState) {
            
        possibleMoves.clear();
        //WHITE PAWNS
        if(this.getColour().equals("white"))
        {
            //PAWNS MOVING FIRST TIME
            if(this.X == 6)
            {
                if(currentState[this.X-2][this.Y] == null)
                {
                    currentState[this.X-2][this.Y].highlight = true;
                    possibleMoves.add(currentState[this.X-2][this.Y]);
                }
            }

            //Move straight upwards
            if(currentState[this.X-1][this.Y].piece == null)
            {
                currentState[this.X-1][this.Y].highlight = true;
                possibleMoves.add(currentState[this.X-1][this.Y]);
            }

            //Move diagonally left upwards
            if(currentState[this.X-1][this.Y-1].piece!=null)
            {
                if(!currentState[this.X-1][this.Y-1].colour.equals(this.colour))
                {
                    currentState[this.X-1][this.Y-1].highlight =  true;
                    possibleMoves.add(currentState[this.X-1][this.Y-1]);
                }
            }

             //Move diagonally right upwards
            if(currentState[this.X-1][this.Y+1].piece!=null)
            {
                if(!currentState[this.X-1][this.Y+1].colour.equals(this.colour))
                {
                    currentState[this.X-1][this.Y+1].highlight =  true;
                    possibleMoves.add(currentState[this.X-1][this.Y+1]);
                }
            }

            //Move straight upwards
            if(currentState[this.X-1][this.Y].piece == null)
            {
                currentState[this.X-1][this.Y].highlight = true;
                possibleMoves.add(currentState[this.X-1][this.Y]);
            }

            //Move diagonally left upwards
            if(currentState[this.X-1][this.Y-1].piece!=null)
            {
                if(!currentState[this.X-1][this.Y-1].colour.equals(this.colour))
                {
                    currentState[this.X-1][this.Y-1].highlight =  true;
                    possibleMoves.add(currentState[this.X-1][this.Y-1]);
                }
            }

             //Move diagonally right upwards
            if(currentState[this.X-1][this.Y+1].piece!=null)
            {
                if(!currentState[this.X-1][this.Y+1].colour.equals(this.colour))
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
                if(currentState[this.X+2][this.Y] == null)
                {
                    currentState[this.X+2][this.Y].highlight = true;
                    possibleMoves.add(currentState[this.X+2][this.Y]);
                }
            }
            
            //Move straight downwards
            if(currentState[this.X+1][this.Y].piece == null)
            {
                currentState[this.X+1][this.Y].highlight = true;
                possibleMoves.add(currentState[this.X+1][this.Y]);
            }

            //Move diagonally left downwards
            if(currentState[this.X+1][this.Y-1].piece!=null)
            {
                if(!currentState[this.X+1][this.Y-1].colour.equals(this.colour))
                {
                    currentState[this.X+1][this.Y-1].highlight =  true;
                    possibleMoves.add(currentState[this.X+1][this.Y-1]);
                }
            }

             //Move diagonally right downwards
            if(currentState[this.X+1][this.Y+1].piece!=null)
            {
                if(!currentState[this.X+1][this.Y+1].colour.equals(this.colour))
                {
                    currentState[this.X+1][this.Y+1].highlight =  true;
                    possibleMoves.add(currentState[this.X+1][this.Y+1]);
                }
            }
        }
        return possibleMoves;
    }
}
