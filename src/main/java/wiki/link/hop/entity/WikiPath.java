package wiki.link.hop.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	Set<String> hops = new HashSet<>();

	public WikiPath() {

	}

	public WikiPath(String url, Set<String> hops) {
		this.url = url;
		this.hops = hops;
	}

	public Set<String> getHops() {
		return hops;
	}

	public void setHops(Set<String> hops) {
		this.hops = hops;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
