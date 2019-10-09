import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;  // Import the Scanner class

public class MadLibs {
	private static Scanner read;
	public static void main(String[] args){
		//clears screen
		String play = "y";
		while(play.contains("y") || play.contains("Y"))
		{
			System.out.print("\033[H\033[2J"); 
			System.out.println("Welcome to Mad Libs!!");
			Queue<String> obj = new LinkedList<String>();
			read = new Scanner(System.in);
			//adds words into array
			System.out.println("Choose an adjective: ");
			obj.add(read.nextLine());
			System.out.println("Choose an adjective: ");
			obj.add(read.nextLine());
			System.out.println("Choose a noun: ");
			obj.add(read.nextLine());
			System.out.println("Choose a noun: ");
			obj.add(read.nextLine());
			System.out.println("Choose a plural noun: ");
			obj.add(read.nextLine());
			System.out.println("Choose a game: ");
			obj.add(read.nextLine());
			System.out.println("Choose another plural noun: ");
			obj.add(read.nextLine());
			System.out.println("Choose an ING verb: ");
			obj.add(read.nextLine());
			System.out.println("Choose another ING verb: ");
			obj.add(read.nextLine());
			System.out.println("Choose a plural noun: ");
			obj.add(read.nextLine());
			System.out.println("Almost there!");
			System.out.println("Choose a game: ");
			obj.add(read.nextLine());
			System.out.println("Choose an ING verb: ");
			obj.add(read.nextLine());
			System.out.println("Choose a noun: ");
			obj.add(read.nextLine());
			System.out.println("Choose a plant: ");
			obj.add(read.nextLine());
			System.out.println("Choose a body part: ");
			obj.add(read.nextLine());
			System.out.println("5 Left!");
			System.out.println("Choose a place: ");
			obj.add(read.nextLine());
			System.out.println("Choose an ING verb: ");
			obj.add(read.nextLine());
			System.out.println("Choose an adjective: ");
			obj.add(read.nextLine());
			System.out.println("Choose a number: ");
			obj.add(read.nextLine());
			System.out.println("Finally, choose a plural noun: ");
			obj.add(read.nextLine());
			/*
			 * Adjective
			 * Adjective
			 * Noun 
			 * Noun
			 * plural noun
			 * Game
			 * plural noun
			 * ING verb
			 * ING verb
			 * plural noun
			 * Game
			 * ING verb
			 * Noun
			 * Plant
			 * body part
			 * Place
			 * ING verb
			 * Adjective
			 * Number
			 * plural noun
			 */
			int ran = (int) (Math.random()*2);
			System.out.println(ran);
			if(ran == 0)
			{
				//clears screen
				System.out.print("\033[H\033[2J");  

				//create story
				System.out.println("\t\t\t\tVacations\n\n\n");  
				System.out.print("A vacation is when you take a trip to some "+ obj.poll()+ " place with your ");  
				System.out.print(obj.poll() + " family. \nUsually you go to some place that is near a/an "+ obj.poll());  
				System.out.print(" or up on a/an "+ obj.poll()+ ". A good \nvacation place is one where you can ride ");  
				System.out.print(obj.poll() + " or play "+ obj.poll() + " or even \ngo hunting for "+ obj.poll() + ".");  
				System.out.print(" I like to spend my time "+ obj.poll()+ " or "+ obj.poll()+ ". When parents go \non a ");  
				System.out.print("vacation, they spend their time eating three "+ obj.poll()+ " a day. Fathers play \n");  
				System.out.print(obj.poll()+ ", while mothers sit around " + obj.poll()+ ". Last summer, my little brother \n");  
				System.out.print("fell in a/an " + obj.poll()+ ", and got poison " + obj.poll()+ " all over his " +obj.poll());  
				System.out.print(". This year, \nmy family is going to go to (the) " + obj.poll()+ ", and I will practice " + obj.poll());  
				System.out.print(".Parents need \nvacations more than kids because parents are always very " + obj.poll());  
				System.out.print("and because they \nhave to work " + obj.poll() + " hours every day all year making enough ");  
				System.out.println(obj.poll() + " to pay for the vacation.\n\n");  
			}
			else {
				//clears screen
				System.out.print("\033[H\033[2J");  

				//create story
				System.out.println("\t\t\t\tFood\n\n\n");  
				System.out.print("There are many great foods in the world. For example, I love a/an"+ obj.poll()+ " sandwich \nwith ");  
				System.out.print(obj.poll() + " cheese and lots of vegetables. It's especially good eaten with a/an "+ obj.poll());  
				System.out.print(" or with \na/an "+ obj.poll()+ ". Another great food, which you can also eat with ");  
				System.out.print(obj.poll() + " or while playing "+ obj.poll() + " is "+ obj.poll() + ".\n");  
				System.out.print(" I like "+ obj.poll()+ " or "+ obj.poll()+ " often, as I make the best food out f everyone I know. ");  
				System.out.print("I'm really \ngood with making pasta with "+ obj.poll()+ ", because it's one of the only food my brother eats. ");  
				System.out.print(obj.poll()+ " \ngoes extremely well when you are " + obj.poll()+ " some quality food. ");  
				System.out.print("My mother made once a/an " + obj.poll()+ " \ncake, and then got food poisoning, but it was worth it. ");
				System.out.print("She then ate " + obj.poll()+ " because it was \nsupposed to help, but instead got a rush all over her  " +obj.poll());  
				System.out.print(".This weekend, my dad is planning \nto make lasagna for dinner, just like in " + obj.poll()+ ", and is already " + obj.poll());  
				System.out.print(" anything  he thinks \nhe'll need. As he is a very " + obj.poll()+ " cook, we are all hoping for the best. ");  
				System.out.print("So far, out of the " + obj.poll() + "dishes he made, \nmost turned out to be as hard as ");  
				System.out.println(obj.poll() + ". Hopefully this won't end with a trip to the hospital!\n\n");  
			}
			System.out.println("Do you want to play again? (yes or no)");
			play = read.nextLine();
		}
	}
}
