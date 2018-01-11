import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StartDialog extends JDialog {
	
	GamePlay gamePlay;
	JTextField textField ;
	public StartDialog(GamePlay gamePlay){
		//super(surface, "chinese checkers");
		
		this.gamePlay = gamePlay;
		JPanel messagePane = new JPanel();
		messagePane.add(new JLabel("CHINESE CHECKERS"));
		setSize(400,150);
		setLocationRelativeTo(null);
		getContentPane().add(messagePane, BorderLayout.PAGE_START);
		
		JPanel buttonPane = new JPanel();
		JButton button = new JButton("Play");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		buttonPane.add(button);
		button.addActionListener(new NewGameActionListener());
		getContentPane().add(buttonPane, BorderLayout.CENTER);
		
		JButton button2 = new JButton("Join port");
		button2.addActionListener(new PortActionListener());
		textField = new JTextField("");
		textField.setPreferredSize(new Dimension(40,24));
		JPanel newPortPanel = new JPanel();
		newPortPanel.add(textField);
		newPortPanel.add(button2);
		
		getContentPane().add(newPortPanel, BorderLayout.PAGE_END);

		setVisible(true);

		
	}
	
	class NewGameActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			User.getInstance().isStartingNewGame();
			dispose();
			gamePlay.startNewGame(); 
			
			
		}
	}
	
	class PortActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int port = Integer.parseInt(textField.getText());
			if(ServerSockett.getInstance().checkPort(port)){
				ServerSockett.getInstance().setPort(port);
				User.getInstance().isJoiningGameOnPort(port);
				gamePlay.startNewGame();
			}
			
		}
	}
	
	

}
