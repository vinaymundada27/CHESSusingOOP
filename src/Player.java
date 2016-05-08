package chessgame;

public class Player extends Thread {

    private String WHITE = "white";
    private String BLACK = "black";
    private String NAME;
    private float TIMER;
    private String colour;
    
    Player(String colour)
    {
        this.colour = colour;
        this.TIMER = (float) 5.00;
    }
    
    public void updateGameStatus(Player p){
        
        //MAKE  A DIALOG BOX OF WHO WINS!
        
    }

    public String getColour() {
        return colour;
    }
    
}
