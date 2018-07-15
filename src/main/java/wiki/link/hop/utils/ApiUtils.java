package wiki.link.hop.utils;

import java.io.IOException;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;

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

	private static final ObjectMapper mapper = new ObjectMapper();

	public static byte[] toJson(Object object) throws IOException {

		return mapper.writeValueAsBytes(object);

	}

	public static <T> T toObject(String json, Class<T> classType) throws IOException {

		return mapper.readValue(json, classType);

	}
}
