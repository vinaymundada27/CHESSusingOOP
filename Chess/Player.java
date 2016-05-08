package chessgame;

public class Player {

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
}
