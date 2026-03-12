package Homework1;

public final class ImmutableClass {

    private final Person person;

    public ImmutableClass(Person person) {
        this.person = new Person(person.getName(), person.getAge());
    }

    public Person getPerson() {
        return new Person(person);
    }

    public void printInfo(){
        System.out.println("ImmutableClass: name = " + person.getName() + ", age = " + person.getAge());
    }
}
