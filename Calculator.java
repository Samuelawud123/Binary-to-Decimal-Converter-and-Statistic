import java.util.Scanner;
/**
 * The class is to help user convert binary  numbers into decimals
 * and later report the statistic information (max, min, median, average)
 
 * @author Varik Hoang <varikmp@uw.edu>
 * @author Samuel Awud <samuelawud@seattlecolleges.edu>
 * @version __________
 */

public class Calculator {
    // Interactive program to convert binary numbers to decimal and calculate statistics

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char choice;

        do {
            startEnteringBinaryNumbers(scanner);

            System.out.print("Would you like to try again [Y or y for yes]? ");
            choice = scanner.next().charAt(0);
        } while (Character.toLowerCase(choice) == 'y');

        System.out.println("Thank you for using the program");
        scanner.close();
    }

    // Starts the process of entering binary numbers and calculating statistics
    public static void startEnteringBinaryNumbers(Scanner scanner) {
        int minimum = Integer.MAX_VALUE;
        int maximum = Integer.MIN_VALUE;
        int sum = 0;
        int count = 0;

        System.out.print("How many binary numbers would you like to enter? ");
        int numBinary = scanner.nextInt();

        for (int i = 0; i < numBinary; i++) {
            String binary = enterBinaryNumber(scanner);
            int decimal = convertBinaryToDecimal(binary);

            minimum = Math.min(minimum, decimal);
            maximum = Math.max(maximum, decimal);
            sum += decimal;
            count++;

            System.out.println("The binary number you just entered has decimal value " + decimal);
        }

        double average = (double) sum / count;

        System.out.println("The sum is " + sum);
        System.out.println("The minimum value is " + minimum);
        System.out.println("The maximum value is " + maximum);
        System.out.println("The average is " + average);
    }

    // Prompts the user to enter a binary number 
    public static String enterBinaryNumber(Scanner scanner) {
        System.out.print("Enter the binary number: ");
        return scanner.next();
    }

    // Converts a binary number to its decimal value and returns it
    public static int convertBinaryToDecimal(String binaryNumber) {
        int decimal = 0;
        int power = binaryNumber.length() - 1;

        for (int i = 0; i < binaryNumber.length(); i++) {
            int digit = binaryNumber.charAt(i) - '0';
            decimal += digit * Math.pow(2, power);
            power--;
        }

        return decimal;
    }
}