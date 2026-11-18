package com.example.demo;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

	@Bean
	 NewTopic netflixTopic() {
		// Dividing topics into 3 partitions so that parallel processing will be possible
		return TopicBuilder.name("netflix-play-v2")
				.partitions(3)
				.replicas(1)
				.build();
	}
}
