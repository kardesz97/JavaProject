package hu.ak_akademia.digitalclock;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		new Main().run();
	}

	private void run() {
		try (Scanner scanner = new Scanner(System.in)) {
			DigitalClock digitalClock = new DigitalClock(22, 59, 57);
			try {
				do {
					Thread.sleep(1000L);
					digitalClock.tickSecond();
					System.out.println(digitalClock);

				} while (true);

			} catch (InterruptedException e) {
			}
		}
	}

}
