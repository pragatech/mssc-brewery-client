package praga.springframework.msscbreweryclient.web.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;

@Data
@ConfigurationProperties(prefix = "rest.customize", ignoreInvalidFields = false)
public class RestConfig {
    private Integer maxTotal;
    private Integer defaultMaxPerRoute;
    private Long connTimeOut;
    private Long responseTimeOut;

    @ConstructorBinding
    public RestConfig(Integer maxTotal, Integer defaultMaxPerRoute, Long connTimeOut, Long responseTimeOut) {
        this.maxTotal = maxTotal;
        this.defaultMaxPerRoute = defaultMaxPerRoute;
        this.connTimeOut = connTimeOut;
        this.responseTimeOut = responseTimeOut;
    }
}
