import java.util.Scanner;

public class Multiplication{
    public static void main(String[] args) {
        // Create Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for a number
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();

        // Use a for loop to print the multiplication table up to 10
        for (int i = 1; i <= 10; i++) {
            int result = num * i;
            System.out.println(num + " x " + i + " = " + result);
        }

        // Close the scanner
        scanner.close();
    }
}
