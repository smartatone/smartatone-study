package com.smartatone.BeanFactoryPostProcessPractice.v2_complicateProperty;

import java.util.Properties;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class ConsumerBean {

    private Properties properties;

    public void start() throws Exception {
        if (null == this.properties) {
            throw new Exception("properties not set");
        }
        createConsumer(this.properties);
    }

    private void createConsumer(Properties properties) {
        System.out.println("createConsumer start,properties " + "name=" + properties.getProperty("name"));
    }

}
