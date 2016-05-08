package chessgame;

import java.util.ArrayList;

public class Bishop extends Piece {
    
    Bishop(String id,int x,int y){
        this.X = x;
        this.Y = y;
        this.notation = "B";
        this.id = id;
        possibleMoves = new ArrayList<>();
    }

    @Override
    public ArrayList<Square> move(Square[][] currentState) {
        
        possibleMoves.clear();
        //Moving diagonally left upwards
        int i = this.X-1;
        int j = this.Y-1;
        
        while(i>=0 && j>=0)
        {
            if(currentState[i][j].piece == null)
            {
                currentState[i][j].highlight = true;
                possibleMoves.add(currentState[i][j]);
            }

            else if(currentState[i][j].piece != null)
            {
                if(currentState[i][j].piece.colour.equals(this.colour))
                {
                    break;
                }

                else
                {
                    currentState[i][j].highlight = true;
                    possibleMoves.add(currentState[i][j]);
                    break;
                }
            }
            i--;
            j--;
        }
        
        //Moving diagonally left downwards
        i = this.X+1;
        j = this.Y-1;
        
        while(i<=7 && j>=0)
        {
            if(currentState[i][j].piece == null)
            {
                currentState[i][j].highlight = true;
                possibleMoves.add(currentState[i][j]);
            }

            else if(currentState[i][j].piece != null)
            {
                if(currentState[i][j].piece.colour.equals(this.colour))
                {
                    break;
                }

                else
                {
                    currentState[i][j].highlight = true;
                    possibleMoves.add(currentState[i][j]);
                    break;
                }
            }
            i++;
            j--;
        }
        
        //Moving diagonally right upwards
        i = this.X-1;
        j = this.Y+1;
        
        while(i>=0 && j<=7)
        {
            if(currentState[i][j].piece == null)
            {
                currentState[i][j].highlight = true;
                possibleMoves.add(currentState[i][j]);
            }

            else if(currentState[i][j].piece != null)
            {
                if(currentState[i][j].piece.colour.equals(this.colour))
                {
                    break;
                }

                else
                {
                    currentState[i][j].highlight = true;
                    possibleMoves.add(currentState[i][j]);
                    break;
                }
            }
            i--;
            j++;
        }
        
        //Moving diagonally right downwards
        i = this.X+1;
        j = this.Y+1;
        
        while(i<=7 && j<=7)
        {
            if(currentState[i][j].piece == null)
            {
                currentState[i][j].highlight = true;
                possibleMoves.add(currentState[i][j]);
            }

            else if(currentState[i][j].piece != null)
            {
                if(currentState[i][j].piece.colour.equals(this.colour))
                {
                    break;
                }

                else
                {
                    currentState[i][j].highlight = true;
                    possibleMoves.add(currentState[i][j]);
                    break;
                }
            }
            i++;
            j++;
        }
        return possibleMoves;
    }
}
