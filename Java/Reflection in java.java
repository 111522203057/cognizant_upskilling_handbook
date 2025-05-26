import java.lang.reflect.Method;

public class ReflectionExample {

    public void greet(String name) {
        System.out.println("Hello, " + name + "!");
    }

    public int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        try {
            // Load the class dynamically
            Class<?> clazz = Class.forName("ReflectionExample");

            // Create an instance using the no-arg constructor
            Object instance = clazz.getDeclaredConstructor().newInstance();

            // Get all declared methods
            Method[] methods = clazz.getDeclaredMethods();

            // Print method names and parameters
            for (Method method : methods) {
                System.out.print("Method: " + method.getName() + "(");
                Class<?>[] params = method.getParameterTypes();
                for (int i = 0; i < params.length; i++) {
                    System.out.print(params[i].getSimpleName());
                    if (i < params.length - 1) System.out.print(", ");
                }
                System.out.println(")");
            }

            // Invoke the greet method dynamically
            Method greetMethod = clazz.getDeclaredMethod("greet", String.class);
            greetMethod.invoke(instance, "Alice");

            // Invoke the add method dynamically and print result
            Method addMethod = clazz.getDeclaredMethod("add", int.class, int.class);
            int sum = (int) addMethod.invoke(instance, 5, 7);
            System.out.println("Sum: " + sum);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
