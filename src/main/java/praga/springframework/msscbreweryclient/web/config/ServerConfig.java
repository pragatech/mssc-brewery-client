package praga.springframework.msscbreweryclient.web.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;

@Data
@ConfigurationProperties(prefix = "sfg.brewery", ignoreUnknownFields = false)
public class ServerConfig {
    private String apiHost;

    @ConstructorBinding
    public ServerConfig(String apiHost) {
        this.apiHost = apiHost;
    }
}
