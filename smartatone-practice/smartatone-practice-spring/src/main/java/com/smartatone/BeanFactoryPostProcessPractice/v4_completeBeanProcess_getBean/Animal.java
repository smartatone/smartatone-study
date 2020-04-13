package com.smartatone.BeanFactoryPostProcessPractice.v4_completeBeanProcess_getBean;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Animal {
    private String name;

    public Animal() {
        System.out.println("Animal contruct()");
    }

    public void myDestory() {
        System.out.println("【destroy-method】调用<bean>的destroy-method属性指定的初始化方法(Animal)");
    }
}
