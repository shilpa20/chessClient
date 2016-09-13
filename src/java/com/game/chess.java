package com.game;

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
        time t = new time();
         
         long endAllocateTime = System.currentTimeMillis();
        long duration = (endAllocateTime - startAllocateTime);  
        System.out.format("Milli = %s, ( S_Start : %s, S_End : %s ) \n", duration, startAllocateTime, endAllocateTime );
        System.out.println("Human-Readable format : "+t.millisToShortDHMS( duration ) );


         
    }	
    public static void main(String args[])
    {
        chess c = new chess();
    }
}