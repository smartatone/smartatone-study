package com.smartatone.BeanFactoryPostProcessPractice.v2_complicateProperty.test2;

import lombok.Data;

@Data
public class Person {

    private String name = "person";

    Person() {
        System.out.println("method person(),name---->" + name);
    }

    public void init() {
        System.out.println("method init(),name---->" + name);
    }

    public void sayName() {
        System.out.println("method sayName(),name---->" + name);
    }
}
