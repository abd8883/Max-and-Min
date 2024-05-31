package mathClass;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MaxAndMin {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            // Get the size of the array from the user
            int arraySize = getValue(scanner, "Enter the size of array");

            // Handle the case where the array size is less than or equal to zero
            if (arraySize <= 0) {
                System.out.println("Please enter a size greater than 0.");
                return;
            }

            // Initialize the array with the specified size
            int[] myArray = new int[arraySize];
            // Fill the array with values provided by the user
            myArray = fillArray(myArray, scanner, "The item");

            // Get the maximum value in the array
            int max = max(myArray);
            // Get the minimum value in the array
            int min = min(myArray);

            // Display the maximum and minimum values
            System.out.println("The maximum is: " + max);
            System.out.println("The minimum is: " + min);
        } finally {
            // Close the scanner to free up resources
            scanner.close();
        }
    }

    // Method to get an integer value from the user with error handling
    private static int getValue(Scanner scanner, String prompt) {
        int value = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                // Prompt the user to enter a value
                System.out.println(prompt + ": ");
                value = scanner.nextInt();
                validInput = true; // Exit the loop if a valid integer is entered
            } catch (InputMismatchException e) {
                // Handle invalid input and prompt the user again
                System.out.println("Invalid input.");
                scanner.next(); // Clear the invalid input to avoid an infinite loop
            }
        }
        return value; // Return the valid integer
    }

    // Method to fill the array with values provided by the user
    private static int[] fillArray(int[] array, Scanner scanner, String prompt) {
        for (int i = 0; i < array.length; i++) {
            // Get a value for each element in the array
            array[i] = getValue(scanner, prompt + " " + (i + 1));
        }
        return array; // Return the filled array
    }

    // Method to find the minimum value in the array
    private static int min(int[] array) {
        int min = array[0];
        // Iterate through the array to find the minimum value
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min; // Return the minimum value
    }

    // Method to find the maximum value in the array
    private static int max(int[] array) {
        int max = array[0];
        // Iterate through the array to find the maximum value
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        return max; // Return the maximum value
    }
}
