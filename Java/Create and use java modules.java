// Single file without modules but demonstrating usage of separate classes

class Utility {
    public static String greet(String name) {
        return "Hello, " + name + "!";
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Utility.greet("World"));
    }
}
