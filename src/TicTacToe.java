import java.util.Scanner;

public class TicTacToe {
	static int[][] tic = {{0,0,0},
			{0,0,0},
			{0,0,0}};
	static boolean win = false;
	static Scanner read = new Scanner(System.in);


	public static String printOutCome(int num1, int num2) {
		if(tic[num1][num2] == 1)
			return " X ";
		else if(tic[num1][num2] == 2)
			return " O ";
		else
			return "   ";
	}
	public static void checkPlayer1(int num1, int num2)
	{
		while(tic[num1-1][num2-1] != 0)
		{
			System.out.println("This place has been taken. Do you want to change row or column? 1 for row, 2 for column");
			int nu = read.nextInt();
			if(nu == 1)
			{
				System.out.println("Choose a Row: ");
				num1 = read.nextInt();
			}
			else 
			{
				System.out.println("Choose a Column: ");
				num2 = read.nextInt();
			}
		}
		tic[num1-1][num2-1] = 1;
	}
	public static void checkPlayer2(int num1, int num2)
	{
		while(tic[num1-1][num2-1] != 0)
		{
			System.out.println("This place has been taken. Do you want to change row or column? 1 for row, 2 for column");
			int nu = read.nextInt();
			if(nu == 1)
			{
				System.out.println("Choose a Row: ");
				num1 = read.nextInt();
			}
			else 
			{
				System.out.println("Choose a Column: ");
				num2 = read.nextInt();
			}
		}
		tic[num1-1][num2-1] = 2;
	}
	public static String winner(int num1, int num2)
	{
		String winn = "";
		if(tic[num1-1][0] == tic[num1-1][1] && tic[num1-1][1] == tic[num1-1][2])
		{
			if(tic[num1-1][0] == 1)
			{
				winn = "\n\nX won!!";
				win = true;
			}
			else if (tic[num1-1][0] == 2)
			{
				winn = "\n\nO won!!";
				win = true;
			}
		}
		else if(tic[0][num2-1] == tic[1][num2-1] && tic[1][num2-1] == tic[2][num2-1])
		{
			if(tic[0][num2-1] == 1)
			{
				winn = "\n\nX won!!";
				win = true;
			}
			else if (tic[0][num2-1] == 2)
			{
				winn = "\n\nO won!!";
				win = true;
			}
		}
		else if(tic[0][0] == tic[1][1] && tic[1][1] == tic[2][2])
		{
			if(tic[0][0] == 1)
			{
				winn = "\n\nX won!!";
				win = true;
			}
			else if (tic[0][0] == 2)
			{
				winn = "\n\nO won!!";
				win = true;
			}
		}
		else if(tic[0][2] == tic[1][1] && tic[1][1] == tic[2][0])
		{
			if (tic[0][2] == 1)
			{
				winn = "\n\nX won!!";
				win = true;
			}
			else if (tic[0][2] == 2)
			{
				winn = "\n\nO won!!";
				win = true;
			}
		}
		int cnt = 0;
		for(int[] row : tic)
		{
			for(int col : row)
			{
				if(col != 0)
					cnt++;
			}
		}
		if(cnt == 9)
		{
			winn = "\n\nTie";
			win = true;
		}
		return winn;
	}
	public static void nums1()
	{
		if(win != true)
		{
			System.out.println("Choose a Row: ");
			int row = read.nextInt();
			System.out.println("Choose a Column: ");
			int col = read.nextInt();
			checkPlayer2(row, col);
			System.out.println(winner(row, col));
			printBoard();
		}
	}

	public static void nums2()
	{
		if(win != true)
		{
			System.out.println("Choose a Row: ");
			int row = read.nextInt();
			System.out.println("Choose a Column: ");
			int col = read.nextInt();
			checkPlayer1(row, col);
			System.out.println(winner(row, col));
			printBoard();
		}
	}
	public static void comp()
	{
		if(win != true)
		{
			int row = (int)(Math.random()*3);
			int col = (int)(Math.random()*3);
			while(tic[row][col] != 0)
			{
				row = (int)(Math.random()*3);
				col = (int)(Math.random()*3);
			}
			tic[row][col] = 2;			
			System.out.println(winner(row+1, col+1));
			printBoard();
		}
	}
	public static void printBoard()
	{
		//print tic-tac-toe board
		System.out.println();
		System.out.println(" "+ printOutCome(0,0) + "|" + printOutCome(0,1) + "|" + printOutCome(0,2));
		System.out.println(" ===========");
		System.out.println(" "+ printOutCome(1,0) + "|" + printOutCome(1,1) + "|" + printOutCome(1,2));
		System.out.println(" ===========");
		System.out.println(" "+ printOutCome(2,0) + "|" + printOutCome(2,1) + "|" + printOutCome(2,2));
	}
	public static void main(String[] args){
		String pl = "yes";
		while(pl.contains("y") || pl.contains("Y"))
		{
			//clears screen
			System.out.print("\033[H\033[2J");
			System.out.println("Welcome to Tic-Tac-Toe!!");
			//creates matrix for tic-tac-toe
			System.out.println("Do you want to play one or two players? 1 for one player, 2 for two players");
			int play = read.nextInt();
			if(play == 2)
			{
				printBoard();
				System.out.println("Choose a Row: 1 for the top, 2 for middle, 3 for bottom");
				int row = read.nextInt();
				System.out.println("Choose a Column: 1 for the left, 2 for middle, 3 for right");
				int col = read.nextInt();
				checkPlayer1(row, col);
				System.out.println(winner(row, col));
				printBoard();
				nums1();
				nums2();
				nums1();
				nums2();
				nums1();
				nums2();
				nums1();
				nums2();
			}
			else
			{
				printBoard();
				System.out.println("Choose a Row: 1 for the top, 2 for middle, 3 for bottom");
				int row = read.nextInt();
				System.out.println("Choose a Column: 1 for the left, 2 for middle, 3 for right");
				int col = read.nextInt();
				checkPlayer1(row, col);
				System.out.println(winner(row, col));
				printBoard();
				comp();
				nums2();
				comp();
				nums2();
				comp();
				nums2();
				comp();
				nums2();
			}
			read.nextLine();
			System.out.println("Do you want to play again? (yes or no)");
			pl = read.nextLine();
		}
	}
}
