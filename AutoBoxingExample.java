//Write a Java program to calculate the sum of a list of integers using autoboxing and unboxing. Include methods to parse strings into their respective wrapper classes (e.g., Integer.parseInt()).

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AutoBoxingExample {

    // Method to parse a string into an Integer
    public static Integer parseStringToInteger(String str) {
        try {
            return Integer.parseInt(str);  // Autoboxing: int to Integer
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format: " + str);
            return 0; // Return 0 for invalid inputs
        }
    }

    // Method to calculate the sum of a list of integers
    public static int calculateSum(List<Integer> numbers) {
        int sum = 0;
        for (Integer num : numbers) {
            sum += num; // Unboxing: Integer to int
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();

        System.out.println("Enter numbers (type 'done' to finish):");

        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            numbers.add(parseStringToInteger(input)); // Autoboxing
        }

        scanner.close();

        int totalSum = calculateSum(numbers);
        System.out.println("The sum of the numbers is: " + totalSum);
    }
}