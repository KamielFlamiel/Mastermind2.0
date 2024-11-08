package mastermind2_0;

import java.util.Scanner;
import java.util.Random;

public class Mastermind {
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int black = 7;
		int white = 8;
		int empty = 0;

		int[] makerCombinationAnswer = new int[4];
		int verify;
		Random rand = new Random();

		for (int i = 0; i < makerCombinationAnswer.length; i++) {
			int in = rand.nextInt(6) + 1;
			makerCombinationAnswer[i] = in;
		}
		
		System.out.println("" + makerCombinationAnswer[0] + makerCombinationAnswer[1] + makerCombinationAnswer[2] + makerCombinationAnswer[3]);
		System.out.println(" ");
		System.out.println("The maker has made a combination");
		System.out.println("Red = 1. " + "Blue = 2. " + "Yellow = 3. " + "Purple = 4. " + "Green = 5. " + "Orange = 6. ");
		System.out.println("Place a colour you want by pressing the number");
		System.out.println("Try to guess the Maker's combination");

		int[] breakerSpaces = new int[4];
		int round = 0;
		int roundOpposite = 10;

		do {

			for (int i = 0; i < breakerSpaces.length; i++) {
				int in = input.nextInt();

				if (in >= 6) {
					in = 6;
				} else if (in <= 1) {
					in = 1;
				}
				breakerSpaces[i] = in;
			}
			System.out.println("" + breakerSpaces[0] + breakerSpaces[1] + breakerSpaces[2] + breakerSpaces[3]);

			int[] checkSpaces = { -1, -1, -1, -1 };

			verify = breakerSpaces[0];

			int randomnum = rand.nextInt(4);
			int check = breakerSpaces[randomnum];

			while (check != -1) {
				randomnum = rand.nextInt(4);
				check = checkSpaces[randomnum];
			}

			if (verify == makerCombinationAnswer[0]) {
				checkSpaces[0] = white; 
			} else {
				if (verify == makerCombinationAnswer[1] || verify == makerCombinationAnswer[2]
						|| verify == makerCombinationAnswer[3]) {

					checkSpaces[0] = black;
				} else {
					checkSpaces[0] = empty;
				}
			}
			randomnum = rand.nextInt(4);
			verify = breakerSpaces[1];

			if (verify == makerCombinationAnswer[1]) {
				checkSpaces[1] = white;

			} else {
				if (verify == makerCombinationAnswer[1] || verify == makerCombinationAnswer[2]
						|| verify == makerCombinationAnswer[3])
					checkSpaces[1] = black;

				else {
					checkSpaces[1] = empty;
				}

			}
			randomnum = rand.nextInt(4);
			verify = breakerSpaces[2];
			
			if (verify == makerCombinationAnswer[2]) {
				checkSpaces[2] = white;

			} else {
				if (verify == makerCombinationAnswer[1] || verify == makerCombinationAnswer[2]
						|| verify == makerCombinationAnswer[3])
					checkSpaces[2] = black;

				else {
					checkSpaces[2] = empty;
				}
			}
			randomnum = rand.nextInt(4);
			verify = breakerSpaces[3];
			
			if (verify == makerCombinationAnswer[3]) {
				checkSpaces[3] = white;
			} else {
				if (verify == makerCombinationAnswer[1] || verify == makerCombinationAnswer[2]
						|| verify == makerCombinationAnswer[3])
					checkSpaces[3] = black;

				else {
					checkSpaces[3] = empty;
				}
			}	

			System.out.println("8 is white and 7 is black");
			System.out.println("if a space is white then you guessed right, if it's black then it's right but in the wrong position and if it's empty, then you guessed wrong");
			System.out.println("" + checkSpaces[0] + checkSpaces[1] + checkSpaces[2] + checkSpaces[3]);

			if (checkSpaces[0] == white && checkSpaces[1] == white && checkSpaces[2] == white
					&& checkSpaces[3] == white) {
				System.out.println("Breaker wins.");
				break;
			}

			else {
				round++;
			}
			roundOpposite--;
			System.out.println("Round " + round);
			System.out.println("You have " + roundOpposite + " tries left");

		} while (round < 10);
		
		System.out.println("Out of turns, Maker wins");

	}

}
