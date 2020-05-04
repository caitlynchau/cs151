package part3;

import java.util.Random;

public class Television {

	public void changeChannel() {
		Random rand = new Random();
		Channel c = Channel.values()[rand.nextInt(Channel.values().length)];
		switch (c) {
			case NBC:
				System.out.println("Welcome to America's favorite question and answer show, Jeopardy");
				break;
			case ABC:
				System.out.println("24 hour Harry Potter marathon starting now");
				break;
			case MSNBC:
				System.out.println("Tesla stocks plummet after Elon Musk tweet");
				break;
			case FOOD:
				System.out.println("Let's take a trip to flavor town");
				break;
			case HBO:
				System.out.println("Westworld season 4 premier starting now");
				break;
		}
	}
	
	public static void main(String[] args) {
		Television tv = new Television();
		for (int i = 0; i < 5; i++) {
			tv.changeChannel();
		}
		
	}
}
