package chessgame;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

class Button_Handler{
    public final String WHITE = "white";
    public final String BLACK = "black";
    JButton button;
    int X;
    int Y;
    ChessBoardWithColumnsAndRow cbcr;
    final Board chessBoard;
    Button_Handler handler;
    static String currentImage;
    Image img;
    static int previousX;
    static int previousY;
    
    static Piece previousPiece;
    static ArrayList<Square> previousPossibleMoves;
    ArrayList<Square> possibleMoves;
    static boolean turn = true;
    static int whitePawn = 0;
    static int whitePiece =  0;
    static int blackPawn = 0;
    static int blackPiece =  0;
    static Time timer;
    static boolean timerturn = true;
    
    //CONSTRUCTOR
    public Button_Handler(){
        chessBoard =null;
        currentImage = null;
        timer = null;
    }
    public Button_Handler(int x,int y,Board chessBoard) {
        this.button = new JButton();
        this.X = x;
        this.Y = y;
        this.chessBoard = chessBoard;
        currentImage = null;
        timer = new Time();
        
        //cbcr = new ChessBoardWithColumnsAndRow();
    }
    
    public void setListener(int jj,int ii,ChessBoardWithColumnsAndRow cbcr,Button_Handler[][] handler)
    {
        cbcr.boardSquares[jj][ii].addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            //System.out.println("button"+jj+ii);
            int x = handler[jj][ii].getX();
            int y = handler[jj][ii].getY();
            
            //System.out.println("xy "+x+" " + y);
            Piece p = chessBoard.squares[x][y].getPiece();
            //String previousImage = null;
            
            /*if(p!=null)
            {
                currentImage = p.getIdToPath(p.id);
                System.out.println("image path: "+currentImage);
                //previousImage = currentImage;
            }*/
            
            /***************  SOURCE SELECTED   ****************/
            if(sourceSelected(chessBoard.squares))
            {
                System.out.println("source");
               
                previousX = x;
                previousY = y;
                previousPiece = p;
                
                if(p == null){
                    DialogMessage("NO PIECE ON THE SELECTED SQUARE");
                    return;              
                }   
            
                else
                {
                    if(turn == true && p.getColour().equals(BLACK))
                    {
                        DialogMessage("WHITE's  TURN");
                        return;
                    }
                    
                    else if(turn == false && p.getColour().equals(WHITE))
                    {
                        DialogMessage("BLACKS's  TURN");
                        return;
                    }
                    
                    if(kingInDanger(cbcr)) 
                    { 
                        if(!(p instanceof King))
                        {
                            DialogMessage("King under Check!");
                            System.out.println("check");
                            clearAllHighlight(chessBoard.squares);
                            return;
                        }
                        else
                        {
                            possibleMoves = p.move(chessBoard.squares);
                            
                            if(possibleMoves.isEmpty())
                            {
                                DialogMessage("game overs");
                                return;
                            }
                            else
                            {
                                Border emptyBorder = BorderFactory.createEmptyBorder();
                                cbcr.boardSquares[x][y].setBorder(emptyBorder);
                                clearAllHighlight(chessBoard.squares);
                            }
                        }
                    }
                
                    
                    currentImage = p.getIdToPath(p.id);
                    //System.out.println("image path: "+currentImage);
                    //imageName = p.getIdToPath(p.id);
                    //System.out.println("src current "+x+" "+ y);

                    possibleMoves = p.move(chessBoard.squares);
                    //System.out.println("poss size: "+possibleMoves.size() );
                    addHighLight(cbcr,possibleMoves);
                    previousPossibleMoves = possibleMoves;
                }
            }
            
            /******************* DESTINATION SELECTED ***************/
            else
            {
                //imageName = p.getIdToPath(p.id);
                System.out.println("dest");
                if(p == null){
                    // set and remove image from buttons
                    if(previousPossibleMoves.contains(chessBoard.squares[x][y]))
                    {
                        //set and remove Piece Image from squares
                        SetandRemoveImage(handler,x,y);

                        //set and remove Piece object from squares
                        SetandRemovePiece(x,y);

                        /*System.out.println(chessBoard.squares[x][y].getPiece().getId());

                        if(chessBoard.squares[7][6].getPiece() == null)
                        {
                            System.out.println("null");
                        }*/
                        //remove highlight of buttons
                        removeHighlight(cbcr,previousPossibleMoves,chessBoard.squares);

                        //previousX = x;
                        //previousY = y;
                    }

                    else{
                        // ILLEGAL MOVE DIALOG BOX
                        DialogMessage(" ILLEGAL MOVE ");
                        return;
                    }
                }   
            
                else//Attacking opponent piece
                {
                    if(x == previousX && y == previousY){
                        removeHighlight(cbcr,previousPossibleMoves,chessBoard.squares);
                        return;
                    }
                    
                    if(previousPossibleMoves.contains(chessBoard.squares[x][y])){
                        //currentImage = previousPiece.getIdToPath(previousPiece.getId());
                        String attackedPieceImage = p.getIdToPath(p.getId());

                        //set the dead piece image
                        setDeadPiece(cbcr,p,attackedPieceImage);

                        //set and remove Piece Image from squares
                        SetandRemoveImage(handler,x,y);

                        //set and remove Piece object from squares
                        SetandRemovePiece(x,y);

                        removeHighlight(cbcr,previousPossibleMoves,chessBoard.squares);

                        previousX = x;
                        previousY = y;
                    }
                    else{
                        // ILLEGAL MOVE DIALOG BOX
                        DialogMessage(" ILLEGAL MOVE ");
                        return;
                    }
                   
                }
                //timer.start(turn);
                
                changeTurn();
                
                //timer.stop(turn);
                
                if(turn == true)
                    cbcr.Game_Status.setText("WHITE TO PLAY");
                
                else
                    cbcr.Game_Status.setText("BLACK TO PLAY");
                
                System.out.println("turn = "+ turn);
            }
        }
    });
    }
    
    public boolean sourceSelected(Square[][] squares)
    {
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
                if(squares[i][j].highlight)
                    return false;
            }
        }
        
        return true;
    }
    
    public void addHighLight(ChessBoardWithColumnsAndRow cbcr,ArrayList<Square> possibleMoves){
       
        for(Square sq : possibleMoves)
        {
            int x = sq.getX();
            int y = sq.getY();
            
            Border greenBorder = new LineBorder(Color.GREEN, 8);
            Border redBorder = new LineBorder(Color.RED, 8);
            
            if(sq.getPiece() != null)
                cbcr.boardSquares[x][y].setBorder(redBorder);
            
            else
                cbcr.boardSquares[x][y].setBorder(greenBorder);
        }
    }
    
    public void removeHighlight(ChessBoardWithColumnsAndRow cbcr,ArrayList<Square> possibleMoves,Square[][] squares){
       
        for(Square sq : possibleMoves)
        {
            int x = sq.getX();
            int y = sq.getY();
            
            Border emptyBorder = BorderFactory.createEmptyBorder();
            cbcr.boardSquares[x][y].setBorder(emptyBorder);
            //squares[x][y].highlight = false;
        }
        
        clearAllHighlight(squares);
        
    }
       
    public void SetandRemoveImage(Button_Handler[][] handler,int x,int y){
        
        try {
            img = ImageIO.read(getClass().getResource("ChessImages/"+currentImage));
        }catch (IOException ex) {
            Logger.getLogger(Button_Handler.class.getName()).log(Level.SEVERE, null, ex);
        }

        handler[x][y].button.setIcon(new ImageIcon(img));

        //remove previous image
        //System.out.println("dest previous "+previousX+" "+ previousY);
        handler[previousX][previousY].button.setIcon(new ImageIcon());
       
    }

    public void SetandRemovePiece(int x,int y){
        
        previousPiece.setX(x);
        previousPiece.setY(y);
        chessBoard.squares[x][y].setPiece(previousPiece);
        
        chessBoard.squares[previousX][previousY].setPiece(null);
    }
    
    public void setDeadPiece(ChessBoardWithColumnsAndRow cbcr,Piece p,String s)
    {
        if(p.getColour().equals(WHITE))
        {
            if(p instanceof Pawn)
            {
                try {
                    Image img = ImageIO.read(getClass().getResource("Dead/2.png"));
                    cbcr.Dead_Pawns_white[whitePawn].setIcon(new ImageIcon(img));
                    whitePawn++;
                } catch (IOException ex) {
                    Logger.getLogger(Button_Handler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else
            {
                try {
                    Image img = ImageIO.read(getClass().getResource("Dead/"+p.getIdToPath(p.getId())));
                    cbcr.Dead_pieces_white[whitePiece].setIcon(new ImageIcon(img));
                    whitePiece++;
                } catch (IOException ex) {
                    Logger.getLogger(Button_Handler.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
        else
        {
            if(p instanceof Pawn)
            {
                try {
                    Image img = ImageIO.read(getClass().getResource("Dead/1.png"));
                    cbcr.Dead_Pawns_black[blackPawn].setIcon(new ImageIcon(img));
                    blackPawn++;
                } catch (IOException ex) {
                    Logger.getLogger(Button_Handler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else
            {
                try {
                    Image img = ImageIO.read(getClass().getResource("Dead/"+p.getIdToPath(p.getId())));
                    cbcr.Dead_pieces_black[blackPiece].setIcon(new ImageIcon(img));
                    blackPiece++;
                } catch (IOException ex) {
                    Logger.getLogger(Button_Handler.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }
    
    public void changeTurn(){
        turn = !turn;
    }
    
    public boolean kingInDanger(ChessBoardWithColumnsAndRow cbcr){
        King k;
        if(turn == true)
            k = getWhiteKing();
        
        else
            k = getBlackKing();
        
        //System.out.println("in danger "+ k.getColour()+ " xy "+ k.getX()+" " + k.getY() );
        
        if(k.isCheckMate(chessBoard.squares,k.getX(),k.getY()))
        {
            if(k.colour.equals(WHITE))
            {
                cbcr.Game_Status.setText("GAME OVER! BLACK WINS!!!");
                DialogMessage("CHECKMATE! BLACK WINS!!!\r\n");
                return false;
            }
            else
            {
                cbcr.Game_Status.setText("GAME OVER! WHITE WINS!!!");
                DialogMessage("CHECKMATE! WHITE WINS!!!");
                return false;
            }
        }
        
        if(k.isInDanger(chessBoard.squares,k.getX(),k.getY()))
        {
            Border redBorder = new LineBorder(Color.RED, 8);
            cbcr.boardSquares[k.getX()][k.getY()].setBorder(redBorder);
            //chessBoard.squares[k.getX()][k.getY()].highlight = true;
            return true;
        }
        
        return false;
    }
    
    public void clearAllHighlight(Square[][] squares){
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
                squares[i][j].highlight = false;
            }
        }
    }
    
    public King getWhiteKing(){
        return (King)chessBoard.wk;
    }
    
    public King getBlackKing(){
        return (King)chessBoard.bk;
    }
    
    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }
    
    public void DialogMessage(String s){
        JOptionPane.showMessageDialog(null, s);
    }
}
