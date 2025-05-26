import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        // Create Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter marks
        System.out.print("Enter your marks (out of 100): ");
        int marks = scanner.nextInt();

        // Assign grade based on marks using if-else statements
        if (marks >= 90 && marks <= 100) {
            System.out.println("Grade: A");
        } else if (marks >= 80 && marks <= 89) {
            System.out.println("Grade: B");
        } else if (marks >= 70 && marks <= 79) {
            System.out.println("Grade: C");
        } else if (marks >= 60 && marks <= 69) {
            System.out.println("Grade: D");
        } else if (marks >= 0 && marks < 60) {
            System.out.println("Grade: F");
        } else {
            System.out.println("Invalid marks. Please enter a value between 0 and 100.");
        }

        // Close the scanner
        scanner.close();
    }
}
