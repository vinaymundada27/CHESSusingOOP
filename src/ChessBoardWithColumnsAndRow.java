package chessgame;

import java.awt.*;
import static java.awt.Font.CENTER_BASELINE;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.text.AttributedCharacterIterator;
import javax.imageio.ImageIO;
import javax.swing.*;
import static javax.swing.BoxLayout.Y_AXIS;
import static javax.swing.SwingConstants.BOTTOM;
import static javax.swing.SwingConstants.CENTER;
import static javax.swing.SwingConstants.LEFT;
import static javax.swing.SwingConstants.RIGHT;
import static javax.swing.SwingConstants.TOP;
import static javax.swing.SwingConstants.TRAILING;
import javax.swing.border.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Graphics;
import java.util.ArrayList;

class ChessBoardWithColumnsAndRow {

    private final JPanel gui ;//This is the BASE Panel
    public JButton[][] boardSquares ;//8*8 matrix of CHESS_BOARD CELLS buttons
    private JPanel board;//Panel for BOARD
    private JPanel players_container;//Panel for Player and Game Details
    private JLabel white;
    private JLabel black;
    private JLabel player1;
    private JLabel player2; 
    private JLabel Timer1;
    private JLabel Timer2;
    private JLabel Dead;
    public JLabel []Dead_pieces_white;
    public JLabel []Dead_Pawns_white;
    public JLabel []Dead_pieces_black;
    public JLabel []Dead_Pawns_black;
    public static JLabel Game_Status;
    public TextField Name1;
    public TextField Name2;
    public static TextField timer1;
    public static TextField timer2;
    private JButton start;
    private final JLabel message ;
    private static final String COLS = "abcdefgh";
    private FlowLayout layout;
    private Image img;
    final Board chessBoard;
    public Thread thread;
 
    public ChessBoardWithColumnsAndRow() {
        this.gui = null;
        this.message = null;
        this.chessBoard = null;
    }
    
    
    ChessBoardWithColumnsAndRow(Board chessBoard) {
        this.chessBoard = chessBoard;
        gui = new JPanel(new BorderLayout());//OUTER PANEL
        gui.setPreferredSize(new Dimension(600,600));
        board = new JPanel(new GridLayout(0, 9));//LEFT SIDE PANEL
        layout=new FlowLayout();
        players_container=new JPanel();//RIGHT SIDE PANEL
        players_container.setLayout(layout);

        Dead_Pawns_white=new JLabel[8];
        Dead_pieces_white=new JLabel[7];
        Dead_Pawns_black=new JLabel[8];
        Dead_pieces_black=new JLabel[7];

        boardSquares = new JButton[8][8];
        message = new JLabel("Chess Champ is ready to play!");
        thread = new Thread();
        initializeGui();
    }
  
