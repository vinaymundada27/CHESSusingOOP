package chessgame;

import java.util.ArrayList;

public class Rook extends Piece {
    
    //Constructor
    Rook(String id,int x,int y){
        this.X = x;
        this.Y = y;
        this.notation = "R";
        this.id = id;
        possibleMoves = new ArrayList<>();
    }

    @Override
    public ArrayList<Square> move(Square currentState[][]) {
        
        possibleMoves.clear();
        int x=  this.X;
        
        //HORIZONTAL LEFT NAVIGATION OF ROOK
        for(int j=this.Y-1;j>=0;j--)
        {
            if(currentState[x][j].piece == null)
            {
                currentState[x][j].highlight = true;
                possibleMoves.add(currentState[x][j]);
            }

            else if(currentState[x][j].piece != null)
            {
                if(currentState[x][j].piece.colour.equals(this.colour))
                {
                    break;
                }

                else
                {
                    currentState[x][j].highlight = true;
                    possibleMoves.add(currentState[x][j]);
                    break;
                }
            }

        }
        
        //HORIZONTAL RIGHT NAVIGATION OF ROOK
        for(int j=this.Y+1;j<=7;j++)
        {
            if(currentState[x][j].piece == null)
            {
                currentState[x][j].highlight = true;
                possibleMoves.add(currentState[x][j]);
            }

            else if(currentState[x][j].piece != null)
            {
                if(currentState[x][j].piece.colour.equals(this.colour))
                {
                    break;
                }

                else
                {
                    currentState[x][j].highlight = true;
                    possibleMoves.add(currentState[x][j]);
                    break;
                }
            }

        }
        
        int y = this.Y;
        
        //VERTICAL UP NAVIGATION OF ROOK
        for(int i=this.X-1;i>=0;i--)
        {
            if(currentState[i][y].piece == null)
            {
                currentState[i][y].highlight = true;
                possibleMoves.add(currentState[i][y]);
            }

            else if(currentState[i][y].piece != null)
            {
                if(currentState[i][y].piece.colour.equals(this.colour))
                {
                    break;
                }

                else
                {
                    currentState[i][y].highlight = true;
                    possibleMoves.add(currentState[i][y]);
                    break;
                }
            }
        }
        
        //VERTICAL DOWN NAVIGATION OF ROOK
        for(int i=this.X+1;i<=7;i++)
        {
            if(currentState[i][y].piece == null)
            {
                currentState[i][y].highlight = true;
                possibleMoves.add(currentState[i][y]);
            }

            else
            {
                if(currentState[i][y].piece.colour.equals(this.colour))
                {
                    break;
                }

                else
                {
                    currentState[i][y].highlight = true;
                    possibleMoves.add(currentState[i][y]);
                    break;
                }
            }
        }
        
        return possibleMoves;
    }
    
}