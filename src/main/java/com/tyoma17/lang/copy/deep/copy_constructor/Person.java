package com.tyoma17.lang.copy.deep.copy_constructor;

public class Person {

    private String name;
    private int age;
    private Dog dog;

    public Person(String name, int age, Dog dog) {
        this.name = name;
        this.age = age;
        this.dog = dog;
    }

    public Person(Person that) {
        this(that.name, that.age, new Dog(that.dog));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
}
