package praga.springframework.msscbreweryclient.web.config;

import org.apache.hc.client5.http.impl.async.CloseableHttpAsyncClient;
import org.apache.hc.client5.http.impl.async.HttpAsyncClients;
import org.apache.hc.client5.http.impl.nio.PoolingAsyncClientConnectionManager;
import org.apache.hc.core5.reactor.IOReactorConfig;
import org.apache.hc.core5.util.Timeout;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class NIORestTemplateCustomizer implements RestTemplateCustomizer {
    @Override
    public void customize(RestTemplate restTemplate) {
       // restTemplate.setRequestFactory(clientHttpRequestFactory());
    }

    private CloseableHttpAsyncClient clientHttpRequestFactory() {
        //NOT WORKING. find best alternative. Course content is outdated.
        return HttpAsyncClients.createDefault();
    }
}
