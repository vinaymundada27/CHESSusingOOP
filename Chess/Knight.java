package chessgame;

import java.util.ArrayList;

public class Knight extends Piece {
    
    Knight(String id,int x,int y){
        this.X = x;
        this.Y = y;
        this.notation = "N";
        this.id = id;
        possibleMoves = new ArrayList<>();
    }

    @Override
    public ArrayList<Square> move(Square[][] currentState) {
        
        possibleMoves.clear();
        // A Knight can move to maximum 8 possible squares
        int Xpos[] = {this.X-1,this.X-2,this.X-2,this.X-1,this.X+1,this.X+2,this.X+2,this.X+1};
        int Ypos[] = {this.Y-2,this.Y-1,this.Y+1,this.Y+2,this.Y+2,this.Y+1,this.Y-1,this.Y-2};
               
        for(int i=0;i<8;i++)
        {
            if(Xpos[i]>=0 && Xpos[i]<=7 && Ypos[i]>=0 && Ypos[i]<=7)
            {
                if(currentState[Xpos[i]][Ypos[i]].piece == null ||
                        !currentState[Xpos[i]][Ypos[i]].piece.getColour().equals(this.getColour()))
                {
                    currentState[Xpos[i]][Ypos[i]].highlight = true;
                    possibleMoves.add(currentState[Xpos[i]][Ypos[i]]);
                }
            }
        }
        return possibleMoves;
    }
    
    
}
