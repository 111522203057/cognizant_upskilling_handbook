public class TypeCastingExample {
    public static void main(String[] args) {
        // Declare a double variable with a decimal value
        double myDouble = 9.78;

        // Cast the double to an int (narrowing conversion)
        int myInt = (int) myDouble;

        // Display the result of casting double to int
        System.out.println("Original double: " + myDouble);
        System.out.println("After casting to int: " + myInt);

        // Declare an int variable
        int anotherInt = 42;

        // Cast the int to a double (widening conversion)
        double anotherDouble = (double) anotherInt;

        // Display the result of casting int to double
        System.out.println("Original int: " + anotherInt);
        System.out.println("After casting to double: " + anotherDouble);
    }
}
