package wiki.link.hop;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import wiki.link.hop.entity.WikiPath;
import wiki.link.hop.utils.ApiUtils;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = HopApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:test.properties")
public class HopApplicationTests {

	@Autowired
	private MockMvc mvc;
	private static final String WIKI_URI = "/wiki";
	private static final String INPUT = "https://en.wikipedia.org/wiki/Infinity_Online";
	private static final String FINAL_HOP = "https://en.wikipedia.org/wiki/philosophy";
	private static final String NOT_FOUND = "https://en.wikipedia.org/wiki/Paavan";

	@Test
	public void testCreate() throws IOException, Exception {

		MvcResult rs = mvc.perform(MockMvcRequestBuilders.post(WIKI_URI).contentType(MediaType.APPLICATION_JSON)
				.content(ApiUtils.toJson(new WikiPath(INPUT)))).andReturn();

		WikiPath result = ApiUtils.toObject(rs.getResponse().getContentAsString(), WikiPath.class);
		assertEquals(result.getUrl(), INPUT);
		assertEquals(result.getHops().get(result.getHops().size() - 1).toLowerCase(), FINAL_HOP.toLowerCase());
	}

	@Test
	public void testBadRequest() throws Exception {
		mvc.perform(MockMvcRequestBuilders.post(WIKI_URI).contentType(MediaType.APPLICATION_JSON)
				.content(ApiUtils.toJson(new WikiPath("will fail"))))
				.andExpect(MockMvcResultMatchers.status().isBadRequest()).andReturn();
	}

	@Test
	public void testNotFound() throws Exception {
		mvc.perform(MockMvcRequestBuilders.post(WIKI_URI).contentType(MediaType.APPLICATION_JSON)
				.content(ApiUtils.toJson(new WikiPath(NOT_FOUND))))
				.andExpect(MockMvcResultMatchers.status().isNotFound()).andReturn();
	}

}
