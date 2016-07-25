package com.game;

import java.awt.GraphicsEnvironment;
import javax.swing.JFrame;

/**
 *
 * @author hp
 */

public class chess  
{
    public chess() //With applications, you have to specify a main method (not with applets)
    {
        JFrame.setDefaultLookAndFeelDecorated(true); //Make it look nice
        long startAllocateTime = System.currentTimeMillis();
        JFrame frame = new JFrame("Chess Game"); //Title
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        chessGUI chessWindow = new chessGUI();
        frame.setContentPane(chessWindow.createGUI(frame));
        frame.addWindowFocusListener(chessWindow);
        
        frame.setSize(550,650);
        frame.setResizable(false);
        frame.setVisible(true);  
        frame.pack();  
        System.out.println("time");
         
         long endAllocateTime = System.currentTimeMillis();
         long allocation = endAllocateTime - startAllocateTime;

            double allocate = (double)allocation  / 1000000000.0;
           System.out.println("Time to display frame ... ");
            System.out.println("Time :" + allocate +"seconds");
            System.out.format(" Time : %f Seconds \n",allocate );


         
    }	
    public static void main(String args[])
    {
        chess c = new chess();
    }
}