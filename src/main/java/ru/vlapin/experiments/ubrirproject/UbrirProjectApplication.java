package ru.vlapin.experiments.ubrirproject;

import java.util.Date;
import lombok.val;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.Wsdl11Definition;
import ru.vlapin.experiments.ubrirproject.common.CustomEvent;

@EnableWs
@SpringBootApplication
@ConfigurationPropertiesScan
@ComponentScan(includeFilters = @Filter(Aspect.class))
public class UbrirProjectApplication {

  public static void main(String[] args) {
    SpringApplication.run(UbrirProjectApplication.class, args);
  }

  @EventListener
  public void customEventListener(CustomEvent c) {
    System.out.println("!!!Произошло кастомное событие!!! - " + c.getSource());
  }

  @Bean
  Date date() {
    return new Date();
  }

  @Bean
  public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext){
    val messageDispatcherServlet = new MessageDispatcherServlet();
    messageDispatcherServlet.setApplicationContext(applicationContext);
    return new ServletRegistrationBean<>(messageDispatcherServlet, "/medium/ws/*");
  }

  @Bean(name = "calculatorDemo")
  public Wsdl11Definition wsdl11Definition(){
    val simpleWsdl11Definition = new SimpleWsdl11Definition();
    simpleWsdl11Definition.setWsdl(new ClassPathResource("/wsdl/calculator.wsdl"));
    return simpleWsdl11Definition;
  }
}
