package ru.aston.Hometask1;

public final class MutableClass {

    private final Person person;

    public MutableClass(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void printInfo(){
        System.out.println( "MutableClass: name = " + person.getName() + ", age = " + person.getAge());
    }
}
