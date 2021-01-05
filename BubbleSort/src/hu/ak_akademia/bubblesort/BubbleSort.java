package hu.ak_akademia.bubblesort;
import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int[] numbers = { 18, 5, 6, 22, 5, -2, 9, 21, -5 };
		System.out.println("Rendezetlen tömb:");
		System.out.println(Arrays.toString(numbers));
		for (int j = 0; j < numbers.length - 1; j++) {
			for (int i = 0; i < numbers.length - 1 - j; i++) {
				if (numbers[i] > numbers[i + 1]) {
					int temp = numbers[i];
					numbers[i] = numbers[i + 1];
					numbers[i + 1] = temp;
				}
			}
		}
		System.out.println("Rendezett tömb:");
		System.out.println(Arrays.toString(numbers));
	}
}
