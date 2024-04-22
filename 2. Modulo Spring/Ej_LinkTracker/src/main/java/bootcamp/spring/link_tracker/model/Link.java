package bootcamp.spring.link_tracker.model;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Link{
	Integer id;
    String url;
    Integer vecesRedireccionado;
    Boolean habilitado;
    String password;

    public Link(Integer id, String url){
        this.id = id;
        this.url = url;
        this.vecesRedireccionado = 0;
        this.habilitado = true;
        this.password = "ok";
    }

    public void aumentarVecesRedireccionado() {
        if(Objects.isNull(vecesRedireccionado)){
            this.vecesRedireccionado = 0;
        }
        this.vecesRedireccionado++;
    }
}
