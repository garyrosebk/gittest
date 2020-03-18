package com.example.configserver.config;

import org.springframework.cloud.config.monitor.GithubPropertyPathNotificationExtractor;
import org.springframework.context.annotation.Bean;

public class ConfigServerMonitor {

	@Bean
	public GithubPropertyPathNotificationExtractor githubPropertyPathNotificationExtractor() {
		return new GithubPropertyPathNotificationExtractor();
	}
}
