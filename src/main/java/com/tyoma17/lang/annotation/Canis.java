package com.tyoma17.lang.annotation;

@NotInheritedClassLevelAnnotation
@InheritedClassLevelAnnotation
public class Canis {

    private String name;

    public Canis(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
