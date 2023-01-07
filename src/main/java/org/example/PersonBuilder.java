package org.example;

public class PersonBuilder {

    private String name;
    private String surname;
    private int age;
    private String city;

    public PersonBuilder setName(String name) {
        this.name = name.trim();
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname.trim();
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age >= 0) {
            this.age = age;
            return this;
        } else {
            throw new IllegalArgumentException("Недопустимый возвраст");
        }
    }

    public PersonBuilder setAddress(String city) {
        this.city = city.trim();
        return this;
    }

    public Person build() {
        if ((name != null && !name.isEmpty()) && (surname != null && !surname.isEmpty())) {
            if (age == 0 && (city == null || city.isEmpty())) {
                return new Person(name, surname);
            } else if (city == null || city.isEmpty()) {
                return new Person(name, surname, age);
            } else if (age == 0) {
                return new Person(name, surname, city);
            } else {
                return new Person(name, surname, age, city);
            }
        } else {
            throw new IllegalArgumentException("Не хватает обязательных полей");
        }
    }
}
