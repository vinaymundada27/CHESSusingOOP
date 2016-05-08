package chessgame;

import java.awt.Button;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Time implements Runnable{
    static Thread thread;
    static int remainingTime1;
    static int remainingTime2;
    int min;
    int sec;
    
    Time(){
        //thread = new Thread();
        remainingTime1= 120;
        remainingTime2 = 120;
    }
    
    Time(int r){
        new Thread(new Time()).start();
    }

    @Override
    public void run() {
        while(remainingTime1>0 && remainingTime2>0)
        {
            try {
                Thread.sleep(1000);
            }catch (InterruptedException ex) {
                //Logger.getLogger(Time.class.getName()).log(Level.SEVERE, null, ex);
            }

            if(Button_Handler.turn == true)
            {
                //remainingTime--;
                remainingTime1--;
                min = remainingTime1/60;
                sec = remainingTime1%60;
                ChessBoardWithColumnsAndRow.timer1.setText(String.valueOf(min)+":"+ String.valueOf(sec));
            }
            else
            {
                //remainingTime--;
                remainingTime2--;
                min = remainingTime2/60;
                sec = remainingTime2%60;
                ChessBoardWithColumnsAndRow.timer2.setText(String.valueOf(min)+":"+ String.valueOf(sec));
            }
        }
        
        if(remainingTime1==0)
        {
            ChessBoardWithColumnsAndRow.Game_Status.setText("TIME's UP! BLACK WINS");
            JOptionPane.showMessageDialog(null, "TIME's UP! BLACK WINS");
        }
        else if(remainingTime2 ==0 )
        {
            ChessBoardWithColumnsAndRow.Game_Status.setText("TIME's UP! WHITE WINS");
            JOptionPane.showMessageDialog(null, "TIME's UP! WHITE WINS");
        }
    }
}
