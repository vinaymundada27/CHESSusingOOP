package chessgame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import chessgame.ChessBoardWithColumnsAndRow;

public class HomeScreen extends javax.swing.JFrame {
    
    private JFrame f;
    //public HomeSc  
    public HomeScreen(Board chessBoard)
    {
        f= new JFrame();
        JPanel gui = new JPanel(new BorderLayout());//OUTER PANEL
        JButton b=new JButton("");
        gui.setPreferredSize(new Dimension(1350,780));
       
        b.setIcon(new javax.swing.ImageIcon(getClass().getResource("home2.jpg"))); 
         
        b.addActionListener(new ActionListener() {
        @Override 
        public void actionPerformed(ActionEvent e)
        {
            f.dispose();
            f.setVisible(false);
            Runnable r = new Runnable() {

            @Override
            public void run() {
                ChessBoardWithColumnsAndRow cb =
                        new ChessBoardWithColumnsAndRow(chessBoard);

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
                  String Player1_name=JOptionPane.showInputDialog("Enter White Player Name:");
                  cb.Name1.setText(Player1_name);
                  cb.Name1.setFont(new Font("Courier New",Font.BOLD, 18));
                  String Player2_name=JOptionPane.showInputDialog("Enter Black Player Name:");
                  cb.Name2.setText(Player2_name);
                  cb.Name2.setFont(new Font("Courier New",Font.BOLD, 18));
            }
        };
        SwingUtilities.invokeLater(r);
          
        }});
      
        gui.add(b);

        f.add(gui);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setLocationByPlatform(true);

        // ensures the frame is the minimum size it needs to be
        // in order display the components within it
        //f.pack();
        // ensures the minimum size is enforced.
        f.setSize(1920,1080);
        f.setVisible(true);
    }

    
    public static void main(String args[])
    {
        // Initialize Chess Board
        Board chessBoard = new Board();
        
        HomeScreen cover=new HomeScreen(chessBoard);
        
         
        //Board chessBoard = new Board();
        
        // Initialize Chess Board
        /*Board chessBoard = new Board();*/
        
        /***************  GUI    *****************/
        /*ChessBoardWithColumnsAndRow cb = new ChessBoardWithColumnsAndRow(chessBoard);

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
        //cover.setVisible(true);
    }
}

