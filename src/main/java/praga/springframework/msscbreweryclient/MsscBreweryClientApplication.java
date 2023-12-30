package praga.springframework.msscbreweryclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import praga.springframework.msscbreweryclient.web.config.properties.ServerConfig;

import java.util.Arrays;


@ConfigurationPropertiesScan
@SpringBootApplication
public class MsscBreweryClientApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MsscBreweryClientApplication.class, args);
        //System.out.println(context.getBeanDefinitionCount());
        //for (String name:context.getBeanDefinitionNames()){
        //    System.out.println(name);
        //}

        //ServerConfig serverConfig = (ServerConfig) context.getBean("serverConfig");
        ServerConfig serverConfig = (ServerConfig) context.getBean("sfg.brewery-praga.springframework.msscbreweryclient.web.config.properties.ServerConfig");
        System.out.println(serverConfig.getApiHost());
        System.out.println(serverConfig.getTest());
        System.out.println(serverConfig.getTest2());
    }

}
