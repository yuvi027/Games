import java.util.Scanner;


public class UI {
	static String play = "yes";
	private static Scanner read;
	public static void main(String[] args){
		while(play.contains("y") || play.contains("Y"))
		{
			read = new Scanner(System.in);
			//clears screen
			System.out.print("\033[H\033[2J");  
			System.out.println("Welcome to My Games!!");
			System.out.println("Do you want to choose a game yourself (1) or randomly (2)?");
			
			
			int answer = read.nextInt();
			if(answer == 1)
			{
				System.out.println("Which game do you want to play? MadLibs (1) Tic Tac Toe (2) 2048 (3) Minesweeper (4)");
				answer = read.nextInt();
				if(answer == 1)
				{
					MadLibs.main(args);
				}
				else if(answer == 2)
				{
					TicTacToe.main(args);
				}
				else if(answer == 3)
				{
					Twenty48.main(args);
				}
				else
				{
					Minesweeper.main(args);
				}
			}
			else
			{
				answer = (int)((Math.random()*4));
				if(answer == 1)
				{
					MadLibs.main(args);
				}
				else if(answer == 2)
				{
					TicTacToe.main(args);
				}
				else if(answer == 3)
				{
					Twenty48.main(args);
				}
				else
				{
					Minesweeper.main(args);
				}
			}
			//introduce game
			System.out.println("Do you want to play a different game? (yes or no)");
			read.nextLine();
			play = read.nextLine();
			System.out.println();
		}
		System.out.println("Thank you for playing!!");
	}
}
