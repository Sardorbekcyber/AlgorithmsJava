package org.example.problems.animalShelter;

public class Cat extends Animal {
    public Cat(String n) {
        super(n);
    }

    public String name() {
        return "Cat: " + name;
    }
}