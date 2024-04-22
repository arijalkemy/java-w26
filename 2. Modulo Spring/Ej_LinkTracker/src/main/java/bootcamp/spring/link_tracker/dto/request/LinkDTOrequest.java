package bootcamp.spring.link_tracker.dto.request;

import java.io.Serializable;

import lombok.Data;

@Data
public class LinkDTOrequest implements Serializable {
    private String url;

    public LinkDTOrequest(String url){
        this.url = url;
    }

    public LinkDTOrequest(){}
}
