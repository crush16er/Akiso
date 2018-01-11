import static org.junit.Assert.*;

import org.junit.Test;

public class BotTest {

	@Test
	public void testRotate()
	{
		Bot bot = new Bot();
		
		
		
		int[][] board = new int [25][17];
		
		for(int i = 0; i < 25; i++)
		{
			for(int j = 0; j < 17; j++)
			{
				board[i][j]=0;
			}
		}

		board[12][0] = 2;
		board[11][1] = 2;
		board[13][1] = 2;
		board[10][2] = 1;
		board[12][2] = 2;
		board[14][2] = 2;
		board[9][3] = 2;
		board[11][3] = 2;
		board[13][3] = 2;
		board[15][3] = 2;
		board[8][6] = 1;
		board[12][8] = 1;
		board[8][4] = 1;
		board[9][5] = 1;
		board[10][6] = 2;
		board[11][7] = 1;
		board[10][4] = 1;
		board[11][5] = 1;
		board[12][6] = 1;
		board[12][4] = 1;
		board[13][5] = 1;
		board[14][4] = 1;
		board[9][7] = 1;
		board[9][9] = 1;
		board[9][11] = 1;
		board[9][13] = 1;
		board[10][8] = 1;
		board[10][10] = 1;
		board[10][12] = 1;
		board[10][8] = 1;
		board[10][14] = 1;
		board[12][10] = 1;
		board[12][12] = 1;
		board[12][14] = 1;
		board[12][16] = 1;
		board[13][7] = 1;
		board[13][9] = 1;
		board[13][11] = 1;
		board[13][13] = 1;
		board[13][15] = 1;
		board[11][9] = 1;
		board[11][11] = 1;
		board[11][13] = 1;
		board[11][15] = 1;
		board[14][6] = 1;
		board[14][8] = 1;
		board[14][10] = 1;
		board[14][12] = 1;
		board[14][14] = 1;
		board[15][5] = 1;
		board[15][7] = 1;
		board[15][9] = 1;
		board[15][11] = 1;
		board[15][13] = 1;
		board[7][5] = 1;
		board[7][7] = 1;
		board[7][9] = 1;
		board[7][11] = 1;
		board[8][12] = 1;
		board[8][10] = 1;
		board[8][8] = 1;
		board[6][6] = 1;
		board[6][8] = 1;
		board[6][10] = 1;
		board[5][7] = 1;
		board[5][9] = 1;
		board[4][8] = 1;
		board[16][4] = 1;
		board[16][6] = 1;
		board[16][8] = 1;
		board[16][10] = 1;
		board[16][12] = 1;
		board[17][5] = 1;
		board[17][7] = 1;
		board[17][9] = 1;
		board[17][11] = 1;
		board[18][6] = 1;
		board[18][8] = 1;
		board[18][10] = 1;
		board[19][7] = 1;
		board[19][9] = 1;
		board[20][8] = 1;
		board[0][4] = 7;
		board[2][4] = 7;
		board[4][4] = 7;
		board[6][4] = 7;
		board[1][5] = 7;
		board[3][5] = 7;
		board[5][5] = 7;
		board[2][6] = 7;
		board[4][6] = 7;
		board[3][7] = 7;
		board[18][12] = 1;
		board[20][12] = 1;
		board[22][12] = 1;
		board[24][12] = 1;
		board[19][11] = 1;
		board[21][11] = 1;
		board[23][11] = 1;
		board[20][10] = 1;
		board[22][10] = 1;
		board[21][9] = 1;
		
		
		
		
		
		bot.board = board;
		//board[5][5]=2; ...
		
		for(int y=0; y< 17; y++)
		{
			for(int x=0; x<25; x++)
			{
				if(bot.board[x][y]==0)
				{
					System.out.printf(" ");
				}
				else
				{
					System.out.printf("%d", bot.board[x][y]);
				}
				
			}
			
			System.out.println("");
		}
		
		bot.rotate(6);
		
		
		
		System.out.println("");
		/*for(int y=0; y< 17; y++)
		{
			for(int x=0; x<25; x++)
			{
				System.out.printf("%d", bot.board[x][y]);
			}
			
			System.out.println("");
		}*/
		
		bot.rotate(6);
		
		/*System.out.println("");
>>>>>>> 4504a9f22c48f45f3238c054aad7f03a5ec8d74e
		
		for(int y=0; y< 17; y++)
		{
			for(int x=0; x<25; x++)
			{
<<<<<<< HEAD
				if(bot.board[x][y]==0)
				{
					System.out.printf(" ");
				}
				else
				{
					System.out.printf("%d", bot.board[x][y]);
				}
				
			}
			
			System.out.println("");
		}
		
		/*for(int y=0; y< 17; y++)
		{
			for(int x=0; x<25; x++)
			{
=======
>>>>>>> 4504a9f22c48f45f3238c054aad7f03a5ec8d74e
				System.out.printf("%d", bot.board[x][y]);
			}
			
			System.out.println("");
		}*/
		
		
		for(int y=0; y< 17; y++)
		{
			for(int x=0; x<25; x++)
			{
				assertEquals(board[x][y], bot.board[x][y]);
			}
		}
		
	}
	
