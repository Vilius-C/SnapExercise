package io.github.viliuschockevicius.snapExercise;

import java.util.Scanner;

/**
 * The main class that is used to start the game of snap and restart it once it concludes
 * @author Vilius Chockevicius
 */
public class Main {
    
    public static void main(String[] args) {
		Game game = new Game("Sam", "Elliot");
		Scanner in = new Scanner(System.in);
		
		boolean restart = true;
		while(restart) {
			game.play();
			
			System.out.print("The game has ended, press Y to restart or anything else to stop playing.");
			
			if (!in.nextLine().equalsIgnoreCase("y")) {
				restart = false;
			}
			
		}
		in.close();
		
	}
    
}
