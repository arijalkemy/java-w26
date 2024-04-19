package com.example.recapitulandospringp2vivo_linktracker.repository;

import com.example.recapitulandospringp2vivo_linktracker.dto.URLdto;
import com.example.recapitulandospringp2vivo_linktracker.model.URL;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class URLRepository {

    public Map<String, URLdto> listURL = new HashMap<>();

    public Map<String, URLdto> getAllUrl() {
        return listURL;
    }

    public String addURL(URLdto url) {
       String urlID = UUID.randomUUID().toString();
       listURL.put(urlID, url);
       return urlID;
    }

    public String invalidateURL(String id) {
        listURL.remove(id);
        return "Success deleted";
    }

}
