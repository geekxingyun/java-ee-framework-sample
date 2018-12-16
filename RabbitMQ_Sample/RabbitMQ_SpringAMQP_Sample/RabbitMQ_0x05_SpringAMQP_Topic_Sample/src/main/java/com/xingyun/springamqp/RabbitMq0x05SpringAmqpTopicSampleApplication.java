package com.xingyun.springamqp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.xingyun.springamqp.config.RabbitAmqpTutorialsRunner;

@SpringBootApplication
@EnableScheduling
public class RabbitMq0x05SpringAmqpTopicSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitMq0x05SpringAmqpTopicSampleApplication.class, args);
	}
	
	@Profile("usage_message")
    @Bean
    public CommandLineRunner usage() {
        return new CommandLineRunner() {

            @Override
            public void run(String... arg0) throws Exception {
                System.out.println("This app uses Spring Profiles to control its behavior.\n");
                System.out.println("Sample usage: java -jar "
                		+ "RabbitMQ_0x05_SpringAMQP_Topic_Sample-0.0.1-SNAPSHOT.jar "
                		+ "--spring.profiles.active=topics"
                		+ ",sender");
            }
        };
    }
	
	@Profile("!usage_message")
    @Bean
    public CommandLineRunner tutorial() {
        return new RabbitAmqpTutorialsRunner();
    }
}
