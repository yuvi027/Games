import java.util.Scanner;

public class Twenty48 {
	public static int[][] twenty = new int[4][4];
	static Scanner read = new Scanner(System.in);
	public static boolean winner = false, first = true;
	public Twenty48() {
		for(int r = 0; r < twenty.length; r++)
		{
			for(int c  = 0; c < twenty[r].length; c++)
			{
				twenty[r][c] = 0;
			}
		}
	}
	public static void addNum()
	{
		int row = (int)(Math.random()*4);
		int col = (int)(Math.random()*4);
		while(twenty[row][col] != 0)
		{
			row = (int)(Math.random()*4);
			col = (int)(Math.random()*4);
		}
		twenty[row][col] = (int)(Math.ceil(Math.random()*2))*2;
	}
	public static void startGame()
	{
		for(int a = 0; a < 2; a++)
		{
			int row = (int)(Math.random()*4);
			int col = (int)(Math.random()*4);
			while(twenty[row][col] != 0)
			{
				row = (int)(Math.random()*4);
				col = (int)(Math.random()*4);
			}
			twenty[row][col] = (int)(Math.ceil(Math.random()*2))*2;
		}
	}
	public static void printScreen() 
	{
		for(int[] r : twenty)
		{
			System.out.print("\n");
			for(int c = 0; c < r.length; c++)
			{
				if(c == 0)
				{
					System.out.print("   ");
				}
				else if (c == r.length)
				{
					System.out.print("  ");
				}
				else
				{
					System.out.print(" | ");
				}
				if(r[c] == 0)
				{
					System.out.print(" ");
				}
				else
					System.out.print(r[c]);
			}
			System.out.print("\n =================");
		}
		System.out.print("\n");
	}
	public static void swipeLeft()
	{
		for(int r = 0; r < 4; r++)
		{
			for(int c = 1; c < 4; c++)
			{
				if(twenty[r][c] != 0)
				{
					int cc = c-1;
					int col = c;
					while(cc > -1)
					{
						if(twenty[r][cc] == 0)
						{
							twenty[r][cc] = twenty[r][col];
							twenty[r][col] = 0;
							cc--;
							col--;
						}
						else if(twenty[r][cc] == twenty[r][col])
						{
							twenty[r][cc] = twenty[r][col]+twenty[r][col];
							twenty[r][col] = 0;
							cc--;
						}
						else
						{
							cc--;
							col--;
						}
					}
				}
			}
		}
	}
	public static void swipeRight()
	{
		for(int r = 0; r < 4; r++)
		{
			for(int c = 2; c >= 0; c--)
			{
				if(twenty[r][c] != 0)
				{
					int cc = c+1;
					int col = c;
					while(cc < 4)
					{
						if(twenty[r][cc] == 0)
						{
							twenty[r][cc] = twenty[r][col];
							twenty[r][col] = 0;
							cc++;
							col++;
						}
						else if(twenty[r][cc] == twenty[r][col])
						{
							twenty[r][cc] = twenty[r][col]+twenty[r][col];
							twenty[r][col] = 0;
							cc++;
						}
						else
						{
							cc++;
							col++;
						}
					}
				}
			}
		}
	}
	public static void swipeUp()
	{
		for(int c = 0; c < 4; c++)
		{
			for(int r = 1; r < 4; r++)
			{
				if(twenty[r][c] != 0)
				{
					int rr = r-1;
					int ro = r;
					while(rr > -1)
					{
						if(twenty[rr][c] == 0)
						{
							twenty[rr][c] = twenty[ro][c];
							twenty[ro][c] = 0;
							rr--;
							ro--;
						}
						else if(twenty[rr][c] == twenty[ro][c])
						{
							twenty[rr][c] = twenty[ro][c]+twenty[ro][c];
							twenty[ro][c] = 0;
							rr--;
						}
						else
						{
							rr--;
							ro--;
						}
					}
				}
			}
		}
	}
	public static void swipeDown()
	{
		for(int c = 0; c < 4; c++)
		{
			for(int r = 2; r >= 0; r--)
			{
				if(twenty[r][c] != 0)
				{
					int rr = r+1;
					int ro = r;
					while(rr < 4)
					{
						if(twenty[rr][c] == 0)
						{
							twenty[rr][c] = twenty[ro][c];
							twenty[ro][c] = 0;
							rr++;
							ro++;
						}
						else if(twenty[rr][c] == twenty[ro][c])
						{
							twenty[rr][c] = twenty[ro][c]+twenty[ro][c];
							twenty[ro][c] = 0;
							rr++;
						}
						else
						{
							rr++;
							ro++;
						}
					}
				}
			}
		}
	}
	public static void win()
	{
		if(first = true)
		{
			for(int[] r : twenty)
			{
				for(int c : r)
				{
					if(c == 2048)
					{
						winner = true;
						System.out.println("You won!!! Keep playing?");
						String ans = read.nextLine();
						if(ans.contains("Y") || ans.contains("y"))
						{
							winner = false;
							first = false;
						}
					}
				}
			}
			int cnt = 0;
			for(int a = 0; a < 3; a++)
			{
				for(int b = 0; b < 3; b++)
				{
					if(twenty[a][b] == twenty[a+1][b] || twenty[a][b] == twenty[a][b+1])
					{
						cnt++;
					}
				}
				if(twenty[3][a] == twenty[3][a+1] || twenty[a][3] == twenty[a+1][3])
					cnt++;
			}
			if(cnt == 0)
			{
				System.out.println("You lost. Play Again?");
				winner = true;
			}
		}
		else
		{
			int cnt = 0;
			for(int a = 0; a < 3; a++)
			{
				for(int b = 0; b < 3; b++)
				{
					if(twenty[a][b] == twenty[a+1][b] || twenty[a][b] == twenty[a][b+1])
					{
						cnt++;
					}
				}
				if(twenty[3][a] == twenty[3][a+1] || twenty[a][3] == twenty[a+1][3])
					cnt++;
			}
			if(cnt == 0)
			{
				System.out.println("You lost. Play Again?");
				winner = true;
			}
		}
	}
	public static void ask() 
	{
		while(winner != true)
		{
			System.out.println("Where do you want to swipe? 1 for up, 2 for right, 3 for down, and 4 for left");
			int side = read.nextInt();
			if(side == 1)
				swipeUp();
			else if(side == 2)
				swipeRight();
			else if(side == 3)
				swipeDown();
			else 
				swipeLeft();
			addNum();
			printScreen();
			win();
		}
	}
	public static void main(String[] args)	
	{
		String play = "y";
		while(play.contains("y") || play.contains("Y"))
		{
			System.out.print("\033[H\033[2J");
			System.out.println("Welcome to 2048!!");
			startGame();
			printScreen();
			ask();
			System.out.println("Do you want to play again? 0 for no, 1 for yes");
			play = read.nextLine();
		}
	}
}
