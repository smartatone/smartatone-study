package com.smartatone.BeanFactoryPostProcessPractice.v1_simpleProperty;

import lombok.Data;
import lombok.ToString;

/**
 * @author xuyang001
 * @Description: 简单属性DTO
 * @create 2020-04-13 22:18
 **/
@Data
@ToString
public class SimplePropertyDTO {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
