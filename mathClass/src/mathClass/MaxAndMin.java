package mathClass;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MaxAndMin {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			// Get the size of the array
			int arraySize = getValue(scanner, "Enter the size of array");

			// Handle case where array size is zero
			if (arraySize <= 0) {
				System.out.println("Please enter a size greater than 0.");
				return;
			}

			// Initialize and populate the array
			int[] myArray = new int[arraySize];
			myArray = fillArray(myArray, scanner, "The item");

			// Get the maximum and minimum values of the array
			int max = max(myArray);
			int min = min(myArray);

			// Display the results
			System.out.println("The maximum is: " + max);
			System.out.println("The minimum is: " + min);
		}

		finally {
			scanner.close();
		}

	}

    // This function is used to get a value from user and check if it is correct and in the correct range.
	private static int getValue(Scanner scanner, String prompt) {
		int value = 0;
		boolean validInput = false;
		while (!validInput) {
//        	Use try and catch to ensure that user enter an integer.
			try {
				System.out.println(prompt + ": ");
				value = scanner.nextInt();
				validInput = true;
			} catch (InputMismatchException e) {
				System.out.println("Invalid input.");
//					To make sure that program doesn't enter to an infinite loop.
				scanner.next();
				continue;
			}

		}
		return value;
	}

	private static int[] fillArray(int[] array, Scanner scanner, String prompt) {
		for (int i = 0; i < array.length; i++) {
			array[i] = getValue(scanner, prompt + " " + (i + 1));
		}
		return array;
	}

//This function take three variable and compare between them to return the min value.
	private static int min(int[] array) {
		int min = array[0];
		for (int i = 0; i < array.length; i++) {
			if (min > array[i]) {
				min = array[i];
			}
		}
		return min;

	}

	// This function take three variable and compare between them to return the max
	// value.
	private static int max(int[] array) {
		int max = array[0];
		for (int i = 0; i < array.length; i++) {
			if (max < array[i]) {
				max = array[i];
			}
		}
		return max;
	}
}
