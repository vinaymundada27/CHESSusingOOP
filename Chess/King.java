package chessgame;

import java.util.ArrayList;

public class King extends Piece {
    
    boolean moved;
    
    King(String id,int x,int y){
        this.X = x;
        this.Y = y;
        this.notation = "K";
        this.moved = false;//needed to check if king can do castling
        this.id = id;
        possibleMoves = new ArrayList<>();
    } 
    
    //this finction will be used whle castling
    private boolean isMoved(King k){
        if(k.moved)
            return true;
        
        return false;
    }
    
    private boolean canCastle(Square[][] currentState){
        
        if(isMoved(this))
        {
            return false;
        }
        
        else
        {
            //WHITE KING
            if(this.getColour().equals("white"))
            {
                //short castling
                if(currentState[7][5].piece==null && currentState[7][6]==null && currentState[7][7] !=null)
                {
                    if(currentState[7][7].piece.getId().equals("WR2"))
                    {
                        return true;
                    }
                }
                
                //long castling
                if(currentState[7][1].piece==null && currentState[7][2] == null &&
                        currentState[7][3] == null && currentState[7][0] != null)
                {
                    if(currentState[7][7].piece.getId().equals("WR1"))
                    {
                        return true;
                    }
                }
                
                return false;
            }
            
            //BLACK KING
            else
            {
                //short castling
                if(currentState[0][5].piece==null && currentState[0][6]==null && currentState[0][7] !=null)
                {
                    if(currentState[0][7].piece.getId().equals("BR2"))
                    {
                        return true;
                    }
                }
                
                //long castling
                if(currentState[0][1].piece==null && currentState[0][2] == null &&
                        currentState[0][3] == null && currentState[0][0] != null)
                {
                    if(currentState[0][0].piece.getId().equals("BR1"))
                    {
                        return true;
                    }
                }
                
                return false;
            }
            
        }
        
    }

    public ArrayList<Square> move(Square[][] currentState) {
        
        possibleMoves.clear();
        int x = this.X;
        int y = this.Y;
        int Xpos[] = {x,x-1,x-1,x-1,x,x+1,x+1,x+1};
        int Ypos[] = {y-1,y-1,y,y+1,y+1,y+1,y,y-1};
        
        for(int i=0;i<8;i++)
        {
            if(Xpos[i]>=0 && Xpos[i]<=7 && Ypos[i]>=0 && Ypos[i]<=7)
            {
                if(currentState[Xpos[i]][Ypos[i]].piece == null)
                {
                    currentState[Xpos[i]][Ypos[i]].highlight = true;
                    possibleMoves.add(currentState[Xpos[i]][Ypos[i]]);
                }
                
                else if(currentState[Xpos[i]][Ypos[i]].piece != null &&
                        !currentState[Xpos[i]][Ypos[i]].piece.getColour().equals(this.getColour()))
                {
                    if(!isInDanger(currentState,Xpos[i],Ypos[i])){
                        currentState[Xpos[i]][Ypos[i]].highlight = true;
                        possibleMoves.add(currentState[Xpos[i]][Ypos[i]]);
                    }
                }
            }
            
        }
        return possibleMoves;
    }

