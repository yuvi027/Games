import java.util.Arrays;
import java.util.Scanner;

public class Minesweeper {
	static int num = 8;
	static int turns = 0;
	static int[][] mines= new int[num][num];
	static int[][] minesOut= new int[num][num];
	static Scanner read = new Scanner(System.in);
	static boolean winner = false;

	public static void addMines()
	{
		// (int)(num*num) cnt /= 4;
		for(int cnt = 0; cnt <= 10; cnt++)
		{
			int ro = (int)((Math.random()*num));
			int col = (int)((Math.random()*num));
			while(mines[ro][col] != 0)
			{
				ro = (int)((Math.random()*num));
				col = (int)((Math.random()*num));
			}
			mines[ro][col] = 1;
		}
		for(int r = 0; r < num; r ++)
		{
			for(int c = 0; c < num; c ++)
			{
				minesOut[r][c] = 0;
			}
		}
	}
	public static void printScreen()
	{
		int cnt = 1;
		System.out.print("     ");
		//prints line of col's numbers
		for(cnt = 1; cnt <= num; cnt++)
		{
			if(cnt > 9)
				System.out.print(cnt+ "  ");
			else
				System.out.print(cnt+ "   ");
		}
		//Prints rows of ===
		System.out.println();
		System.out.print("   ");
		int numb = 0;
		while(numb <= (int)(54/11)*num+1)
		{
			System.out.print("=");
			numb++;
		}
		cnt = 1;
		for(int r1 = 0 ; r1 < mines.length; r1++)
		{
			System.out.print("\n");
			System.out.print("\n");
			//print row's numbers
			if(cnt > 9)
				System.out.print(cnt);
			else
				System.out.print(cnt+ " ");	
			//print variables in minesOut?
			for(int c = 0; c < mines.length; c++)
			{
				if(c == 0)
				{
					System.out.print("   ");
					if(minesOut[r1][c] != 0)
						System.out.print(minesOut[r1][c]-1);
					System.out.print(" ");
				}
				else if (c == mines.length)
				{
					System.out.print(" |");
					if(minesOut[r1][c] != 0)
						System.out.print(minesOut[r1][c]-1);
					System.out.print(" ");
				}
				else
				{
					System.out.print("| ");
					if(minesOut[r1][c] != 0)
						System.out.print((minesOut[r1][c])-1);
					else
						System.out.print(" ");
				}
				if(mines[r1][c] == 1)
					System.out.print(" ");
				else
					System.out.print(" ");
			}
			System.out.print("     " +cnt);
			cnt++;
			System.out.print("\n   ");
			numb = 0;
			while(numb <= (int)(54/11)*num+1)
			{
				System.out.print("=");
				numb++;
			}
		}
		System.out.print("\n");
		System.out.print("\n");
	}
	public static void printExplosion()
	{
		System.out.print("     ");
		for(int cnt = 1; cnt <= num; cnt++)
		{
			if(cnt > 9)
				System.out.print(cnt+ "  ");
			else
				System.out.print(cnt+ "   ");
		}
		System.out.println();
		System.out.print("   ");
		int numb = 0;
		while(numb <= (int)(54/11)*num+1)
		{
			System.out.print("=");
			numb++;
		}
		int cnt = 1;
		for(int[] r : mines)
		{
			System.out.print("\n");
			System.out.print("\n");
			if(cnt > 9)
				System.out.print(cnt);
			else
				System.out.print(cnt+ " ");	

			for(int c = 0; c < mines.length; c++)
			{
				if(c == 0)
				{
					System.out.print("   ");
				}
				else if (c == mines.length)
				{
					System.out.print("   ");
				}
				else
				{
					System.out.print(" | ");
				}
				if(r[c] == 1)
					System.out.print("X");
				else
					System.out.print(" ");
			}
			System.out.print("     " +cnt);
			cnt++;
			System.out.print("\n   ");
			numb = 0;
			while(numb <= (int)(54/11)*num+1)
			{
				System.out.print("=");
				numb++;
			}
		}
		System.out.print("\n");
		System.out.print("\n");
	}
	public static void check(int r, int c)
	{
		turns++;
		int row = r-1;
		int col = c-1;
		if(mines[row][col] == 1)
		{
			System.out.print("\033[H\033[2J");
			System.out.println("\n\n\t   You exploded!!!\n\n");
			printExplosion();
			winner = true;
		}
		else 
		{
			int cnt = 1;
			if(row < num-1)
			{
				if(mines[row+1][col] == 1)
					cnt++;
				if(col < num-1)
				{
					if(mines[row+1][col+1] == 1)
						cnt++;
				}
				if(col > 0)
				{
					if(mines[row+1][col-1] == 1)
						cnt++;
				}
			}
			if(row > 0)
			{
				if(mines[row-1][col] == 1)
					cnt++;
				if(col < num-1)
				{
					if(mines[row-1][col+1] == 1)
						cnt++;
				}
				if(col > 0)
				{
					if(mines[row-1][col-1] == 1)
						cnt++;
				}
			}
			if(col < num-1)
			{
				if(mines[row][col+1] == 1)
					cnt++;
			}
			if(col > 0)
			{
				if(mines[row][col-1] == 1)
					cnt++;
			}
			minesOut[row][col] = cnt;
			if(turns == (num*num)-10)
			{
				System.out.println("\n\n\t   You won!!!\n\n");
				printScreen();
				winner = true;
			}
		}
	}
	public static void main(String[] args)	
	{
		String play = "y";
		while(play.contains("y") || play.contains("Y"))
		{
			winner = false;
			//clears screen
			System.out.print("\033[H\033[2J");
			System.out.println("\n\t   Welcome to Minesweeper!!");
			addMines();

			while(winner == false)
			{
				printScreen();
				System.out.println("Choose a Row:");
				int rowNum = read.nextInt();
				System.out.println("Choose a Column:");
				int col = read.nextInt();
				//System.out.println(winner(row, col));
				check(rowNum, col);
			}
			System.out.println("Do you want to play again? 0 for no, 1 for yes");
			play = read.nextLine();
		}
	}
}
