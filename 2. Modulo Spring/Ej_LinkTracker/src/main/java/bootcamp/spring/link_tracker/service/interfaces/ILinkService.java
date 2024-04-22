package bootcamp.spring.link_tracker.service.interfaces;

import bootcamp.spring.link_tracker.dto.request.LinkDTOrequest;
import bootcamp.spring.link_tracker.dto.response.LinkDTOresponse;
import bootcamp.spring.link_tracker.model.Link;

public interface ILinkService extends IService<Link>{
	LinkDTOresponse save(LinkDTOrequest id);
	String searchUrlLinkById(Integer id);
	Integer searchTimesRedirected(Integer id);
    void invalidateLink(Integer id);
}
