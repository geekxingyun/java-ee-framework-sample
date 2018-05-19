package com.xingyun.spring_context_sample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.xingyun.spring_context_sample.hello.MessagePrinter;
import com.xingyun.spring_context_sample.hello.MessageService;

@Configuration
@ComponentScan
public class App 
{
	@Bean
    MessageService mockMessageService() {
        return new MessageService() {
            public String getMessage() {
              return "Hello World!";
            }
        };
    }
    public static void main( String[] args )
    {
    	 ApplicationContext context = 
    	          new AnnotationConfigApplicationContext(App.class);
    	      MessagePrinter printer = context.getBean(MessagePrinter.class);
    	      printer.printMessage();
    }
}
