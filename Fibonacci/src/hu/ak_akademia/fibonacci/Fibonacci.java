package hu.ak_akademia.fibonacci;

public class Fibonacci {

	public static void main(String[] args) {
		int c = 0;
		int d = 1;
		System.out.println("Fibonacci " + 0 + "." + "száma" + " a " + 0);
		System.out.println("Fibonacci " + 1 + "." + "száma" + " a " + 0);
		for (int i = 2; i <= 45; i++) {
			int sum = c + d;
			c = d;
			d = sum;
			System.out.println("Fibonacci " + i + "." + "száma" + " a " + sum);
		}
		System.out.println();
		int a = 1134903170;
		int b = 701408733;
		System.out.println("Fibonacci " + 45 + "." + "száma" + " a " + a);
		System.out.println("Fibonacci " + 44 + "." + "száma" + " a " + b);
		for (int n = 45; n >= 2; n--) {
			int sum = a - b;
			a = b;
			b = sum;
			System.out.println("Fibonacci " + (n - 2) + "." + "száma" + " a " + sum);
		}
	}
}