    private boolean isInDanger(Square[][] currentState,int x,int y) {
        
        //check for all horizontal positions
        //ROOK's MOVES
        
        //HORIZONTAL LEFT NAVIGATION OF QUEEN
        for(int j=y-1;j>=0;j--)
        {
            if(currentState[x][j].piece == null)
            {
                continue;
            }

            else if(currentState[x][j].piece != null)
            {
                if(!currentState[x][j].piece.colour.equals(this.colour) && 
                        (currentState[x][j].getPiece() instanceof Rook || currentState[x][j].getPiece() instanceof Queen))
                {
                    return true;
                }

                else
                {
                    break;
                }
            }

        }
        
        //HORIZONTAL RIGHT NAVIGATION OF QUEEN
        for(int j=y+1;j<=7;j++)
        {
            if(currentState[x][j].piece == null)
            {
                continue;
            }

            else if(currentState[x][j].piece != null)
            {
                if(!currentState[x][j].piece.colour.equals(this.colour) && 
                        (currentState[x][j].getPiece() instanceof Rook || currentState[x][j].getPiece() instanceof Queen))
                {
                    return true;
                }

                else
                {
                    break;
                }
            }

        }
        
        //VERTICAL UP NAVIGATION OF QUEEN
        for(int i=x-1;i>=0;i--)
        {
            if(currentState[i][y].piece == null)
            {
                continue;
            }

            else if(currentState[i][y].piece != null)
            {
                if(!currentState[x][y].piece.colour.equals(this.colour) && 
                        (currentState[x][y].getPiece() instanceof Rook || currentState[x][y].getPiece() instanceof Queen))
                {
                    return true;
                }

                else
                {
                    break;
                }
            }
        }
        
        //VERTICAL DOWN NAVIGATION OF QUEEN
        for(int i=x+1;i<=7;i++)
        {
            if(currentState[i][y].piece == null)
            {
                continue;
            }

            else
            {
                if(!currentState[x][y].piece.colour.equals(this.colour) && 
                        (currentState[x][y].getPiece() instanceof Rook || currentState[x][y].getPiece() instanceof Queen))
                {
                    return true;
                }

                else
                {
                    break;
                }
            }
        }
        
        /******************************************************************/
        
        //BISHOP's MOVES
        int i = x-1;
        int j = y-1;
        
        //Moving diagonally left upwards
        while(i>=0 && j>=0)
        {
            if(currentState[i][j].piece == null)
            {
                continue;
            }

            else if(currentState[i][j].piece != null)
            {
                if(!currentState[i][j].piece.colour.equals(this.colour) && 
                        (currentState[i][j].getPiece() instanceof Bishop || currentState[i][j].getPiece() instanceof Queen))
                {
                    return true;
                }

                else
                {
                    break;
                }
            }
            i--;
            j--;
        }
        
        //Moving diagonally left downwards
        i = x+1;
        j = y-1;
        
        while(i<=7 && j>=0)
        {
            if(currentState[i][j].piece == null)
            {
                continue;
            }

            else if(currentState[i][j].piece != null)
            {
                 if(!currentState[i][j].piece.colour.equals(this.colour) && 
                        (currentState[i][j].getPiece() instanceof Bishop || currentState[i][j].getPiece() instanceof Queen))
                {
                    return true;
                }

                else
                {
                    break;
                }
            }
            i++;
            j--;
        }
        
        //Moving diagonally right upwards
        i = x-1;
        j = y+1;
        
        while(i>=0 && j<=7)
        {
            if(currentState[i][j].piece == null)
            {
                continue;
            }

            else if(currentState[i][j].piece != null)
            {
                if(!currentState[i][j].piece.colour.equals(this.colour) && 
                        (currentState[i][j].getPiece() instanceof Bishop || currentState[i][j].getPiece() instanceof Queen))
                {
                    return true;
                }

                else
                {
                    break;
                }
            }
            i--;
            j++;
        }
        
        //Moving diagonally right downwards
        i = x+1;
        j = y+1;
        
        while(i<=7 && j<=7)
        {
            if(currentState[i][j].piece == null)
            {
                continue;
            }

            else if(currentState[i][j].piece != null)
            {
                 if(!currentState[i][j].piece.colour.equals(this.colour) && 
                        (currentState[i][j].getPiece() instanceof Bishop || currentState[i][j].getPiece() instanceof Queen))
                {
                    return true;
                }

                else
                {
                    break;
                }
            }
            i++;
            j++;
        }
        
        /*************************************************************/
        //KNIGHT MOVES
        
        int Xpos[] = {x-1,x-2,x-2,x-1,x+1,x+2,x+2,x+1};
        int Ypos[] = {y-2,y-1,y+1,y+2,y+2,y+1,y-1,y-2};
               
        for(i=0;i<8;i++)
        {
            if(Xpos[i]>=0 && Xpos[i]<=7 && Ypos[i]>=0 && Ypos[i]<=7)
            {
                if(currentState[Xpos[i]][Ypos[i]].piece == null)
                {
                    continue;
                }
                
                else if(!currentState[Xpos[i]][Ypos[i]].piece.getColour().equals(this.getColour()) &&
                        (currentState[Xpos[i]][Ypos[i]].getPiece() instanceof Knight))
                {
                    return true;
                }
            }
        }
       
        //PAWN MOVES
        
        //WHITE KING
        if(this.getColour().equals("white"))
        {
            if(currentState[x-1][y-1].getPiece()!=null && currentState[x-1][y-1].getPiece().getColour().equals("black")
                    && (currentState[x-1][y-1].getPiece() instanceof Pawn))
                {
                    return true;
                }
            
            if(currentState[x-1][y+1].getPiece()!=null && currentState[x-1][y+1].getPiece().getColour().equals("black")
                    && (currentState[x-1][y+1].getPiece() instanceof Pawn))
                {
                    return true;
                }
        }
        
        //BLACK KING
        else
        {
            if(currentState[x+1][y-1].getPiece()!=null && currentState[x+1][y-1].getPiece().getColour().equals("white")
                    && (currentState[x+1][y-1].getPiece() instanceof Pawn))
                {
                    return true;
                }
            
            if(currentState[x+1][y+1].getPiece()!=null && currentState[x+1][y+1].getPiece().getColour().equals("white")
                    && (currentState[x+1][y+1].getPiece() instanceof Pawn))
                {
                    return true;
                }
        }
        return false;
    }
       
    //YET TO BE MODIFIED******************************////
    public boolean isCheckMate(Square[][] currentState,int x,int y){
        ArrayList<Square>possibleMoves = move(currentState);
        
        if(isInDanger(currentState,x,y))
        {
            if(possibleMoves.isEmpty())
            {
                return true;
            }
        }
        
        return false;
    }
}
