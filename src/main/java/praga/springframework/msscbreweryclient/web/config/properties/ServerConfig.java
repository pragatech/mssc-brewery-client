package praga.springframework.msscbreweryclient.web.config.properties;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
//@Component
//@PropertySource(value = {"classpath:test1.properties", "classpath:test2.properties"}, ignoreResourceNotFound = false)
@ConfigurationProperties(prefix = "sfg.brewery", ignoreUnknownFields = false, ignoreInvalidFields = false)
public class ServerConfig {
    //PropertySource and configuration properties doesn't work together. Property source will work on Beans.
    //Configuration properties will also create bean. but it is happening very earlier
    private String apiHost;
    //@Value("${sfg.brewery.test}")
    private String test;
    //@Value("${sfg.brewery.test2}")
    private String test2;

   @ConstructorBinding
    public ServerConfig(
            String apiHost
            //@Value("${sfg.brewery.test}") String test,
            //@Value("${sfg.brewery.test2}") String test2
            ) {
        this.apiHost = apiHost;
        //this.test=test;
        //this.test2=test2;
    }
}
