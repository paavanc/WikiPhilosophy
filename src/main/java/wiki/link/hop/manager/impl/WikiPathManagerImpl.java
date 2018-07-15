package wiki.link.hop.manager.impl;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import wiki.link.hop.entity.WikiPath;
import wiki.link.hop.exception.ExceptionConstants;
import wiki.link.hop.exception.WikiException;
import wiki.link.hop.manager.WikiPathManager;
import wiki.link.hop.repository.WikiPathRepository;
import wiki.link.hop.utils.ApiUtils;
import wiki.link.hop.utils.Constants;
import wiki.link.hop.vo.WikiPathRequest;

public class WikiPathManagerImpl implements WikiPathManager {

	@Autowired
	WikiPathRepository wikiPathRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see wiki.link.hop.manager.impl.WikiPathManager#getPath(java.lang.String)
	 */
	private void initValidate(WikiPathRequest wp) {

		if (wp == null || !ApiUtils.isValidWikiUrl(wp.getUrl())) {
			throw new WikiException(ExceptionConstants.INVALID_URL);
		}
	}

	private WikiPath checkDB(WikiPathRequest wp) {

		Optional<WikiPath> paths = wikiPathRepository.findById(wp.getUrl());

		if (!paths.isPresent()) {
			return null;
		}
		return paths.get();
	}

	@Override
	public WikiPath getPath(WikiPathRequest wp) {
		initValidate(wp);
		WikiPath wpDb = checkDB(wp);
		if (wpDb != null) {
			return wpDb;
		}
		return wikiPathRepository.save(findPaths(wp));
	}

	private String getLink(String url) {

		try {
			URL urlLink = new URL(url);
			Document doc = Jsoup.parse(urlLink, Constants.WIKI_TIMEOUT);
			Elements links = doc.select(Constants.DOC_SELECT);

			for (int i = 0; i < links.size(); i++) {
				url = links.get(i).toString();
				if (isValidLink(url)) {
					url = links.get(i).toString();
					return Constants.WIKI_URL + url.substring(9, url.indexOf("\"", 10));
				}
			}
			return null;
		} catch (IOException io) {
			return null;
		}
	}

	private boolean isValidLink(String url) {
		Set<String> invalidLinks = new HashSet<String>(Arrays.asList("greek", "wiktionary", "latin"));
		boolean flag = false;
		for (String s : invalidLinks) {
			flag = url.toLowerCase().contains(s);
		}
		return !flag && url.toLowerCase().contains(Constants.WIKI);
	}

	private WikiPath findPaths(WikiPathRequest wp) {
		String url = wp.getUrl();
		int counter = 0;
		boolean flag = true;
		Set<String> urlList = new HashSet<>();
		while (flag) {
			if (counter >0) {
				url = getLink(url);
				System.out.println("url: "+url + " counter: "+counter);
				if (urlList.contains(url)) {
					throw new WikiException(ExceptionConstants.DUPLICATES);

				}
				urlList.add(url);
			}
			if (url == null || url.isEmpty() || counter > Constants.MAX_HOP) {
				throw new WikiException(ExceptionConstants.NOT_FOUND, HttpStatus.NOT_FOUND);

			}
			if (url.equalsIgnoreCase(Constants.END_URL)) {
				flag = false;
			}
			counter++;
		}
		return new WikiPath(wp.getUrl(), urlList);
	}
}
