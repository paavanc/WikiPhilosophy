package wiki.link.hop.vo;

import javax.validation.constraints.NotNull;

public class WikiPathRequest {

	@NotNull
	String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
