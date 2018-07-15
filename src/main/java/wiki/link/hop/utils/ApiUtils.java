package wiki.link.hop.utils;

import java.net.URL;

public class ApiUtils {

	public static boolean isValidWikiUrl(String url) {
		if (url == null || url.isEmpty()) {
			return false;
		}
		try {
			new URL(url).toURI();
			return url.startsWith(Constants.WIKI_START_PATH);
		} catch (Exception e) {
			return false;
		}
	}
}
