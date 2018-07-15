package wiki.link.hop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import wiki.link.hop.manager.WikiPathManager;
import wiki.link.hop.manager.impl.WikiPathManagerImpl;

@Configuration
public class BeanConfig {

	@Bean
	public WikiPathManager getWikiPathManager() {
		return new WikiPathManagerImpl();
	}
}
