package chessgame;

import java.util.ArrayList;

public class Board {

    public Square[][] squares;
    Piece wr1,wr2,wn1,wn2,wb1,wb2,wq,wk,wp[];
    Piece br1,br2,bn1,bn2,bb1,bb2,bq,bk,bp[];
        
    Board(){
        squares = new Square[8][8];
        
        initializePieces();
        
        initializeBoard();
    }

    public void initializeBoard(){
        
        boolean squareColour = true;
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
                squares[i][j] = new Square(i,j,squareColour);
                squareColour = !squareColour;
                squares[i][j].piece = null;
            }
        }
        
        //WHITE PIECES
        squares[7][0].piece = wr1;
        squares[7][1].piece = wn1;
        squares[7][2].piece = wb1;
        squares[7][3].piece = wq;
        squares[7][4].piece = wk;
        squares[7][5].piece = wb2;
        squares[7][6].piece = wn2;
        squares[7][7].piece = wr2;
        
        for(int i=0;i<8;i++)
        {
            squares[6][i].piece = wp[i];
        }
        
        // BLACK PIECES
        squares[0][0].piece = br1;
        squares[0][1].piece = bn1;
        squares[0][2].piece = bb1;
        squares[0][3].piece = bq;
        squares[0][4].piece = bk;
        squares[0][5].piece = bb2;
        squares[0][6].piece = bn2;
        squares[0][7].piece = br2;
        
        for(int i=0;i<8;i++)
        {
            squares[1][i].piece = wp[i];
        }
    }
    
    public void initializePieces(){
        
        //WHITE PIECES
        wr1 = new Rook("WR1",7,0);
        wr2 = new Rook("WR2",7,7);
        wn1 = new Knight("WN1",7,1);
        wn2 = new Knight("WN2",7,6);
        wb1 = new Bishop("WB1",7,2);
        wb2 = new Bishop("WB2",7,5);
        wq = new Queen("WQ",7,3);
        wk = new King("WK",7,4);
        
        for(int i=0;i<8;i++)
        {
            wp[i] = new Pawn("WP"+(i+1),6 ,i);
        }
        
        //BLACK PIECES
        br1 = new Rook("BR1",0,0);
        br2 = new Rook("BR2",0,7);
        bn1 = new Knight("BN1",0,1);
        bn2 = new Knight("BN2",0,6);
        bb1 = new Bishop("BB1",0,2);
        bb2 = new Bishop("BB2",0,5);
        bq = new Queen("BQ",0,3);
        bk = new King("BK",0,4);
        
        for(int i=0;i<8;i++)
        {
            bp[i] = new Pawn("BP"+(i+1),1,i);
        }
    }
    
}
