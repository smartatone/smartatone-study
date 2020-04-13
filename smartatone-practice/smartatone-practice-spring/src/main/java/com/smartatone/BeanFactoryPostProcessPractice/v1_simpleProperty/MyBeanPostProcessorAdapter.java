package com.smartatone.BeanFactoryPostProcessPractice.v1_simpleProperty;

import java.beans.PropertyDescriptor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.beans.factory.config.TypedStringValue;

/**
 * @author xuyang001
 * @Description: 处理器
 * @create 2020-04-13 22:20
 **/
public class MyBeanPostProcessorAdapter extends InstantiationAwareBeanPostProcessorAdapter {

    //修改属性值
    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean,
                                                    String beanName)
            throws BeansException {
        if (beanName.equals("simplePropertyDTO")) {
            for (PropertyValue propertyValue : pvs.getPropertyValues()) {
                Object value = propertyValue.getValue();
                if (value != null && value instanceof TypedStringValue) {
                    //注入属性类型必须为String类型
                    String originalValue = ((TypedStringValue) value).getValue();
                    ((TypedStringValue) value).setValue("new " + originalValue);
                }
            }
        }

        return pvs;
    }

}
