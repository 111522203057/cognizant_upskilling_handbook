public class SimpleClass {
    // Method that adds two integers and returns the sum
    public int add(int a, int b) {
        return a + b;
    }

    // Main method to test the add method
    public static void main(String[] args) {
        SimpleClass sc = new SimpleClass();
        int result = sc.add(5, 3);
        System.out.println("Sum: " + result);
    }
}
