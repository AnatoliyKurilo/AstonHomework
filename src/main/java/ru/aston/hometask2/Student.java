package ru.aston.hometask2;

import java.util.List;

public class Student {
    private String name;
    private List<Book> books;

    public Student() {
    }

    public Student(List<Book> books, String name) {
        this.books = books;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Student{" + "name='" + name + '\'' + ", books=" + books + '}';
    }
}
