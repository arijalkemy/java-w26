package com.w26.students.students.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

import org.springframework.beans.BeanUtils;

public class CustomSpringBeanUtils {

    public static void copyNonNullProperties(Object src, Object target) {
        PropertyDescriptor[] propertyDescriptors = BeanUtils.getPropertyDescriptors(src.getClass());

        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            try {
                Method readMethod = propertyDescriptor.getReadMethod();
                Method writeMethod = propertyDescriptor.getWriteMethod();

                if (readMethod != null && writeMethod != null) {
                    Object value = readMethod.invoke(src);
                    if (value != null) {
                        writeMethod.invoke(target, value);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
