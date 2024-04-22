package bootcamp.linktracker.repository;

import bootcamp.linktracker.dto.LinkDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@Repository
public class LinkRepositoryImpl implements ILinkRepository{
    private Map<Integer, LinkDTO> linkMap = new HashMap<>();

    public void save(LinkDTO linkDTO){
        linkMap.put(linkDTO.getLinkId(), linkDTO);
    }

    public LinkDTO findById(int linkId){
        return linkMap.getOrDefault(linkId,null);
    }


}
