package bootcamp.spring.link_tracker.repository.interfaces;

import bootcamp.spring.link_tracker.model.Link;

public interface ILinkRepository extends IRepository<Link>{
	Integer save(Link link);

    void sumRedirect(Link link);

    void invalidateLink(Integer id);
}
