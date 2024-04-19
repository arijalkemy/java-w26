package com.example.recapitulandospringp2vivo_linktracker.service;

import com.example.recapitulandospringp2vivo_linktracker.dto.URLdto;
import com.example.recapitulandospringp2vivo_linktracker.exception.NotFoundException;
import com.example.recapitulandospringp2vivo_linktracker.model.URL;
import com.example.recapitulandospringp2vivo_linktracker.repository.URLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ServiceURLImpl implements IServiceURL{

    @Autowired
    URLRepository urlRepository;

    @Override
    public URLdto addURL(URL url) {
        URLdto urlSend = new URLdto(url.getPath());
        String idOfURL = urlRepository.addURL(urlSend);
        urlSend.setId(idOfURL);

        return urlSend;

    }

    @Override
    public Map<String, URLdto> getAllUrl() {
        return urlRepository.getAllUrl();
    }

    @Override
    public String redirectURL(String id) {
        URLdto urLdto = getURLdtoWithSpecificId(id);
        if (urLdto == null) {
            throw new NotFoundException("No hay url con ese id, por favor corrija su endpoint");
        }
        urLdto.setCountOfTimesRedirect(urLdto.getCountOfTimesRedirect() + 1);
        return urLdto.getPath();
    }

    @Override
    public Integer getNumberOfRedirects(String linkId) {
        URLdto urLdto = getURLdtoWithSpecificId(linkId);
        if (urLdto == null) {
            throw new NotFoundException("No hay url con ese id");
        }
        return urLdto.getCountOfTimesRedirect();
    }

    @Override
    public String invalidateURL(String linkId) {
        URLdto urLdto = getURLdtoWithSpecificId(linkId);
        if (urLdto == null) {
            throw new NotFoundException("No hay url con ese id");
        }
        return urlRepository.invalidateURL(linkId);
    }

    private URLdto getURLdtoWithSpecificId(String id) {
        Map<String, URLdto> urlMap = urlRepository.getAllUrl();
        return urlMap.get(id);
    }


}
