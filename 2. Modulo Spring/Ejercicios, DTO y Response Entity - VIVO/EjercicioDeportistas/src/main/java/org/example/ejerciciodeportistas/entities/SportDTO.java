package org.example.ejerciciodeportistas.entities;
import lombok.Data;
import java.io.Serializable;

@Data
public class SportDTO implements Serializable {
    private String name;
    private int level;
}
