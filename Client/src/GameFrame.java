import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.Timer;



public class GameFrame extends JFrame{

	private GamePlay gamePlay;
	private GameBoard board;
	private int[] players = {3,0,0,1,0,0};
	private MouseClickListener listener;
	

	public GameFrame(GamePlay gamePlay) {
		this.gamePlay = gamePlay;
		listener = new MouseClickListener(this);
		board = new GameBoard(this, listener, gamePlay.getSocket()); 
		
		EventQueue.invokeLater(new Runnable() {
				@Override
				public void run() { 
					JFrame frame = new JFrame("Chinese Checkers");
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setLayout(new BorderLayout());
					frame.add(board);
					frame.pack();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					frame.setResizable(false);
				}
			});
	}
	public GameBoard getBoard(){
		return board;
	}
	public void boardClicked(int x, int y){
		board.checkClick(x, y);
	}

	public void showDialog(String msg){
		
		final JDialog dialog = new JDialog(this, " ", true);
		dialog.setLocation(450, 100);
		dialog.setSize(500, 70);
		dialog.add(new JLabel(msg));
        
		Timer timer = new Timer(3000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(false);
                dialog.dispose();
            }
        });
        timer.setRepeats(false);
        timer.start();

        dialog.setVisible(true); 
	}


	public int[] getPlayers(){
		return this.players;
	}
	
}
