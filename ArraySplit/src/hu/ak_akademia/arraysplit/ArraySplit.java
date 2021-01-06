package hu.ak_akademia.arraysplit;
import java.util.Arrays;

public class ArraySplit {

	public static void main(String[] args) {
		int[] numbers = { 18, 11, 5, 22, 5, 7,0 };
		int newSizeFirstHalf = numbers.length / 2;
		int newSizeSecondHalf = numbers.length -newSizeFirstHalf;
		int[] newNumbers1 = new int[newSizeFirstHalf];
		int[] newNumbers2 = new int[newSizeSecondHalf];
		for (int i = 0; i < numbers.length; i++) {
			if (i < newSizeFirstHalf) {
				newNumbers1[i] = numbers[i];
			} else {
				newNumbers2[i - newSizeFirstHalf] = numbers[i];
			}
		}
		System.out.println("The array : " + Arrays.toString(numbers));
		System.out.println("First half : " + Arrays.toString(newNumbers1));
		System.out.println("Seccond half : " + Arrays.toString(newNumbers2));
	}
}
