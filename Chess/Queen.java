package chessgame;

import java.util.ArrayList;

public class Queen extends Piece {
    
    Queen(String id,int x,int y){
        this.X = x;
        this.Y = y;
        this.notation = "Q";
        this.id = id;
        possibleMoves = new ArrayList<>();
    }

    @Override
    public ArrayList<Square> move(Square[][] currentState) {
        
        possibleMoves.clear();
        boolean flag =false;
        
        //ROOK's MOVES
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
                    flag = true;
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
                    flag = true;
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
        
        flag = false;
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
                    flag = true;
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
                    flag = true;
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
        
        /******************************************************************/
        
        
        //BISHOP's MOVES
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