    public final void initializeGui() {
        // set up the main GUI
        gui.setBorder(new LineBorder(Color.WHITE));
        board.setBorder(new LineBorder(Color.BLACK));
        board.setPreferredSize(new Dimension(1200,1000));
        players_container.setBorder(new LineBorder(Color.BLACK));
        players_container.setPreferredSize(new Dimension(450,1000));
        layout.setAlignment(TRAILING);
        layout.setVgap(25);
        layout.setHgap(10);
        
        white=new JLabel("              WHITE          ");
        white.setFont(new Font("Courier New",Font.BOLD, 24));
        white.setForeground(Color.BLACK);
        player1=new JLabel("Player1:");
        player1.setFont(new Font(COLS, TOP, 18));
        Name1=new TextField();
        Name1.setColumns(15);
        Timer1=new JLabel("Timer:");
        Timer1.setFont(new Font(COLS, TOP, 18));
        timer1=new TextField();
        timer1.setPreferredSize(new Dimension(80,55));
        timer1.setText("2.00");
        timer1.setFont(new Font("Courier New",Font.CENTER_BASELINE,38));
        Dead=new JLabel("DEAD:"); 
        Dead.setFont(new Font("Courier New",Font.BOLD, 18));
        
        
        players_container.add(white);
        players_container.add(player1);
        players_container.add(Name1);
        players_container.add(Timer1);
        players_container.add(timer1);
        players_container.add(Dead);
        
        for(int i=0;i<8;i++)
        {
            Dead_Pawns_white[i]=new JLabel();
            Dead_Pawns_white[i].setPreferredSize(new Dimension(40,40));
             /*try {
                    Image img = ImageIO.read(getClass().getResource("Dead/White_Pawn.png"));
                    Dead_Pawns_white[i].setIcon(new ImageIcon());
                  } catch (IOException ex) {
                  }*/
            players_container.add(Dead_Pawns_white[i]);
        }
        
        for(int i=0;i<7;i++)
        {
            Dead_pieces_white[i]=new JLabel();
            Dead_pieces_white[i].setPreferredSize(new Dimension(40,40));
            /*try {
                    Image img = ImageIO.read(getClass().getResource("Dead/White_King.png"));
                    Dead_pieces_white[i].setIcon(new ImageIcon());
                  } catch (IOException ex) {
                  }*/
            players_container.add(Dead_pieces_white[i]);
        }
        JLabel Line=new JLabel();
        Line.setText("_______________________________________________________________________________");
        players_container.add(Line);
        
        Game_Status=new JLabel();
        Game_Status.setPreferredSize(new Dimension(450,40));
        Game_Status.setText("GAME STATUS");
        Game_Status.setFont(new Font("ALGERIAN",Font.BOLD, 24));
        Game_Status.setHorizontalAlignment(CENTER);
        Game_Status.setHorizontalTextPosition(CENTER);
        //Game_Status.setBorder(new LineBorder(Color.MAGENTA));
        players_container.add(Game_Status);
        JLabel Line1=new JLabel();
        Line1.setText("_______________________________________________________________________________");
        players_container.add(Line1);
    
 //PLAYER1 FINISHED
 //-------------------------------------------------------------------------------------------------------------//  
        JLabel j = new JLabel("                                                         ");
        start=new JButton("START");
        start.setPreferredSize(new Dimension(100,50));
        start.setFont(new Font("Courier New",Font.BOLD, 20));
        start.setHorizontalAlignment(CENTER);
        players_container.add(j);
        players_container.add(start);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //Thread t = new Thread();
                Time timer = new Time(60);
            }
        });
        
        black=new JLabel("              BLACK          ");
        black.setFont(new Font("Courier New",Font.BOLD, 24));
        black.setForeground(Color.BLACK);
        player2=new JLabel("Player2:");
        player2.setFont(new Font(COLS, TOP, 18));
        Name2=new TextField();
        Name2.setColumns(15);
        Timer2=new JLabel("Timer:");
        Timer2.setFont(new Font(COLS, TOP, 18));
        timer2=new TextField();
        timer2.setPreferredSize(new Dimension(80,55));
        timer2.setText("2.00");
        timer2.setFont(new Font("Courier New",Font.CENTER_BASELINE,38));
        Dead=new JLabel("DEAD:"); 
        Dead.setFont(new Font("Courier New",Font.BOLD, 18));
        
     
        players_container.add(black);
        players_container.add(player2);
        players_container.add(Name2);
        players_container.add(Timer2);
        players_container.add(timer2);
        players_container.add(Dead);
        
        for(int i=0;i<8;i++)
        {
            Dead_Pawns_black[i]=new JLabel();
            Dead_Pawns_black[i].setPreferredSize(new Dimension(40,40));
            /* try {
                    Image img = ImageIO.read(getClass().getResource("Dead/Black_Pawn.png"));
                    Dead_Pawns_black[i].setIcon(new ImageIcon(img));
                  } catch (IOException ex) {
                  }*/
            players_container.add(Dead_Pawns_black[i]);
        }
        
        for(int i=0;i<7;i++)
        {
            Dead_pieces_black[i]=new JLabel();
            Dead_pieces_black[i].setPreferredSize(new Dimension(40,40));
            /*try {
                    Image img = ImageIO.read(getClass().getResource("Dead/Black_King.png"));
                    Dead_pieces_black[i].setIcon(new ImageIcon(img));
                  } catch (IOException ex) {
                  }*/
            players_container.add(Dead_pieces_black[i]);
        }
        
    //PLAYER2 FINISHED    
