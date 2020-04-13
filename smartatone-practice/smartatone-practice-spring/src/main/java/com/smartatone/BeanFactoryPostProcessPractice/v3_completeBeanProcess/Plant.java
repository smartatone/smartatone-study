package com.smartatone.BeanFactoryPostProcessPractice.v3_completeBeanProcess;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Plant {
    private String name;

    public Plant() {
        System.out.println("Plant contruct()");
    }

    public void myInit() {
        System.out.println("【init-method】调用<bean>的init-method属性指定的初始化方法(Plant)");
    }
}
