package hangman;

import java.util.Scanner;

public class hangman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		LinkedList list = new LinkedList();
		String word, guess;
		char key;
		int operation, count = 0;

		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Welcome to Hangman game");
		System.out.println(
				"According the rule of game you have 14 guesses right\nIf you do not know within fourteen rights, you will lose the game.");
		System.out.println(
				"You have the right to exit halfway through the game.\nHint:Lower and upper characters are not important both are correct\nHave a good fun");
		System.out.println(
				"If you are entering more than one word, you should write the words together by putting '_' in the blanks.\nFor example: \"ufuk_yilmaz\"");
		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------------");

		System.out.println("Please enter word:");
		word = keyboard.nextLine();
		for (int i = 0; i < word.length(); i++) {
			System.out.print("_  ");
			Node n = new Node(word.charAt(i));
			list.add(n);
		}
		System.out.println("");
		do {
			System.out.println(
					"Press 1 if you want to guess word.\nPress 2 if you want to guess letters.\nPress 3 if you want to exit the game");
			operation = keyboard.nextInt();
			if (operation == 1) {
				System.out.println("Your word guess is");
				guess = keyboard.next();
				keyboard.nextLine();
				if (list.checkWord(guess)) {
					System.out.println("You found the word\nGame over!");
					break;
				} else {
					// System.out.println(word);
					System.out.println("your guess is wrong");
					count++;
				}
			}
			if (operation == 2) {
				System.out.println("Please enter a letter");
				key = keyboard.next().charAt(0);
				list.findingChar(key);
				list.print();
				count++;

			}
			if (operation == 3) {
				System.out.println("You left the game");
				break;
			}

		} while (count < 14);
		if (count == 14) {
			System.out.println("You lost the game because your right is fully ended!");
		}

	}

}
