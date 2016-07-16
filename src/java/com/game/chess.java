package com.game;

import javax.swing.JFrame;

/**
 *
 * @author hp
 */

public class chess extends JFrame
{
    public static void main(String[] args) //With applications, you have to specify a main method (not with applets)
    {
	JFrame.setDefaultLookAndFeelDecorated(true); //Make it look nice
        JFrame frame = new JFrame("Chess Game"); //Title
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        chessGUI chessWindow = new chessGUI();
        frame.setContentPane(chessWindow.createGUI(frame));
        frame.addWindowFocusListener(chessWindow);
        
        frame.setSize(550,650);
        frame.setResizable(false);
        frame.setVisible(true);  
        frame.pack();       
    }	
}