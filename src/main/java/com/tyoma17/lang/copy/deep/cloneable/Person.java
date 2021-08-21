package com.tyoma17.lang.copy.deep.cloneable;

public class Person implements Cloneable {

    private String name;
    private int age;
    private Dog dog;

    public Person(String name, int age, Dog dog) {
        this.name = name;
        this.age = age;
        this.dog = dog;
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

    @Override
    public Object clone() throws CloneNotSupportedException {

        Person person = (Person) super.clone();
        person.dog = (Dog) dog.clone();

        return person;
    }
}
