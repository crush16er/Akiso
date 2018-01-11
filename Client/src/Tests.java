import static org.junit.Assert.*;

import org.junit.Test;

public class Tests {
	
//-------------------------------------------Testing BoardArrayCreator------------------------------------
	@Test
	public void testNewBoardCreate() {
		BoardArrayCreator b = BoardArrayCreator.getInstance();
		int[][] board = b.createNewPlayBoard();
		
		assertEquals(board[12][14], 1);
		assertEquals(board[15][10], 0);
		assertEquals(board[4][8], 1);
	}
	
	
	@Test(expected = InvalidDataException.class)
	public void testInvalidDataException() throws Exception {
		BoardArrayCreator b = BoardArrayCreator.getInstance();
		int[] players = {0,0,0};
		b.setUpCounters(players);
	}

	@Test
	public void testPlayerBoardCreate() {
		BoardArrayCreator b = BoardArrayCreator.getInstance();
		int[][] board = b.createNewPlayBoard();
		int[] players = {2,0,1,0,0,0};
		try {
			board = b.setUpCounters(players);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(board[12][14], 1);
		assertEquals(board[19][11], 4);
		assertEquals(board[9][3], 2);
	}
	
	@Test
	public void testCreatingCoordinates() {
		BoardArrayCreator b = BoardArrayCreator.getInstance();
		int[][] board = b.createNewPlayBoard();
		int[] players = {2,0,1,0,0,0};
		try {
			board = b.setUpCounters(players);
		} catch (Exception e) {
			e.printStackTrace();
		}
		int x = b.getXCoordinate(12, 0);
		System.out.println(x);
		assertEquals(x, 293);
		x = b.getXCoordinate(4, 4);
		
		assertEquals(x, 133);
	}
	
	@Test
	public void testGettingClickedFieldID(){
		BoardArrayCreator b = BoardArrayCreator.getInstance();
		int[][] board = b.createNewPlayBoard();
		assertEquals(b.getClickedFieldID(328, 339), 70);
		assertEquals(b.getClickedFieldID(366, 415), 93);
		assertEquals(b.getClickedFieldID(172, 204), 25);	
		}
	
	@Test 
	public void testGettingXfromID(){
		BoardArrayCreator b = BoardArrayCreator.getInstance();
		int[][] board = b.createNewPlayBoard();
		assertEquals(b.getXpositionfromID(98), 53);
		assertEquals(b.getXpositionfromID(66), 153);
		assertEquals(b.getXpositionfromID(115), 255);
	}
	
	@Test 
	public void testHasCounter() throws Exception{
		int[] players = {2,3,4,4,4,5};
		BoardArrayCreator b = BoardArrayCreator.getInstance();
		int[][] board = b.createNewPlayBoard();
		b.setUpCounters(players);
		assertTrue(b.hasCounter(87));
		assertTrue(b.hasCounter(45));
		assertFalse(b.hasCounter(51));
		
	}
	
	@Test 
	public void testFieldCheck() {
		BoardArrayCreator b = BoardArrayCreator.getInstance();
		int[][] board = b.createNewPlayBoard();
		assertTrue(b.fieldCheck(253, 86));
		assertFalse(b.fieldCheck(260, 26));
		
	}
	
// -----------------------------------------------End of BoardArrayCreator-----------------------------------------------------

//------------------------------------------------GameBoard Testing------------------------------------------------------------
	
	@Test 
	public void testBoardUpdate() throws Exception {
		int[] k = {2,0,0,1,0,0};
		Board.getInstance().setUp(k);
		BoardArrayCreator.getInstance().setUpCounters(k);
		GameFrame gf = new GameFrame(new GamePlay());
		GameBoard gb = new GameBoard(gf, new MouseClickListener(gf), ServerSockett.getInstance() );
		
		Board.getInstance().setUp(k);
		gb.setPlayers(k);
		gb.setBoardArray(Board.getInstance());
	
		int[][] b = gb.getBoardArray().getCurrentBoard();
		
		System.out.println("im swapping " + b[12][2] + " to 1 and " + b[9][7] + " to 2\n\n\n\n\n\n\n");
		b[12][2] = 1;
		b[9][7] = 2;
		gb.receiveServerResponse(b);
		int[][] b2 = gb.getBoardArray().getCurrentBoard();
		assertEquals(b[12][8],b2[12][8]);
		assertEquals(b[9][7],b2[9][7]);
		assertEquals(b[12][6],b2[12][6]);
		
	}
	
	
}

