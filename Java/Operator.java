public class ExpressionEvaluation {
    public static void main(String[] args) {
        // Example 1: Multiplication before addition
        int result1 = 10 + 5 * 2;
        System.out.println("Result1 (10 + 5 * 2): " + result1); // 10 + (5 * 2) = 20

        // Example 2: Using parentheses to change precedence
        int result2 = (10 + 5) * 2;
        System.out.println("Result2 ((10 + 5) * 2): " + result2); // (10 + 5) * 2 = 30

        // Example 3: Division and subtraction
        int result3 = 20 - 8 / 4;
        System.out.println("Result3 (20 - 8 / 4): " + result3); // 20 - (8 / 4) = 18

        // Example 4: Modulus with addition
        int result4 = 15 + 10 % 4;
        System.out.println("Result4 (15 + 10 % 4): " + result4); // 15 + (10 % 4) = 17
    }
}
