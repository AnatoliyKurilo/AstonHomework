//import Homework1.ImmutableClass;
//import Homework1.MutableClass;
//import Homework1.Person;

import ru.aston.Hometask1.ImmutableClass;
import ru.aston.Hometask1.MutableClass;
import ru.aston.Hometask1.Person;
import ru.aston.hometask2.Book;
import ru.aston.hometask2.Student;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

void main() {
//    hometask1();

    hometask2();


}

private static void hometask2() {
    File file = new File("src/main/resources/students.json");

    ObjectMapper objectMapper = new ObjectMapper();

    System.out.println("Привыффвыфет");
    List<Student> students;
    try {
        students = objectMapper.readValue(file, new TypeReference<List<Student>>() {
        });
    } catch (IOException e) {
        throw new RuntimeException(e);
    }

    Optional<Integer> result = students.stream()
            .peek(System.out::println)
            .flatMap(student -> student.getBooks().stream())
            .sorted((b1,b2)-> Integer.compare(b1.getPages(),b2.getPages()))
            .distinct()
            .filter(b->b.getYear()>2000)
            .limit(3)
            .map(Book::getYear)
            .findFirst();

    result.ifPresentOrElse(
            year -> System.out.println("Найден год выпуска: " + year),
            () -> System.out.println("Такая книга отсутствует")
    );
}

private static void hometask1() {
    Person p = new Person("Bob", 20);

    MutableClass mutClass = new MutableClass(p);
    ImmutableClass immClass = new ImmutableClass(p);

    p.printInfo();
    mutClass.printInfo();
    immClass.printInfo();

    p.setName("Jon Doe");
    p.setAge(55);

    p.printInfo();
    mutClass.printInfo();
    immClass.printInfo();

}
