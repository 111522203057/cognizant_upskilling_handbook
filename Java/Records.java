import java.util.List;
import java.util.stream.Collectors;

public class RecordDemo {
    public record Person(String name, int age) {}

    public static void main(String[] args) {
        Person p1 = new Person("Alice", 30);
        Person p2 = new Person("Bob", 22);
        Person p3 = new Person("Charlie", 18);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        List<Person> people = List.of(p1, p2, p3);

        List<Person> adults = people.stream()
                                    .filter(person -> person.age() >= 21)
                                    .collect(Collectors.toList());

        System.out.println("Adults (age 21+):");
        adults.forEach(System.out::println);
    }
}
