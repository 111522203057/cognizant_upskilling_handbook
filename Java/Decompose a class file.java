public class ReverseEngineerExample {
    private int number;
    private String text;

    public ReverseEngineerExample(int number, String text) {
        this.number = number;
        this.text = text;
    }

    public void display() {
        System.out.println("Number: " + number + ", Text: " + text);
    }

    public static void main(String[] args) {
        ReverseEngineerExample example = new ReverseEngineerExample(42, "Hello World");
        example.display();
    }
}
