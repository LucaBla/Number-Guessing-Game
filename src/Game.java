import java.util.Random;
import java.util.Scanner;

public class Game {

	private static Random random = new Random();
	private static int guessNumber;
	private static int in;
	
	public static void start() {
		
		System.out.println("Pls give a maximum that the Number"
				+ " you will be guessing should not exceed.");
		
		Scanner s = new Scanner(System.in);
		in= s.nextInt() + 1;
		guessNumber = random.nextInt(in);
		System.out.println(guessNumber);
		s.close();
		
	}
	
	public static void game() {
		
		int n = -1;
		int attempts = 0;
		
		while(n != guessNumber) {
			
			System.out.println("Pls Enter the number you are guessing.");
			Scanner s = new Scanner(System.in);
			n= s.nextInt();
			
			if(n<guessNumber) {
				
				System.out.println("The guessed number is smaller.\n");
				attempts++;
		
			}
			
			else if(n>guessNumber) {
			
				System.out.println("The guessed number is bigger.\n");
				attempts++;
			
			}
			
			else if(n==guessNumber) {

				System.out.println("You guessed the Number congratulations!!!!!!!");
				System.out.println("You needed " + attempts + " attempts.");
				
			}
			s.close();
		}
		
	}
	
	/*public static void main(String[] args) {
		start();
		game();
		asdasd
		sadasd
		asdsa
		
	}*/

}
