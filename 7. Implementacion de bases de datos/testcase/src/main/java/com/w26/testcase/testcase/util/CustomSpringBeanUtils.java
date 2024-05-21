package com.w26.testcase.testcase.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

import org.springframework.beans.BeanUtils;

public class CustomSpringBeanUtils {
    // Método para copiar propiedades no nulas de un objeto a otro
    public static void copyNonNullProperties(Object src, Object target) {
        // Obtener los descriptores de propiedades del objeto fuente
        PropertyDescriptor[] propertyDescriptors = BeanUtils.getPropertyDescriptors(src.getClass());

        // Iterar sobre cada descriptor de propiedad
        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            try {
                // Obtener los métodos de lectura y escritura de la propiedad
                Method readMethod = propertyDescriptor.getReadMethod();
                Method writeMethod = propertyDescriptor.getWriteMethod();

                // Verificar si ambos métodos (lectura y escritura) están disponibles
                if (readMethod != null && writeMethod != null) {
                    // Invocar el método de lectura para obtener el valor de la propiedad
                    Object value = readMethod.invoke(src);

                    // Si el valor no es nulo, invocar el método de escritura para asignar el valor al objeto destino
                    if (value != null) {
                        writeMethod.invoke(target, value);
                    }
                }
            } catch (Exception e) {
                // Manejar cualquier excepción que pueda ocurrir durante la reflexión
                e.printStackTrace();
            }
        }
    }
}
