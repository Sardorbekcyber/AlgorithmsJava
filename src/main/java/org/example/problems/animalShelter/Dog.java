package org.example.problems.animalShelter;

public class Dog extends Animal {
    public Dog(String n) {
        super(n);
    }

    public String name() {
        return "Dog: " + name;
    }
}