//-----------------------------------------------------------------------------------------------------------//        
        players_container.setBackground(Color.white);
        board.setBackground(Color.BLACK);
        gui.setBackground(Color.BLACK);
        gui.add(board,BorderLayout.WEST);
        gui.add(players_container,BorderLayout.EAST);
     
        //JToolBar tools = new JToolBar();
        //tools.setFloatable(false);
        //gui.add(tools, BorderLayout.NORTH);
        /*tools.add(new JButton("New")); // TODO - add functionality!
        tools.add(new JButton("Save")); // TODO - add functionality!
        tools.add(new JButton("Restore")); // TODO - add functionality!
        tools.addSeparator();
        tools.add(new JButton("Resign")); // TODO - add functionality!
        tools.addSeparator();
        tools.add(message);*/

        //gui.add(new JLabel("?"), BorderLayout.LINE_START);
               
        
   
       // create the chess board squares
        Button_Handler[][] handler = new Button_Handler[8][8];
        int ii,jj;
        Insets buttonMargin = new Insets(0,0,0,0);
        for (jj = 0; jj < boardSquares.length; jj++) {
            for (ii = 0; ii < boardSquares.length; ii++) {
                
                handler[jj][ii] = new Button_Handler(jj,ii,chessBoard);
                
                handler[jj][ii].button.setMargin(buttonMargin);
                // our chess pieces are 64x64 px in size, so we'll
                // 'fill this in' using a transparent icon..
              /* ImageIcon icon = new ImageIcon(
                new BufferedImage(64, 64,BufferedImage.TYPE_INT_ARGB));
                handler.button.setIcon(icon);*/
                if ((jj % 2 == 1 && ii % 2 == 1)
                        //) {
                        || (jj % 2 == 0 && ii % 2 == 0)) {
                   handler[jj][ii].button.setBackground(Color.WHITE);
                } else {
                    handler[jj][ii].button.setBackground(Color.blue);
                }
               // handler.button.setIcon(icon);
             try {
                   if(jj==1)
                   {
                     img = ImageIO.read(getClass().getResource("ChessImages/1.png"));
                     handler[jj][ii].button.setIcon(new ImageIcon(img));
                   }
                   else if(jj == 0)
                    {   
                        String str="ChessImages/0".concat(String.valueOf(ii)).concat(".png");
                        img = ImageIO.read(getClass().getResource(str)); handler[jj][ii].button.setIcon(new ImageIcon(img));
                    }
                   else if(jj==6)
                   {
                     img = ImageIO.read(getClass().getResource("ChessImages/2.png")); 
                     handler[jj][ii].button.setIcon(new ImageIcon(img));
                   }
                   else if(jj == 7)
                    {   
                        String str="ChessImages/7".concat(String.valueOf(ii)).concat(".png");
                        img = ImageIO.read(getClass().getResource(str)); handler[jj][ii].button.setIcon(new ImageIcon(img));
                    }
                   else
                       handler[jj][ii].button.setIcon(null);
                   
                  } catch (IOException ex) {
                  } 
             //System.out.println("before");
                //handler.setListener(jj,ii,this);
                //System.out.println(handler[jj][ii].getX());
                boardSquares[jj][ii] = handler[jj][ii].button;
                //boardSquares[jj][ii].setBorder((Border) Color.black);
            }
        }

        //fill the chess board
        board.add(new JLabel(""));
        // fill the top row
        for ( ii = 0; ii < 8; ii++) {
            JLabel jb = new JLabel(COLS.substring(ii, ii + 1),SwingConstants.CENTER);
            jb.setForeground(Color.WHITE);
            jb.setFont((new Font("Courier New",Font.CENTER_BASELINE,18)));
            board.add(jb);
        }
        // fill the player2 non-pawn piece row
        
        for ( jj = 0; jj < 8; jj++) {
            for ( ii = 0; ii < 8; ii++) {
                switch (ii) {
                    case 0:
                        JLabel jb = new JLabel("" + (jj + 1),SwingConstants.CENTER);
                        jb.setForeground(Color.WHITE);
                        jb.setFont((new Font("Courier New",Font.CENTER_BASELINE,18)));
                        board.add(jb);
                        
                    default:
                       // boardSquares[jj][ii].setBorderPainted(true);
                        board.add(boardSquares[jj][ii]);
                        handler[jj][ii].setListener(jj, ii, this,handler);
                }
            }
        }
    }
    
   /* public void ActionPerformed(ActionEvent e) throws InterruptedException
    {
        if(e.getSource()==start)
        {
             
            //Timer timer=new Timer();
             
           
        }
    }*/
    public void countDown()
    {
        
    }
    
    public final JComponent getChessBoard() {
        return board;
    }

    public final JComponent getGui() {
        return gui;
    }
   
}
