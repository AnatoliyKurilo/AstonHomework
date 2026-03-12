import Homework1.ImmutableClass;
import Homework1.MutableClass;
import Homework1.Person;

void main() {
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
