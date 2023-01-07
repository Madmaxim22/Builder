package org.example;

import java.util.Objects;

public class Person {

    protected final String name;
    protected final String surname;
    protected int age;
    protected String city;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Person(String name, String surname, String city) {
        this.name = name;
        this.surname = surname;
        this.city = city;
    }

    public Person(String name, String surname, int age, String city) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.city = city;
    }

    void happyBirthday() {
        this.age += 1;
    }

    boolean hasAge() {
        return this.age != 0;
    }

    boolean hasAddress() {
        return this.city != null && !this.city.isEmpty();
    }

    void setAddress(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAge() {
        if (age != 0) return Integer.toString(age);
        return "unknown";
    }

    public String getCity() {
        if (city != null) return city;
        return "unknown";
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(this.surname)
                .setAddress(this.city)
                .setAge(this.age / 3);
    }

    @Override
    public String toString() {
        if (age == 0 && city == null) {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", age='unknown'" +
                    ", city='unknown'" +
                    '}';
        } else if (city == null) {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", age=" + age +
                    ", city='unknown'" +
                    '}';
        } else if (age == 0) {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", age='unknown'" +
                    ", city='" + city + '\'' +
                    '}';
        } else {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", age=" + age +
                    ", city='" + city + '\'' +
                    '}';
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getAge() == person.getAge() && Objects.equals(getName(), person.getName()) && Objects.equals(getSurname(), person.getSurname()) && Objects.equals(getCity(), person.getCity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getAge(), getCity());
    }
}
