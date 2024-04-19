package co.com.mercadolibre.link_tracker.service;

import co.com.mercadolibre.link_tracker.dto.LinkDto;
import co.com.mercadolibre.link_tracker.entity.Link;

import java.util.Optional;

public interface ILinkService {

    LinkDto create(LinkDto linkDto);
    LinkDto redirect(Integer id);
    LinkDto redirect(Integer id, String password);
    void invalidate(Integer id);
    LinkDto metrics(Integer id);
}
