/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */

public class chessGUI implements ActionListener, KeyListener, WindowFocusListener
{
    private windowChessBoard mainChessBoard;
    private objCreateAppletImage createImage;
    private JButton cmdNewGame, cmdSetNames;
    private JTextField txtPlayerOne, txtPlayerTwo;
    private JLabel lblPlayerOne, lblPlayerTwo;
    private final String[] strRedPieces = {"redPawn.gif","redRock.gif","redKnight.gif","redBishop.gif","redQueen.gif","redKing.gif"};
    private final String[] strBluePieces = {"bluePawn.gif","blueRock.gif","blueKnight.gif","blueBishop.gif","blueQueen.gif","blueKing.gif"};
    private final Color clrBlue = new Color(75,141,221);
    private MediaTracker mt;
	
    public void chessGUI ()
    {
	
    }
	
    public Container createGUI (JFrame mainApp)
    {
	JPanel panRoot = new JPanel(new BorderLayout());
	panRoot.setOpaque(true);
	panRoot.setPreferredSize(new Dimension(550,650));
		
	mainChessBoard = new windowChessBoard();
	createImage = new objCreateAppletImage();
		
	mainChessBoard.setSize(new Dimension(500, 500));
		
	cmdNewGame = new JButton("New Game");
	cmdSetNames = new JButton("Set Names");
		
	cmdNewGame.addActionListener(this);
	cmdSetNames.addActionListener(this);
		 
        txtPlayerOne = new JTextField("shipa", 10);
	txtPlayerTwo = new JTextField("sakshi", 10);
		
	txtPlayerOne.addKeyListener(this);
	txtPlayerTwo.addKeyListener(this);
		
	lblPlayerOne = new JLabel("    ", JLabel.RIGHT);
	lblPlayerTwo = new JLabel("    ", JLabel.RIGHT);
		
	try
	{
            Image[] imgRed = new Image[6];
            Image[] imgBlue = new Image[6];
            mt = new MediaTracker(mainApp);
			
            for (int i = 0; i < 6; i++)
            {				
		imgRed[i] = createImage.getImage(this, "/images/" + strRedPieces[i], 5000);
		imgBlue[i] = createImage.getImage(this, "/images/" + strBluePieces[i], 5000);
		mt.addImage(imgRed[i], 0);
		mt.addImage(imgBlue[i], 0);
            }
			
            try
            {
		mt.waitForID(0);
            }
		
            catch (InterruptedException e)
            {
                
            }
			
            mainChessBoard.setupImages(imgRed, imgBlue);
			
	}
		
        catch (NullPointerException e)
	{
            JOptionPane.showMessageDialog(null, "Unable to load images. There should be a folder called images with all the chess pieces in it. Try downloading this programme again", "Unable to load images", JOptionPane.WARNING_MESSAGE);
            cmdNewGame.setEnabled(false);
            cmdSetNames.setEnabled(false);
	}
		
	JPanel panBottomHalf = new JPanel(new BorderLayout());
	JPanel panNameArea = new JPanel(new GridLayout(3,1,2,2));
	JPanel panPlayerOne = new JPanel();
	JPanel panPlayerTwo = new JPanel();
	JPanel panNameButton = new JPanel();
	JPanel panNewGame = new JPanel();
		
	panRoot.add(mainChessBoard, BorderLayout.NORTH);
	panRoot.add(panBottomHalf, BorderLayout.SOUTH);
	panBottomHalf.add(panNameArea, BorderLayout.WEST);
	panNameArea.add(panPlayerOne);
	panPlayerOne.add(lblPlayerOne);
	panPlayerOne.add(txtPlayerOne);
	panNameArea.add(panPlayerTwo);
	panPlayerTwo.add(lblPlayerTwo);
	panPlayerTwo.add(txtPlayerTwo);
	panNameArea.add(panNameButton);
	panNameButton.add(cmdSetNames);
	panBottomHalf.add(panNewGame, BorderLayout.SOUTH);
	panNewGame.add(cmdNewGame);
			
	panRoot.setBackground(clrBlue);
	panBottomHalf.setBackground(clrBlue);
	panNameArea.setBackground(clrBlue);
	panPlayerOne.setBackground(clrBlue);
	panPlayerTwo.setBackground(clrBlue);
	panNameButton.setBackground(clrBlue);
	panNewGame.setBackground(clrBlue);
		
	lblPlayerOne.setBackground(new Color(236,17,17)); //red
	lblPlayerTwo.setBackground(new Color(17,27,237)); //blue
		
	cmdNewGame.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		
	return panRoot;
		
    }
	
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == cmdSetNames)
	{
            if (txtPlayerOne.getText().equals(""))
            {
		txtPlayerOne.setText("shilpa");
            }
            
            if (txtPlayerTwo.getText().equals(""))
            {
		txtPlayerTwo.setText("sakshi");
            }
			
            mainChessBoard.setNames(txtPlayerOne.getText(), txtPlayerTwo.getText());
			
	}
	
        else if (e.getSource() == cmdNewGame)
	{
            mainChessBoard.newGame();
	}
		
    }
	
    @Override
    public void keyTyped(KeyEvent e)
    {
	String strBuffer = "";
	char c = e.getKeyChar();
		
	if (e.getSource() == txtPlayerOne)
	{
            strBuffer = txtPlayerOne.getText();
	}
	
        else
	{
            strBuffer = txtPlayerTwo.getText();
	}
		
	if (strBuffer.length() > 10 && !((c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)))
	{
            e.consume();
	}
		
    }
	
    @Override
    public void keyPressed(KeyEvent e)
    {
        
    }
	
    @Override
    public void keyReleased(KeyEvent e)
    {
        
    }
	
    @Override
    public void windowGainedFocus (WindowEvent e)
    {
        mainChessBoard.gotFocus();
    }
	
    @Override
    public void windowLostFocus (WindowEvent e)
    {
        
    }
}