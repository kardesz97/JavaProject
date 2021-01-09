package hu.ak_akademia.fibonacci;
import java.util.Scanner;

public class PruductOfTwoNumbersÓrai {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("Kérem, adja meg, hogy hanyadik Fibonacci számot irja ki: ");
		int a = scanner.nextInt();
		long c = 0L;
		long d = 1L;
		for (int i = 2; i <= 82; i++) {
			long sum = c + d;
			c = d;
			d = sum;
			if (i == a)
				System.out.println("A " + a + ". Fibonacci szám " + sum + ".");

		}
	}

}
