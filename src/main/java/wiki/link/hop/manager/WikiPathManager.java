package wiki.link.hop.manager;

import wiki.link.hop.entity.WikiPath;
import wiki.link.hop.vo.WikiPathRequest;

public interface WikiPathManager {

	WikiPath getPath(WikiPathRequest wp);

}