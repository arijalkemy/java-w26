package org.example.integradorcaloriescalculator.repository;


import java.io.IOException;
import java.util.List;

public interface IDishRepository <I>{

    public List<I> loadData() throws IOException;

}
