   //Singleton 
public class BoardArrayCreator {
	
	private static BoardArrayCreator INSTANCE = null;
	private int[][] board;
	private int[] ys;                                       //x's and y's - coordinates in array which are included in actual board
	private int[] xs;
	private int[] yp;										//for each field on board xp[i] is value of X coordinate for xs[i]
	private int[] xp;
	
	private BoardArrayCreator(){initArrays();}
	
	public static BoardArrayCreator getInstance() {
	   if(INSTANCE == null) {
		   INSTANCE = new BoardArrayCreator();
	   }
	   return INSTANCE;
	}
	
	private void initArrays(){
		int[] h = {0,1,1,2,2,2,3,3,3,3,4,4,4,4,4,4,4,4,4,4,4,4,4,5,5,5,5,5,5,5,5,5,5,5,5,6,6,6,6,6,6,6,6,6,6,6,7,7,7,7,7,7,7,7,7,7,
				   8,8,8,8,8,8,8,8,8,9,9,9,9,9,9,9,9,9,9,10,10,10,10,10,10,10,10,10,10,10,11,11,11,11,11,11,11,11,11,11,11,11,
				   12,12,12,12,12,12,12,12,12,12,12,12,12,13,13,13,13,14,14,14,15,15,16};
		int[] w = {12,11,13,10,12,14,9,11,13,15,0,2,4,6,8,10,12,14,16,18,20,22,24,1,3,5,7,9,11,13,15,17,19,21,23,2,4,6,8,10,12,14,16,18,20,22,
				   3,5,7,9,11,13,15,17,19,21,4,6,8,10,12,14,16,18,20,3,5,7,9,11,13,15,17,19,21,2,4,6,8,10,12,14,16,18,20,22,
				   1,3,5,7,9,11,13,15,17,19,21,23,0,2,4,6,8,10,12,14,16,18,20,22,24,9,11,13,15,10,12,14,11,13,12};
	
				this.ys = h;
				this.xs = w;
				this.createXPositionsArray();
				this.createYPositionsArray();
	}
	
	
	
	public void createYPositionsArray(){											//Positions - X and Y coordinates used to place 
																					//counter on actual baord image.
		
		yp = new int[ys.length];
		for( int i = 0; i < ys.length; i++){
			yp[i] = 18 + ys[i]*34;
		}
	}
	
	public void createXPositionsArray(){
		
		xp = new int[ys.length];
		for(int i =0; i < xp.length; i++){
			xp[i] = -1;
		}
		
		xp[0]=293; xp[1]=273; xp[3]=253; xp[6]=233; xp[10]=53; xp[23]=73; xp[35]=93; xp[46]=113;
		xp[56]=133; xp[65]=113; xp[75]=93; xp[86]=73; xp[98]=53; xp[111]=236; xp[115]=255; xp[118]=274;
		xp[120]=293;
		
		for( int i = 2; i < xp.length; i++){
			if(xp[i] == -1) 
				xp[i] = xp[i-1] + 40;
		}
	}
	
	public int[][] createNewPlayBoard(){										// zero - one board without counters
		board = new int[25][17];
		initArrays();
		
		for(int  i = 0; i < 25; i++){
				for(int j = 0; j < 17; j++){
					board[i][j] = 0;
				}
		}
		
		for( int  k = 0; k < ys.length; k++){
			board[xs[k]][ys[k]] = 1;
		}
		return board;
	}
	
	
	
	public int[][] setUpCounters(int[] players) throws Exception{									//2 is the top corner 
																									//3 is the first on the right
		this.createNewPlayBoard();													//4 is ...
		if(players.length != 6)
			throw new InvalidDataException("Wrong array size");										//top corner is occupied by player 0 
																									//first on the right by player 1
		if(players[0] != 0 ){																		//...
			for(int i = 0; i < 10; i++ ){
				board[xs[i]][ys[i]] = 2;
			}
		}if(players[1] != 0 ){
			
			board[18][4] = 3; board[20][4] = 3; board[22][4] = 3; board[24][4] = 3;
			board[19][5] = 3; board[21][5] = 3; board[23][5] = 3; 
			board[20][6] = 3;board[22][6] = 3;
			board[21][7] = 3;
		}if(players[2] != 0 ){
			board[18][12] = 4; board[20][12] = 4; board[22][12] = 4; board[24][12] = 4;
			board[19][11] = 4; board[21][11] = 4; board[23][11] = 4; 
			board[20][10] = 4;board[22][10] = 4;
			board[21][9] = 4;
		}if(players[3] != 0 ){
			for(int i = ys.length-10; i < ys.length; i++ ){
				board[xs[i]][ ys[i]] = 5;
			}
		}if(players[4] != 0 ){
			board[0][12] = 6; board[2][12] = 6; board[4][12] = 6; board[6][12] = 6;
			board[1][11] = 6; board[3][11] = 6; board[5][11] = 6; 
			board[2][10] = 6;board[4][10] = 6;
			board[3][9] = 6;
		}if(players[5] != 0 ){
			board[0][4] = 7; board[2][4] = 7; board[4][4] = 7; board[6][4]= 7;
			board[1][5] = 7; board[3][5] = 7; board[5][5] = 7; 
			board[2][6] = 7;board[4][6] = 7;
			board[3][7] = 7;
		}
		
		
		for(int y=0; y< 17; y++){
			for(int x=0; x<25; x++)
			{
				System.out.printf("%d", board[x][y]);
			}
			
			System.out.println("");
		}
		
		return board;
		
		
	}
	
	
	
	public int getXCoordinate(int i, int j){
		
		int k = 0;
		while(((xs[k]!=i) || (ys[k]!= j)) && (k<xs.length))
			k++;
		if(k==xs.length)
			return -1;
		return xp[k];				
	}
	
	public int getYCoordinate(int i, int j){
		int k = 0;
		while(((xs[k]!=i) || (ys[k]!= j)) && (k<xs.length))
			k++;
		if(k==ys.length)
			return -1;
		return yp[k];				
	}
	
	public int getNearestFieldCenterX(int k){
		
		for(int i = 0; i < xp.length; i++){
			if(Math.abs((xp[i]+20) - k) < 20){
				return (xp[i] );
			}
		}
		return -1;
	}
	
	public int getNearestFieldCenterY(int k){
		
		for(int i = 0; i < yp.length; i++){
			if(Math.abs((yp[i]+20) - k) < 20){
				return (yp[i] );
			}
		}
		return -1;
	}
	
	public int getClickedFieldID(int clickX, int clickY){
		
		System.out.println(clickX + " " + clickY);
		int dx = 0, dy = 0;
		for(int i = 0; i < xp.length; i++){
			dx = clickX - xp[i];
			dy = clickY - yp[i];
			if(dy>0 && dy<40 && dx>0 && dx<40){
				System.out.println(i);
				return i;
			}
		}
		
		return -1;
	}
	
	public int getXpositionfromID(int i){
		return xp[i];
	}
	
	public int getYpositionfromID(int i){
		return yp[i];
	}
	
	public int getBoardXfromID(int i){
		return xs[i];
	}
	
	public int getBoardYfromID(int i){
		return ys[i];
	}
	
	public boolean hasCounter(int i){
		if(board[xs[i]][ys[i]] > 1)
			return true;
		return false;
	}
	
	public boolean fieldCheck(int x, int y){
		for(int i = 0; i < xp.length; i++){
			if(xp[i] == x && yp[i] == y){
				return true;
			}
		}
		
		return false;
	}
}
