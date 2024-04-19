package org.example.integradorcaloriescalculator.service;

import java.util.List;

public interface IDishService <T, K>{

    public T getDataInfo(K k);
    public List<T> getMassiveInfo(List<K> k);
}



