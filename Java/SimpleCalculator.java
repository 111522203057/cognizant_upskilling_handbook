import java.util.*;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prompt for two numbers
        System.out.print("Enter the first number: ");
        double num1 = sc.nextDouble();

        System.out.print("Enter the second number: ");
        double num2 = sc.nextDouble();

        // Display operation options
        System.out.println("Choose an operation:");
        System.out.println(" + for Addition");
        System.out.println(" - for Subtraction");
        System.out.println(" * for Multiplication");
        System.out.println(" / for Division");
        System.out.print("Enter your choice: ");
        char operator = sc.next().charAt(0);

        double result;

        // Perform the selected operation
        switch(operator) {
            case '+':
                result = num1 + num2;
                System.out.println("Result: " + result);
                break;
            case '-':
                result = num1 - num2;
                System.out.println("Result: " + result);
                break;
            case '*':
                result = num1 * num2;
                System.out.println("Result: " + result);
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                    System.out.println("Result: " + result);
                } else {
                    System.out.println("Error: Cannot divide by zero.");
                }
                break;
            default:
                System.out.println("Invalid operation selected.");
        }

        
    }
}
