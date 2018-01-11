public class Bot
{
	int[][] board = new int [25][17];
	int move = 0;
	int xdd = -1;
	int ydd = -1;
	int tmp = -1;
	
	void doMove(int player)
	{
		move = 0;
		int amount = countHome(player);
		int count = 0;
		
		
		if(player == 2)
		{
			for(int y = 16; y >= 0; y--)
			{
				for(int x = 0; x < 25; x++)
				{
					if(board[x][y] == 2)
					{
						if(count >= amount)
						{
							if(move==1)
							{
								break;
							}
							else
							{
								tryMove(x, y, player);
							}
						}
						else
						{
							count++;
						}
					}
					
				}
			}
		}
		else if(player == 3)
		{
			rotate(1);
			
			
			for(int y = 16; y >= 0; y--)
			{
				for(int x = 0; x < 25; x++)
				{
					if(board[x][y] == 3)
					{
						if(count >= amount)
						{
							if(move==1)
							{
								break;
							}
							else
							{
								tryMove(x, y, player);
							}
						}
						else
						{
							count++;
						}
					}
				}
			}
			
			
			rotate(5);
		}
		else if(player == 4)
		{
			rotate(2);
			
			
			for(int y = 16; y >= 0; y--)
			{
				for(int x = 0; x < 25; x++)
				{
					if(board[x][y] == 4)
					{
						if(count >= amount)
						{
							if(move==1)
							{
								break;
							}
							else
							{
								tryMove(x, y, player);
							}
						}
						else
						{
							count++;
						}
					}
				}
			}
			
			
			rotate(4);
		}
		else if(player == 5)
		{
			rotate(3);
			
			
			for(int y = 16; y >= 0; y--)
			{
				for(int x = 0; x < 25; x++)
				{
					if(board[x][y] == 5)
					{
						if(count >= amount)
						{
							if(move==1)
							{
								break;
							}
							else
							{
								tryMove(x, y, player);
							}
						}
						else
						{
							count++;
						}
					}
				}
			}
			
			
			rotate(3);
		}
		else if(player == 6)
		{
			rotate(4);
			
			
			for(int y = 16; y >= 0; y--)
			{
				for(int x = 0; x < 25; x++)
				{
					if(board[x][y] == 6)
					{
						if(count >= amount)
						{
							if(move==1)
							{
								break;
							}
							else
							{
								tryMove(x, y, player);
							}
						}
						else
						{
							count++;
						}
					}
				}
			}
			

			rotate(2);
		}
		else if(player == 7)
		{
			rotate(5);
			
			
			for(int y = 16; y >= 0; y--)
			{
				for(int x = 0; x < 25; x++)
				{
					if(board[x][y] == 7)
					{
						if(count >= amount)
						{
							if(move==1)
							{
								break;
							}
							else
							{
								tryMove(x, y, player);
							}
						}
						else
						{
							count++;
						}
					}
				}
			}
			
			
			rotate(1);
		}
	}

	protected int countHome(int player)
	{
		if(player == 2)
		{
			if(board[12][16] != player)
			{
				xdd = 12;
				ydd = 16;
				return 0;
			}
			else if(board[11][15] != player)
			{
				xdd = 11;
				ydd = 15;
				return 1;
			}
			else if(board[13][15] != player)
			{
				xdd = 13;
				ydd = 15;
				return 2;
			}
			else if(board[10][14] != player)
			{
				xdd = 10;
				ydd = 14;
				return 3;
			}
			else if(board[12][14] != player)
			{
				xdd = 12;
				ydd = 14;
				return 4;
			}
			else if(board[14][14] != player)
			{
				xdd = 14;
				ydd = 14;
				return 5;
			}
			else if(board[9][13] != player)
			{
				xdd = 9;
				ydd = 13;
				return 6;
			}
			else if(board[11][13] != player)
			{
				xdd = 11;
				ydd = 13;
				return 7;
			}
			else if(board[13][13] != player)
			{
				xdd = 13;
				ydd = 13;
				return 8;
			}
			else if(board[15][13] != player)
			{
				xdd = 15;
				ydd = 13;
				return 9;
			}
		}
		else if(player == 3)
		{
			if(board[0][12] != player)
			{
				xdd = 12;
				ydd = 16;
				return 0;
			}
			else if(board[1][11] != player)
			{
				xdd = 11;
				ydd = 15;
				return 1;
			}
			else if(board[2][12] != player)
			{
				xdd = 13;
				ydd = 15;
				return 2;
			}
			else if(board[2][10] != player)
			{
				xdd = 10;
				ydd = 14;
				return 3;
			}
			else if(board[3][11] != player)
			{
				xdd = 12;
				ydd = 14;
				return 4;
			}
			else if(board[4][12] != player)
			{
				xdd = 14;
				ydd = 14;
				return 5;
			}
			else if(board[3][9] != player)
			{
				xdd = 9;
				ydd = 13;
				return 6;
			}
			else if(board[4][10] != player)
			{
				xdd = 11;
				ydd = 13;
				return 7;
			}
			else if(board[5][11] != player)
			{
				xdd = 13;
				ydd = 13;
				return 8;
			}
			else if(board[6][12] != player)
			{
				xdd = 15;
				ydd = 13;
				return 9;
			}
		}
		else if(player == 4)
		{
			if(board[0][4] != player)
			{
				xdd = 12;
				ydd = 16;
				return 0;
			}
			else if(board[2][4] != player)
			{
				xdd = 11;
				ydd = 15;
				return 1;
			}
			else if(board[1][5] != player)
			{
				xdd = 13;
				ydd = 15;
				return 2;
			}
			else if(board[4][4] != player)
			{
				xdd = 10;
				ydd = 14;
				return 3;
			}
			else if(board[3][5] != player)
			{
				xdd = 12;
				ydd = 14;
				return 4;
			}
			else if(board[2][6] != player)
			{
				xdd = 14;
				ydd = 14;
				return 5;
			}
			else if(board[6][4] != player)
			{
				xdd = 9;
				ydd = 13;
				return 6;
			}
			else if(board[5][5] != player)
			{
				xdd = 11;
				ydd = 13;
				return 7;
			}
			else if(board[4][6] != player)
			{
				xdd = 13;
				ydd = 13;
				return 8;
			}
			else if(board[3][7] != player)
			{
				xdd = 15;
				ydd = 13;
				return 9;
			}
		}
		else if(player == 5)
		{
			if(board[12][0] != player)
			{
				xdd = 12;
				ydd = 16;
				return 0;
			}
			else if(board[13][1] != player)
			{
				xdd = 11;
				ydd = 15;
				return 1;
			}
			else if(board[11][1] != player)
			{
				xdd = 13;
				ydd = 15;
				return 2;
			}
			else if(board[14][2] != player)
			{
				xdd = 10;
				ydd = 14;
				return 3;
			}
			else if(board[12][2] != player)
			{
				xdd = 12;
				ydd = 14;
				return 4;
			}
			else if(board[10][2] != player)
			{
				xdd = 14;
				ydd = 14;
				return 5;
			}
			else if(board[15][3] != player)
			{
				xdd = 9;
				ydd = 13;
				return 6;
			}
			else if(board[13][3] != player)
			{
				xdd = 11;
				ydd = 13;
				return 7;
			}
			else if(board[11][3] != player)
			{
				xdd = 13;
				ydd = 13;
				return 8;
			}
			else if(board[9][3] != player)
			{
				xdd = 15;
				ydd = 13;
				return 9;
			}
		}
		else if(player == 6)
		{
			if(board[24][4] != player)
			{
				xdd = 12;
				ydd = 16;
				return 0;
			}
			else if(board[23][5] != player)
			{
				xdd = 11;
				ydd = 15;
				return 1;
			}
			else if(board[22][4] != player)
			{
				xdd = 13;
				ydd = 15;
				return 2;
			}
			else if(board[22][6] != player)
			{
				xdd = 10;
				ydd = 14;
				return 3;
			}
			else if(board[21][5] != player)
			{
				xdd = 12;
				ydd = 14;
				return 4;
			}
			else if(board[20][4] != player)
			{
				xdd = 14;
				ydd = 14;
				return 5;
			}
			else if(board[21][7] != player)
			{
				xdd = 9;
				ydd = 13;
				return 6;
			}
			else if(board[20][6] != player)
			{
				xdd = 11;
				ydd = 13;
				return 7;
			}
			else if(board[19][5] != player)
			{
				xdd = 13;
				ydd = 13;
				return 8;
			}
			else if(board[18][4] != player)
			{
				xdd = 15;
				ydd = 13;
				return 9;
			}
		}
		else if(player == 7)
		{
			if(board[24][12] != player)
			{
				xdd = 12;
				ydd = 16;
				return 0;
			}
			else if(board[22][12] != player)
			{
				xdd = 11;
				ydd = 15;
				return 1;
			}
			else if(board[23][11] != player)
			{
				xdd = 13;
				ydd = 15;
				return 2;
			}
			else if(board[20][12] != player)
			{
				xdd = 10;
				ydd = 14;
				return 3;
			}
			else if(board[21][11] != player)
			{
				xdd = 12;
				ydd = 14;
				return 4;
			}
			else if(board[22][10] != player)
			{
				xdd = 14;
				ydd = 14;
				return 5;
			}
			else if(board[18][12] != player)
			{
				xdd = 9;
				ydd = 13;
				return 6;
			}
			else if(board[19][11] != player)
			{
				xdd = 11;
				ydd = 13;
				return 7;
			}
			else if(board[20][10] != player)
			{
				xdd = 13;
				ydd = 13;
				return 8;
			}
			else if(board[21][9] != player)
			{
				xdd = 15;
				ydd = 13;
				return 9;
			}
		}
		
		return 10;
	}

	/*private int outside(int x, int y, int a)
	{
		if(a == 2)
		{
			if(y == 0 && x == 12)
			{
				return 0;
			}
			else if(y == 1 && (x == 11 || x == 13))
			{
				return 0;
			}
			else if(y == 2 && (x == 10 || x == 12 || x == 14))
			{
				return 0;
			}
			else if(y == 3 && (x == 9 || x == 11 || x == 13 || x == 15))
			{
				return 0;
			}
		}
		else if(a == 3)
		{
			if(y == 7 && x == 21)
			{
				return 0;
			}
			else if(y == 6 && (x == 20 || x == 22))
			{
				return 0;
			}
			else if(y == 5 && (x == 19 || x == 21 || x == 23))
			{
				return 0;
			}
			else if(y == 4 && (x == 18 || x == 20 || x == 22 || x == 24))
			{
				return 0;
			}
		}
		else if(a == 4)
		{
			if(y == 9 && x == 21)
			{
				return 0;
			}
			else if(y == 10 && (x == 20 || x == 22))
			{
				return 0;
			}
			else if(y == 11 && (x == 19 || x == 21 || x == 23))
			{
				return 0;
			}
			else if(y == 12 && (x == 18 || x == 20 || x == 22 || x == 24))
			{
				return 0;
			}
		}
		else if(a == 5)
		{
			if(y == 16 && x == 12)
			{
				return 0;
			}
			else if(y == 15 && (x == 11 || x == 13))
			{
				return 0;
			}
			else if(y == 14 && (x == 10 || x == 12 || x == 14))
			{
				return 0;
			}
			else if(y == 13 && (x == 9 || x == 11 || x == 13 || x == 15))
			{
				return 0;
			}
		}
		else if(a == 6)
		{
			if(y == 9 && x == 3)
			{
				return 0;
			}
			else if(y == 10 && (x == 2 || x == 4))
			{
				return 0;
			}
			else if(y == 11 && (x == 1 || x == 3 || x == 5))
			{
				return 0;
			}
			else if(y == 12 && (x == 0 || x == 2 || x == 4 || x == 6))
			{
				return 0;
			}
		}
		else if(a == 7)
		{
			if(y == 7 && x == 3)
			{
				return 0;
			}
			else if(y == 6 && (x == 2 || x == 4))
			{
				return 0;
			}
			else if(y == 5 && (x == 1 || x == 3 || x == 5))
			{
				return 0;
			}
			else if(y == 4 && (x == 0 || x == 2 || x == 4 || x == 6))
			{
				return 0;
			}
		}
		
		return 1;
	}

	private void tryMoveWrong(int x, int y, int player)
	{
		if(y<=14 && board[x][y+2] == 1)
		{
			board[x][y] = 1;
			board[x][y+2] = player;
			move = 1;
		}
		else if(y<=12 && board[x][y+2] != 1 && board[x][y+4] == 1)
		{
			board[x][y] = 1;
			board[x][y+4] = player; 
			move = 1;
		}
	}*/
	
	
	
	
	private void tryMove(int xp, int yp, int player)
	{
		int xd = xdd;
		int yd = ydd;
		
		
		if((xp + 1 == xd) && (yp + 1 == yd) && board[xp+1][yp+1] == 1)
		{
			board[xp+1][yp+1] = player;
			board[xp][yp] = 1;
			move = 1;
		}
		else if((xp - 1 == xd) && (yp + 1 == yd) && board[xp-1][yp+1] == 1)
		{
			board[xp-1][yp+1] = player;
			board[xp][yp] = 1;
			move = 1;
		}
		else
		{
			if(xp<xd && yp<yd)
			{
				if(board[xp+1][yp+1] == 1)
				{
					board[xp+1][yp+1] = player;
					board[xp][yp] = 1;
					move = 1;
				}
				else if(board[xp+1][yp+1] != 1 && xp+2<=24 && yp+2<=16)
				{
					if(board[xp+2][yp+2] == 1)
					{
						board[xp+2][yp+2] = player;
						board[xp][yp] = 1;
						move = 1;
					}
				}
				
				if(move != 1)
				{
					if(xp-1>=0 && yp+1<=16)
					{
						if(board[xp-1][yp+1] == 1)
						{
							board[xp-1][yp+1] = player;
							board[xp][yp] = 1;
							move = 1;
						}
					}
					
					
					if(move != 1 && xp-2>=0 && yp+2<=16)
					{
						if(board[xp-1][yp+1] != 1 && board[xp-2][yp+2] == 1)
						{
							board[xp-2][yp+2] = player;
							board[xp][yp] = 1;
							move = 1;
						}
					}
				}
			}
			else if(xp>xd && yp<yd)
			{
				if(board[xp-1][yp+1] == 1)
				{
					board[xp-1][yp+1] = player;
					board[xp][yp] = 1;
					move = 1;
				}
				else if(board[xp-1][yp+1] != 1 && xp-2>=0 && yp+2<=16)
				{
					if(board[xp-2][yp+2] == 1)
					{
						board[xp-2][yp+2] = player;
						board[xp][yp] = 1;
						move = 1;
					}
				}
				
				if(move != 1)
				{
					if(xp+1<=24 && yp+1<=16)
					{
						if(board[xp+1][yp+1] == 1)
						{
							board[xp+1][yp+1] = player;
							board[xp][yp] = 1;
							move = 1;
						}
					}
					
					
					if(move != 1 && xp+2<=24 && yp+2<=16)
					{
						if(board[xp+1][yp+1] != 1 && board[xp+2][yp+2] == 1)
						{
							board[xp+2][yp+2] = player;
							board[xp][yp] = 1;
							move = 1;
						}
					}
				}
			}
			else if(xp == xd && yp<yd)
			{
				if(board[xp-1][yp+1] == 1)
				{
					board[xp-1][yp+1] = player;
					board[xp][yp] = 1;
					move = 1;
				}
				else
				{
					if(board[xp+1][yp+1] == 1)
					{
						board[xp+1][yp+1] = player;
						board[xp][yp] = 1;
						move = 1;
					}
				}
				
				if(move != 1)
				{
					if(xp-2>=0 && yp+2<=16)
					{
						if(board[xp-1][yp+1] != 1 && board[xp-2][yp+2] == 1)
						{
							board[xp-2][yp+2] = player;
							board[xp][yp] = 1;
							move = 1;
						}
					}
					
					
					if(move != 1 && xp+2<=24 && yp+2<=16)
					{
						if(board[xp+1][yp+1] != 1 && board[xp+2][yp+2] == 1)
						{
							board[xp+2][yp+2] = player;
							board[xp][yp] = 1;
							move = 1;
						}
					}
				}
			}
		}
	}
	
	
	
	
	
	
	
	
	void rotate(int n)
	{
		for(int k = 0; k < n; k++)
		{
			
			int[][] tmpBoard = new int [25][17];
			
			for(int i = 0; i < 25; i++)
			{
				for(int j = 0; j < 17; j++)
				{
					tmpBoard[i][j]=0;
				}
			}
			
			
			//Row number 0
			tmpBoard[12][0] = board[24][4];
			//end
			
			//Row number 1
			tmpBoard[11][1] = board[22][4];
			tmpBoard[13][1] = board[23][5];
			//end
			
			//Row number 2
			int x = 10;
			
			for(int i=0; i<3; i++)
			{
				tmpBoard[x][2] = board[20+i][4+i];
				x = x + 2;
			}
			//end
			
			//Row number 2
			x = 10;
			
			for(int i=0; i<3; i++)
			{
				tmpBoard[x][2] = board[20+i][4+i];
				x = x + 2;
			}
			//end
			
			
			//Row number 3
			x = 9;
			
			for(int i=0; i<4; i++)
			{
				tmpBoard[x][3] = board[18+i][4+i];
				x = x + 2;
			}
			//end
			
			
			//Row number 4
			x = 0;
			
			for(int i=0; i<13; i++)
			{
				tmpBoard[x][4] = board[12+i][0+i];
				x = x + 2;
			}
			//end
			
			
			//Row number 5
			x = 1;
			
			for(int i=0; i<12; i++)
			{
				tmpBoard[x][5] = board[11+i][1+i];
				x = x + 2;
			}
			//end
			
			
			//Row number 6
			x = 2;
			
			for(int i=0; i<11; i++)
			{
				tmpBoard[x][6] = board[10+i][2+i];
				x = x + 2;
			}
			//end
			
			
			//Row number 7
			x = 3;
			
			for(int i=0; i<10; i++)
			{
				tmpBoard[x][7] = board[9+i][3+i];
				x = x + 2;
			}
			//end
			
			
			//Row number 8
			x = 4;
			
			for(int i=0; i<9; i++)
			{
				tmpBoard[x][8] = board[8+i][4+i];
				x = x + 2;
			}
			//end
			
			
			//Row number 9
			x = 3;
			
			for(int i=0; i<10; i++)
			{
				tmpBoard[x][9] = board[6+i][4+i];
				x = x + 2;
			}
			//end
			
			
			//Row number 10
			x = 2;
			
			for(int i=0; i<11; i++)
			{
				tmpBoard[x][10] = board[4+i][4+i];
				x = x + 2;
			}
			//end
			
			
			//Row number 11
			x = 1;
			
			for(int i=0; i<12; i++)
			{
				tmpBoard[x][11] = board[2+i][4+i];
				x = x + 2;
			}
			//end
			
			
			//Row number 12
			x = 0;
			
			for(int i=0; i<13; i++)
			{
				tmpBoard[x][12] = board[0+i][4+i];
				x = x + 2;
			}
			//end
			
			
			//Row number 13
			x = 9;
			
			for(int i=0; i<4; i++)
			{
				tmpBoard[x][13] = board[3+i][9+i];
				x = x + 2;
			}
			//end
			
			
			//Row number 14
			x = 10;
			
			for(int i=0; i<3; i++)
			{
				tmpBoard[x][14] = board[2+i][10+i];
				x = x + 2;
			}
			//end
			
			
			//Row number 15
			x = 11;
			
			for(int i=0; i<2; i++)
			{
				tmpBoard[x][15] = board[1+i][11+i];
				x = x + 2;
			}
			//end
			
			
			//Row number 16
			tmpBoard[12][16] = board[0][12];
			//end
			
			
			
			board = tmpBoard;
		}
		
		
	}
}
