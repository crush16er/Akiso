import static org.junit.Assert.*;

import org.junit.Test;

public class ValidatorTest
{

	@Test
	public void testValidate()
	{
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
		board[11][3] = 1;
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
		board[12][4] = 2;
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
		
		for(int y=0; y< 17; y++)
		{
			for(int x=0; x<25; x++)
			{
				if(board[x][y]==0)
				{
					System.out.printf(" ");
				}
				else
				{
					System.out.printf("%d", board[x][y]);
				}
				
			}
			
			System.out.println("");
		}
		
		
		
		Validator move1 = new Validator(board, 10, 6, 11, 7);
		
		assertEquals(move1.validate(), 1);
		
		
		Validator move2 = new Validator(board, 10, 6, 12, 6);
		
		assertEquals(move2.validate(), 1);
		
		
		Validator move3 = new Validator(board, 10, 6, 11, 12);
		
		assertEquals(move3.validate(), 0);
		
		Validator move4 = new Validator(board, 12, 4, 11, 3);
		
		assertEquals(move4.validate(), 0);
		
		
		Validator move5 = new Validator(board, 10, 6, 12, 6);
		
		assertEquals(move5.validate(), 1);
		
		
		Validator move6 = new Validator(board, 10, 6, 11, 12);
		
		assertEquals(move6.validate(), 0);
		
		
		Validator move7 = new Validator(board, 10, 6, 0, 4);
		
		assertEquals(move7.validate(), 0);
		
		Validator move8 = new Validator(board, 12, 4, 10, 2);
		
		assertEquals(move8.validate(), 0);
		
		Validator move9 = new Validator(board, 3, 5, 5, 5);
		
		assertEquals(move9.validate(), 0);
		
		
		board[12][10] = 4;
		
		Validator move10 = new Validator(board, 12, 10, 11, 9);
		
		assertEquals(move10.validate(), 1);
		
		board[12][8] = 5;
		
		Validator move11 = new Validator(board, 12, 8, 11, 7);
		
		assertEquals(move11.validate(), 1);
		
		
		board[9][9] = 6;
		
		Validator move12 = new Validator(board, 9, 9, 11, 9);
		
		assertEquals(move12.validate(), 1);
		
		board[17][5] = 3;
		
		Validator move13 = new Validator(board, 17, 5, 18, 4);
		
		assertEquals(move13.validate(), 0);
		
		
		
		Validator move14 = new Validator(board, 3, 7, 4, 8);
		
		assertEquals(move14.validate(), 1);
	}

}