	@Test
	public void testBotMove()
	{
		Bot bot = new Bot();
		
		int[][] board = new int [25][17];
		
		for(int i = 0; i < 25; i++)
		{
			for(int j = 0; j < 17; j++)
			{
				board[i][j]=0;
			}
		}

		board[12][0] = 2;
		board[11][1] = 2;
		board[13][1] = 2;
		board[10][2] = 1;
		board[12][2] = 2;
		board[14][2] = 2;
		board[9][3] = 2;
		board[11][3] = 2;
		board[13][3] = 2;
		board[15][3] = 2;
		board[8][6] = 1;
		board[12][8] = 1;
		board[8][4] = 1;
		board[9][5] = 1;
		board[10][6] = 2;
		board[11][7] = 1;
		board[10][4] = 1;
		board[11][5] = 1;
		board[12][6] = 1;
		board[12][4] = 1;
		board[13][5] = 1;
		board[14][4] = 1;
		board[9][7] = 1;
		board[9][9] = 1;
		board[9][11] = 1;
		board[9][13] = 1;
		board[10][8] = 1;
		board[10][10] = 1;
		board[10][12] = 1;
		board[10][8] = 1;
		board[10][14] = 1;
		board[12][10] = 1;
		board[12][12] = 1;
		board[12][14] = 1;
		board[12][16] = 1;
		board[13][7] = 1;
		board[13][9] = 1;
		board[13][11] = 1;
		board[13][13] = 1;
		board[13][15] = 1;
		board[11][9] = 1;
		board[11][11] = 1;
		board[11][13] = 1;
		board[11][15] = 1;
		board[14][6] = 1;
		board[14][8] = 1;
		board[14][10] = 1;
		board[14][12] = 1;
		board[14][14] = 1;
		board[15][5] = 1;
		board[15][7] = 1;
		board[15][9] = 1;
		board[15][11] = 1;
		board[15][13] = 1;
		board[7][5] = 1;
		board[7][7] = 1;
		board[7][9] = 1;
		board[7][11] = 1;
		board[8][12] = 1;
		board[8][10] = 1;
		board[8][8] = 1;
		board[6][6] = 1;
		board[6][8] = 1;
		board[6][10] = 1;
		board[5][7] = 1;
		board[5][9] = 1;
		board[4][8] = 1;
		board[16][4] = 1;
		board[16][6] = 1;
		board[16][8] = 1;
		board[16][10] = 1;
		board[16][12] = 1;
		board[17][5] = 1;
		board[17][7] = 1;
		board[17][9] = 1;
		board[17][11] = 1;
		board[18][6] = 1;
		board[18][8] = 1;
		board[18][10] = 1;
		board[19][7] = 1;
		board[19][9] = 1;
		board[20][8] = 1;
		board[0][4] = 7;
		board[2][4] = 7;
		board[4][4] = 7;
		board[6][4] = 7;
		board[1][5] = 7;
		board[3][5] = 7;
		board[5][5] = 7;
		board[2][6] = 7;
		board[4][6] = 7;
		board[3][7] = 7;
		board[18][12] = 1;
		board[20][12] = 1;
		board[22][12] = 1;
		board[24][12] = 1;
		board[19][11] = 1;
		board[21][11] = 1;
		board[23][11] = 1;
		board[20][10] = 1;
		board[22][10] = 1;
		board[21][9] = 1;
		
		bot.board = board;
		
		for(int i=0; i<116; i++)
		{
			bot.doMove(2);
		}
		
		for(int y=0; y< 17; y++)
		{
			for(int x=0; x<25; x++)
			{
				if(bot.board[x][y]==0)
				{
					System.out.printf("_");
				}
				else
				{
					if(bot.board[x][y] == 2)
					{
						bot.board[x][y] = 5;
					}
					System.out.printf("%d", bot.board[x][y]);
				}
				
			}
			
			System.out.println("");
		}
		
		/*board[12][0] = 2;
		board[11][1] = 2;
		board[13][1] = 2;
		board[10][2] = 2;
		board[12][2] = 2;
		board[14][2] = 2;
		board[9][3] = 2;
		board[11][3] = 2;
		board[13][3] = 2;
		board[15][3] = 2;
		
		bot.board = board;*/
		
		/*for(int i=0; i<1000; i++)
		{
			bot.doMove(5);
			bot.doMove(2);
		}*/
		
		for(int i=0; i<119; i++)
		{
			bot.doMove(5);
			bot.doMove(7);
		}
		
		for(int y=0; y< 17; y++)
		{
			for(int x=0; x<25; x++)
			{
				if(bot.board[x][y]==0)
				{
					System.out.printf(" ");
				}
				else
				{
					System.out.printf("%d", bot.board[x][y]);
					
				}
				
			}
			
			System.out.println("");
		}
		
		//assertEquals(bot.board[12][0], 1);
		assertEquals(bot.board[12][2], 5);
		
		assertEquals(bot.board[18][12], 7);
		assertEquals(bot.board[20][12], 7);
		assertEquals(bot.board[22][12], 7);
		assertEquals(bot.board[24][12], 7);
		assertEquals(bot.board[19][11], 7);
		assertEquals(bot.board[21][11], 7);
		assertEquals(bot.board[23][11], 7);
		assertEquals(bot.board[20][10], 7);
		assertEquals(bot.board[22][10], 7);
		assertEquals(bot.board[21][9], 7);
		
		for(int y=0; y< 17; y++)
		{
			for(int x=0; x<25; x++)
			{
				
				if(bot.board[x][y]!=0)
				{
					if(bot.board[x][y] == 7)
					{
						bot.board[x][y] = 4;
					}
				}
				
			}
		}
		
		for(int i=0; i<120; i++)
		{
			bot.doMove(4);
		}
		
		
		
		
		assertEquals(bot.board[3][7], 4);
		
		
		
		
		
		
		//test 6 and 3
		
		board[3][9] = 6;
		board[2][10] = 6;
		board[4][10] = 6;
		board[1][11] = 6;
		board[3][11] = 6;
		board[5][11] = 6;
		board[0][12] = 6;
		board[2][12] = 6;
		board[4][12] = 6;
		board[6][12] = 6;
		

		board[18][4] = 1;
		board[20][4] = 1;
		board[22][4] = 1;
		board[24][4] = 1;
		board[19][5] = 1;
		board[21][5] = 1;
		board[23][5] = 1;
		board[20][6] = 1;
		board[22][6] = 1;
		board[21][7] = 1;
		
		bot.board = board;
		
		for(int y=0; y< 17; y++)
		{
			for(int x=0; x<25; x++)
			{
				if(bot.board[x][y]==0)
				{
					System.out.printf(" ");
				}
				else
				{
					System.out.printf("%d", bot.board[x][y]);
					
				}
				
			}
			
			System.out.println("");
		}
		
		for(int i=0; i<120; i++)
		{
			bot.doMove(6);
		}
		
		
		
		
		assertEquals(bot.board[21][7], 6);
		
		
		for(int y=0; y< 17; y++)
		{
			for(int x=0; x<25; x++)
			{
				
				if(bot.board[x][y]!=0)
				{
					if(bot.board[x][y] == 6)
					{
						bot.board[x][y] = 3;
					}
				}
				
			}
		}
		
		for(int i=0; i<120; i++)
		{
			bot.doMove(3);
		}
		
		
		
		
		assertEquals(bot.board[6][12], 3);
		
		for(int y=0; y< 17; y++)
		{
			for(int x=0; x<25; x++)
			{
				if(bot.board[x][y]==0)
				{
					System.out.printf(" ");
				}
				else
				{
					System.out.printf("%d", bot.board[x][y]);
					
				}
				
			}
			
			System.out.println("");
		}
	}
	
	
	
	@Test
	public void testBotCountHome()
	{
		Bot bot = new Bot();
		
		int[][] board = new int [25][17];
		
		for(int i = 0; i < 25; i++)
		{
			for(int j = 0; j < 17; j++)
			{
				board[i][j]=0;
			}
		}
		
		
		
		board[12][16] = 2;
		board[11][15] = 2;
		board[13][15] = 2;
		board[10][14] = 2;
		
		
		board[24][12] = 7;
		board[22][12] = 7;
		board[21][11] = 7;

		bot.board = board;
		
		assertEquals(bot.countHome(2), 4);
		assertEquals(bot.countHome(7), 2);
	
		
		bot.board = board;
		
		bot.doMove(2);
		
	}
	
	

}
