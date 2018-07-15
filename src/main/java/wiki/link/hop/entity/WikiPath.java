package wiki.link.hop.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.keyvalue.annotation.KeySpace;

import com.fasterxml.jackson.annotation.JsonInclude;

@KeySpace("WikiPath")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class WikiPath implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5991288484412489387L;

	@Id
	String url;
	List<String> hops = new ArrayList<>();

	public WikiPath() {

	}

	public WikiPath(String url) {
		this.url = url;
	}

	public WikiPath(String url, List<String> hops) {
		this.url = url;
		this.hops = hops;
	}

	public List<String> getHops() {
		return hops;
	}

	public void setHops(List<String> hops) {
		this.hops = hops;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
