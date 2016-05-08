package chessgame;

public class ChessGame {

    static Player white;
    static Player black;
    boolean turn = true;//true = white's turn
    
    public static void main(String[] args) {
       
        white = new Player("white");
        black = new Player("balck");
            
    }
    
    private void changeTurn(){
        
        turn = !turn;
        
        //change timers
    }
    
    private void gameEnd(){
        
    }
    
}
