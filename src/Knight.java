package chessgame;

import java.util.ArrayList;
import java.util.HashMap;

public class Knight extends Piece {
    
    Knight(String id,int x,int y,String colour){
        this.X = x;
        this.Y = y;
        this.notation = "N";
        this.id = id;
        possibleMoves = new ArrayList<>();
        this.idToPath = new HashMap<>();
        this.colour = colour;
        
        if(colour.equals(WHITE)){
            setIdToPath(id,"71.png");
        }
        else
            setIdToPath(id,"01.png");
        
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
                if(currentState[Xpos[i]][Ypos[i]].getPiece() == null ||
                        !currentState[Xpos[i]][Ypos[i]].getPiece().getColour().equals(this.getColour()))
                {
                    currentState[Xpos[i]][Ypos[i]].highlight = true;
                    possibleMoves.add(currentState[Xpos[i]][Ypos[i]]);
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
