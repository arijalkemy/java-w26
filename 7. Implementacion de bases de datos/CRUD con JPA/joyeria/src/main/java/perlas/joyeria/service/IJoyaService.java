package perlas.joyeria.service;

import perlas.joyeria.dto.JoyaDto;

import java.util.List;

public interface IJoyaService {
    public List<JoyaDto> getJoyas ();
    public String saveJoya (JoyaDto joya);
    public String deleteJoya (long id);
    public JoyaDto findJoya (long id);
    public String updateJoya (long id, JoyaDto joya);
}
