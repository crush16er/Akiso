import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;


public class GameBoard extends JPanel{
		
		private GameFrame parentFrame;
		private ServerSockett socket;
		private PlayerTypeMouseListener playersSetUpMouseListener;
		private MouseClickListener countersMouseListener;
		private Board boardArray;
		private static int BOARD_SIZE = 620;
		private ImageIcon bkg;
		private SpringLayout boardLayout;
		private ArrayList<JButton> cornerButtons;
		private JButton savePlayersButton;
		private JButton endTurnButton;
		private String currentMoveStage = MoveStage.NONE;
		private ImageIcon grn, blk, wht, yel, blu, red, high;
		private ArrayList<ImageIcon> icons;
		private ImageIcon boardBKG, star; 
		private JLabel l;
		private JLabel highLightLabel;
		private JLabel starLabel;
		private int[] x,y,colors;
		private int[] players;
		private int counterX, counterY, newPlaceX, newPlaceY;
		private int userColor;
		private User user;
		
		
		public GameBoard(GameFrame frame, MouseClickListener listener, ServerSockett sockett){
			this.parentFrame = frame;
			this.countersMouseListener = listener;
			this.players = parentFrame.getPlayers();
			this.socket = sockett;
			initImageIcons();
			
			user = User.getInstance();
			if(user.startedNewGame()){
				showOptionsMenu();	
			}else{
				try {
					this.initJoinedGame();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		public void setBoardArray(Board newArray){
			this.boardArray = newArray;
		}
		
		public void setPlayers(int[]k){
			this.players = k;
		}
		
		public Board getBoardArray(){
			return this.boardArray;
		}
		
		public void initImageIcons() {
			
			icons = new ArrayList<ImageIcon>();
			grn = new ImageIcon(("images/o_green_34.png"));
			blk = new ImageIcon(("images/o_black_34.png"));
			wht = new ImageIcon(("images/o_white_34.png"));
			yel = new ImageIcon(("images/o_yellow_34.png"));
			blu = new ImageIcon(("images/o_blue_34.png"));
			red = new ImageIcon(("images/o_red_34.png"));
			high = new ImageIcon(("images/o_high.png"));
			star = new ImageIcon(("images/star.png"));
			
			icons.add(0,null);
			icons.add(1, null);
			icons.add(2, grn);icons.add(3, blk);icons.add(4, wht);icons.add(5, yel);icons.add(6, blu);
			icons.add(7, red);

			boardBKG = new ImageIcon(("images/board_620_with_counters.jpg"));
			
			highLightLabel = new JLabel(high);
			highLightLabel.setSize(40,40);
			starLabel = new JLabel(star);
			starLabel.setSize(40,40);

		} 
		
//--------------------------------SETTING UP GAME OPTIONS-------------------------------------------------------------------------		
		public void showOptionsMenu(){
			
			boardLayout = new SpringLayout();
			setLayout(boardLayout);
			cornerButtons = new ArrayList<JButton>() ;
			playersSetUpMouseListener = new PlayerTypeMouseListener();
			initImageIcons();
			bkg = boardBKG; 
			initOptionsButtons();
		}
		
		
		public void initOptionsButtons(){

             savePlayersButton = new JButton("GO");
             savePlayersButton.addMouseListener(playersSetUpMouseListener);
             boardLayout.putConstraint(SpringLayout.SOUTH, savePlayersButton, -30, SpringLayout.SOUTH, this);
         	 boardLayout.putConstraint(SpringLayout.EAST, savePlayersButton, -30, SpringLayout.EAST, this);
         	 add(savePlayersButton);

             for(int i = 0; i < 6; i++){
            	 cornerButtons.add(new JButton(getButtonText(players[i])));
            	 cornerButtons.get(i).addMouseListener(playersSetUpMouseListener);
             }
           
            boardLayout.putConstraint(SpringLayout.NORTH, cornerButtons.get(0), 100, SpringLayout.NORTH, this);
         	boardLayout.putConstraint(SpringLayout.WEST, cornerButtons.get(0), 282, SpringLayout.WEST, this);
         	add(cornerButtons.get(0));
         	 
         	boardLayout.putConstraint(SpringLayout.NORTH, cornerButtons.get(1), 190, SpringLayout.NORTH, this);
        	boardLayout.putConstraint(SpringLayout.WEST, cornerButtons.get(1), 460, SpringLayout.WEST, this);
        	add(cornerButtons.get(1));
             
        	boardLayout.putConstraint(SpringLayout.NORTH, cornerButtons.get(2), 406, SpringLayout.NORTH, this);
        	boardLayout.putConstraint(SpringLayout.WEST, cornerButtons.get(2), 459, SpringLayout.WEST, this);
        	add(cornerButtons.get(2));
        	
        	boardLayout.putConstraint(SpringLayout.NORTH, cornerButtons.get(3), 510, SpringLayout.NORTH, this);
        	boardLayout.putConstraint(SpringLayout.WEST, cornerButtons.get(3), 283, SpringLayout.WEST, this);
        	add(cornerButtons.get(3));
        	
        	boardLayout.putConstraint(SpringLayout.NORTH, cornerButtons.get(4), 407, SpringLayout.NORTH, this);
        	boardLayout.putConstraint(SpringLayout.WEST, cornerButtons.get(4), 105, SpringLayout.WEST, this);
        	add(cornerButtons.get(4));
        	
        	boardLayout.putConstraint(SpringLayout.NORTH, cornerButtons.get(5), 190, SpringLayout.NORTH, this);
        	boardLayout.putConstraint(SpringLayout.WEST, cornerButtons.get(5), 106, SpringLayout.WEST, this);
        	add(cornerButtons.get(5));
	 
		}

		private String getButtonText(int n){
			if(n == 0) 
				return "NONE";
			if(n == 1)
				return "YOU";
			if(n == 2 )
				return "PLAYER";
			return "BOT";
		}
		
		private void changePlayer(int id){
			if(players[id] == 3) 
				players[id] = 0;
			else 
				players[id]++;
			cornerButtons.get(id).setText(getButtonText(players[id]));
		}
	
		public class PlayerTypeMouseListener implements MouseListener {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				if(arg0.getSource() == cornerButtons.get(0)){
					changePlayer(0);
				} else if(arg0.getSource() == cornerButtons.get(1)){
					changePlayer(1);
				} else if(arg0.getSource() == cornerButtons.get(2)){
					changePlayer(2);
				} else if(arg0.getSource() == cornerButtons.get(3)){
					changePlayer(3);
				} else if(arg0.getSource() == cornerButtons.get(4)){
					changePlayer(4);
				} else if(arg0.getSource() == cornerButtons.get(5)){
					changePlayer(5);
				}else if(arg0.getSource() == savePlayersButton){
					
					if(correctPlayersSet(players)){
						remove(savePlayersButton);
						try {
							Board.getInstance().setUp(players);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						for(int i = 0; i < 6; i++)
							cornerButtons.get(i).setVisible(false);;
						repaint();
						try {
							startGame();
						} catch (Exception e) {
							e.printStackTrace();
						}
						
					} else{
						parentFrame.showDialog("Please, put players in correct corners.");
					}
				}
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {}

			@Override
			public void mouseExited(MouseEvent arg0) {}

			@Override
			public void mousePressed(MouseEvent arg0) {}

			@Override
			public void mouseReleased(MouseEvent arg0) {}
			
		}
		
		public boolean correctPlayersSet(int[] players){					// checking if players were set up correctly
			
			int n = 0;
			int corner = 0;
			for(int i = 0; i < players.length; i++){
				if(players[i] == 1)
					n++;
					corner = i;
			}
			if(n != 1)
				return false;
			
			int[] avaliableSets = {100100, 0100100, 001001, 110110, 011011, 101101, 010101, 101010, 111111};
			int set = 0;
			for( int i = 0; i < players.length; i++){
				set *= 10;
				if(players[i]>0){
					set += 1;
				}
			}
			
			for( int i = 0; i < avaliableSets.length; i++){
				if(set == avaliableSets[i]){
					userColor = corner;
					
					return true;
				}
			}
			return false;
		}
		
//---------------------------------Starting actual game play------------------------------------------------------------------		
		
		public void initJoinedGame(){
			userColor = socket.getCornerNumber();
			this.boardArray = socket.getBoardFromServer();
			this.players = socket.getPlayers();
			try {
				startGame();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public void setUpCountersFromArray() throws Exception{
			
			x = boardArray.getXs();
			y = boardArray.getYs();
			colors = boardArray.getColors();
			this.setLayout(null);
			for(int i = 0; i < x.length; i++){
					l = new JLabel(icons.get(colors[i]));
					this.add(l);
					l.setSize(40, 40);
					l.setLocation(x[i], y[i]);	
			}	
			
			counterX = -1;
			counterY = -1;
			newPlaceX = -1;
			newPlaceY = -1;
		}
		
		
		public void startGame() throws Exception{
			
			bkg = new ImageIcon(("images/board_621.jpg"));
			endTurnButton = new JButton("END");
			boardArray = Board.getInstance();
			this.removeMouseListener(playersSetUpMouseListener);
			this.addMouseListener(countersMouseListener);
			if(!User.getInstance().startedNewGame()){
				boardArray.setCurrentBoard(this.socket.getBoardFromServer().getCurrentBoard());
			}
			l = new JLabel(grn);
			setUpCountersFromArray();
			this.add(endTurnButton);
			endTurnButton.setLocation(530, 580);
			endTurnButton.setSize(60,20);
			endTurnButton.addActionListener(new EndTurnListener());
			currentMoveStage = MoveStage.NONE;
		}
		
		public class EndTurnListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				endUserTurn();
			}
			
		}
		
		public void checkClick(int clickX, int clickY){
			
			int i = boardArray.getClickedFieldID(clickX,clickY);
			System.out.println("one");
			if(i>-1){
				
				if(boardArray.hasCounter(i)){
					
					if(boardArray.getColorAtIndex(i) == userColor){
						
					System.out.println("two");
					if(this.currentMoveStage == MoveStage.IN_TURN ){
						System.out.println("three");
						drawHighlight(boardArray.getXpositionfromID(i),boardArray.getYpositionfromID(i));
						counterX = boardArray.getBoardXfromID(i);
						counterY = boardArray.getBoardYfromID(i);
						currentMoveStage = MoveStage.COUNTER_CHOSEN;
					} else if(this.currentMoveStage == MoveStage.COUNTER_CHOSEN){
						if(counterX == boardArray.getBoardXfromID(i) && counterY == boardArray.getBoardYfromID(i)){
							removeHighlight();
							counterX = -100;
							counterY = -1;
							currentMoveStage = MoveStage.IN_TURN;
						}else{
							drawHighlight(boardArray.getXpositionfromID(i),boardArray.getYpositionfromID(i));
							counterX = boardArray.getBoardXfromID(i);
							counterY = boardArray.getBoardYfromID(i);
						}
					}
					}
					
				}else{
					if(this.currentMoveStage == MoveStage.COUNTER_CHOSEN){
						drawStar(boardArray.getXpositionfromID(i),boardArray.getYpositionfromID(i));
						currentMoveStage = MoveStage.COUNTER_PLACED;
						newPlaceX = boardArray.getBoardXfromID(i);
						newPlaceY = boardArray.getBoardYfromID(i);
						callServer(counterX, counterY,newPlaceX, newPlaceY );
					}
				}
			}
		}
//-----------------------------------------------------------------------------------------------------------		
		public void drawHighlight(int x, int y){
			this.add(highLightLabel);
			this.highLightLabel.setVisible(true);
			highLightLabel.setLocation(x, y);
		}
		
		public void drawStar(int x, int y){
			this.add(starLabel);
			this.starLabel.setVisible(true);
			starLabel.setLocation(x, y);
		}
		
		public void removeHighlight(){
			this.highLightLabel.setVisible(false);
		}
		
		public void removeStar(){
			this.starLabel.setVisible(false);
		}
//-------------------------------------------------------------------------------------------------------------------		
		public void callServer(int oldX, int oldY, int newX, int newY){
			socket.sendMoveParamsToServer(boardArray.getCurrentBoard(), oldX, oldY, newX, newY);
		}
		
		public void receiveServerResponse(int[][] newBoard){
			upDateBoard(newBoard);
			int[][] b = boardArray.getCurrentBoard();
			
		}
		
		private void upDateBoard(int[][] newBoard){
			Board.getInstance().upDateCounters(newBoard);
			boardArray.setCurrentBoard(newBoard);
			x = boardArray.getXs();
			y = boardArray.getYs();
			colors = boardArray.getColors();
		}
		
		public void waitForOtherPlaersMoves(){
			this.currentMoveStage = MoveStage.NONE;
		}
		
		public void startUserTurn(){
			this.currentMoveStage = MoveStage.IN_TURN;
		}
		public void endUserTurn(){
			System.out.println("Ending turn");
			waitForOtherPlaersMoves();
			this.socket.endUsersTurn();
			
		}
//-----------------------------------------------------------------------------------------------------------------------------------------		
		@Override
		public Dimension getPreferredSize() {
			return new Dimension(BOARD_SIZE, BOARD_SIZE);
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(bkg.getImage(), 0, 0, null);
		}
	}