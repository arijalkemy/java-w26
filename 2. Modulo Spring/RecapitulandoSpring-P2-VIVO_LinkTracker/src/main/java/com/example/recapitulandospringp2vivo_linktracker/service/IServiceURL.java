package com.example.recapitulandospringp2vivo_linktracker.service;

import com.example.recapitulandospringp2vivo_linktracker.dto.URLdto;
import com.example.recapitulandospringp2vivo_linktracker.model.URL;

import java.util.Map;

public interface IServiceURL {

    public URLdto addURL(URL url);

    public Map<String, URLdto> getAllUrl();

    public String redirectURL(String linkID);

    public Integer getNumberOfRedirects(String linkId);

    public String invalidateURL(String linkId);
}
