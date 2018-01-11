public class Board {
	
	private static Board INSTANCE;
	private int[] players;
	private int[][] currentBoard;
	private int[] curX;
	private int[] curY;
	private int[] curCol;
	
	private int playersCount;
	private BoardArrayCreator b;
	
	private Board(){};
	public static Board getInstance(){
		if(INSTANCE == null){
			INSTANCE = new Board();
		}	
		return INSTANCE;
	}
	

	
	public void setUp (int players[]) throws Exception{

		this.players = players;
		playersCount = 0;
		for(int i = 0; i<6; i++){
			if(players[i] > 0)
				playersCount++;
		}
		curX = new int[playersCount*10];                                                  //+1?????
		curY = new int[playersCount*10];
		curCol = new int[playersCount*10];
		b = BoardArrayCreator.getInstance();
		currentBoard = b.setUpCounters(players);
		
	}
	
	
	
	public int[] getPlayers() {
		return players;
	}
	public void setPlayers(int[] players) {
		this.players = players;
	}
	public int[][] getCurrentBoard() {
		return currentBoard;
	}
	public void setCurrentBoard(int[][] currentBoard) {
		this.currentBoard = currentBoard;
		setCurrentCountersPositions();
	}
	
	
	public void upDateCounters(int[][] newBoard){
		BoardArrayCreator.getInstance();
		currentBoard = newBoard;
		setCurrentCountersPositions();
	}
	
	public void setCurrentCountersPositions(){
		
		int k = 0;
		for(int i = 0; i < 25; i++) {
			for(int j = 0; j < 17; j++){
				
				System.out.println("curX  len: " + curX.length + " curY len: " + curY.length + " k is: " + k + " cur board[i][j]: " + currentBoard[i][j] );
				
				if(currentBoard[i][j] > 1){
					System.out.println("inside");
					curX[k] = b.getXCoordinate(i, j);
					curY[k] = b.getYCoordinate(i, j);
					curCol[k] = currentBoard[i][j];
					k++;
				}
			}
		}
	}
	
	public int[] getXs(){
		setCurrentCountersPositions();
		return curX;
	}
	
	public int[] getYs(){
		setCurrentCountersPositions();
		return curY;
	}
	
	public int[] getColors(){
		setCurrentCountersPositions();
		return curCol;
	}
	
	public int getClickedFieldCenterX(int x){
		return(b.getNearestFieldCenterX(x));
	}
	
	public int getClickedFieldCenterY(int y){
		return(b.getNearestFieldCenterY(y));
	}
	
	public boolean fieldExists(int x, int y){
		return b.fieldCheck(x, y);
	}
	
	public int getClickedFieldID(int x, int y){
		return b.getClickedFieldID(x, y);
	}
	
	public int getXpositionfromID(int i){
		return b.getXpositionfromID(i);
	}
	
	public int getYpositionfromID(int i){
		return b.getYpositionfromID(i);
	}
	
	public int getBoardXfromID(int i){
		return b.getBoardXfromID(i);
	}
	
	

	public int getBoardYfromID(int i){
		return b.getBoardYfromID(i);
	}
	
	public boolean hasCounter(int i){
		return b.hasCounter(i);
	}
	
	public int getColorAtIndex(int i){
		return( currentBoard[getBoardXfromID(i)][getBoardYfromID(i)]);
		
	}
	
}
