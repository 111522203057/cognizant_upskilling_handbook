import java.util.HashMap;
import java.util.Scanner;

public class StudentMap {
    public static void main(String[] args) {
        HashMap<Integer, String> studentMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String input;
        int id;

        System.out.println("Enter student ID and name (type 'done' to finish):");

        while (true) {
            System.out.print("Enter student ID: ");
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) break;
            try {
                id = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid ID. Please enter a number.");
                continue;
            }
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();
            studentMap.put(id, name);
        }

        System.out.print("Enter student ID to retrieve name: ");
        int searchId = scanner.nextInt();
        if (studentMap.containsKey(searchId)) {
            System.out.println("Student name: " + studentMap.get(searchId));
        } else {
            System.out.println("No student found with ID " + searchId);
        }

        scanner.close();
    }
}
