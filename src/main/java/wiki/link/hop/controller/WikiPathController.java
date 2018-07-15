package wiki.link.hop.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import wiki.link.hop.entity.WikiPath;
import wiki.link.hop.manager.WikiPathManager;
import wiki.link.hop.vo.WikiPathRequest;

@Controller
@RequestMapping("/wiki")
public class WikiPathController {

	@Autowired
	WikiPathManager wikiPathManager;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public WikiPath create(@Valid @RequestBody WikiPathRequest url) {
		return wikiPathManager.getPath(url);
	}

}
