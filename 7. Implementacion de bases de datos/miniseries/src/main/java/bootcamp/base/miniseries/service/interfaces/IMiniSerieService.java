package bootcamp.base.miniseries.service.interfaces;

import java.util.List;

import bootcamp.base.miniseries.dto.response.MiniSerieResponse;

public interface IMiniSerieService {

    List<MiniSerieResponse> findAll();

    MiniSerieResponse findById(long id);


}
