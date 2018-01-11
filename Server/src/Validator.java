public class Validator
{
	private int[][] board = new int[25][17];
	private int xp = -1;
	private int yp = -1;
	private int xd = -1;
	private int yd = -1;
	private int player = -1;
	protected int end = 0;
	
	
	
	public Validator(int[][] board, int xp, int yp, int xd, int yd)
	{
		this.board = board;
		this.xp = xp;
		this.yp = yp;
		this.xd = xd;
		this.yd = yd;
		this.player = board[xp][yp];
		
	}
	protected int validate()  // xp, yp - coordinates of pionek | xd, yd - coordinates of destination
	{
		if(board[xd][yd] > 1)
		{
			System.out.print("Move can not be done: this place is already taken");
			return 0;
		}
		else if(board[xd][yd] == 0)
		{
			System.out.print("Move can not be done: this place is outside the board");
			return 0;
		}
		else
		{
			if(outside(xp, yp, board[xp][yp]) == 1 && outside(xd, yd, board[xp][yp]) == 0)
			{
				System.out.print("Move can not be done: you can not come back to your home triangle");
				return 0;
			}
			else
			{
				return checkMovement();
			}
		}
		
		//return 1;
	}

	private int checkMovement()
	{
		int[][] coorBoard = new int[25][17];
		int xpp = this.xp;
		int ypp = this.yp;
		int xdd = this.xd;
		int ydd = this.yd;
		
		
		for(int i = 0; i < 25; i++)
		{
			for(int j = 0; j < 17; j++)
			{
				coorBoard[i][j]=0;
			}
		}
		
		coorBoard[xp][yp]=1;
		coorBoard[xd][yd]=2;
		
		if(player == 2)
		{
			//coorBoard = rotate(0, coorBoard) (change nothing)
		}
		else if(player == 3)
		{
			coorBoard = rotate(1, coorBoard);
			this.board = rotate(1, this.board);
		}
		else if(player == 4)
		{
			coorBoard = rotate(2, coorBoard);
			this.board = rotate(2, this.board);
		}
		else if(player == 5)
		{
			coorBoard = rotate(3, coorBoard);
			this.board = rotate(3, this.board);
		}
		else if(player == 6)
		{
			coorBoard = rotate(4, coorBoard);
			this.board = rotate(4, this.board);
		}
		else if(player == 7)
		{
			coorBoard = rotate(5, coorBoard);
			this.board = rotate(5, this.board);
		}
		
		
		for(int i = 0; i < 25; i++)
		{
			for(int j = 0; j < 17; j++)
			{
				if(coorBoard[i][j]==1)
				{
					xpp = i;
					ypp = j;
				}
				else if(coorBoard[i][j]==2)
				{
					xdd = i;
					ydd = j;
				}
			}
		}
		
				
				
		if(xpp+2==xdd && ypp==ydd)
		{
			return 1;
		}
		else if(xpp-2==xdd && ypp==ydd)
		{
			return 1;
		}
		else if(xpp-1==xdd && ypp+1==ydd)
		{
			return 1;
		}
		else if(xpp+1==xdd && ypp+1==ydd)
		{
			return 1;
		}
		else
		{
			System.out.println("there " + xpp  + " " + ypp +  " " + xdd +  " " + ydd +  " " + " .");
			return 0;
		}
	}

	private int outside(int x, int y, int a)
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
	
	int[][] rotate(int n, int[][] board)
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
		
		
		return board;
		
		
	}

	
}