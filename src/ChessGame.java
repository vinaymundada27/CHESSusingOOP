package chessgame;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class ChessGame {

    static Player white;
    static Player black;
    boolean turn = true;//true = white's turn
    
    /*public static void main(String[] args) {
       
        white = new Player("white");
        black = new Player("balck");
        
        // Initialize Chess Board
        Board chessBoard = new Board();*/
        
        /***************  GUI    *****************/
       /* ChessBoardWithColumnsAndRow cb = new ChessBoardWithColumnsAndRow(chessBoard);

        JFrame f = new JFrame("ChessChamp");
        f.add(cb.getGui());
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setLocationByPlatform(true);

        // ensures the frame is the minimum size it needs to be
        // in order display the components within it
        f.pack();
        // ensures the minimum size is enforced.
        f.setSize(1920,1080);
        f.setVisible(true);
         
        /**************  GUI ENDS *****************/
      
    }
    
    /*private void changeTurn(){
        
        
        turn = !turn;
        
        //change timers
    }
    
    private void gameEnd(){
        
    }*/
    

