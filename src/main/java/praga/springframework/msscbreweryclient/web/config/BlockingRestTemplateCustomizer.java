package praga.springframework.msscbreweryclient.web.config;

import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.DefaultConnectionKeepAliveStrategy;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.apache.hc.core5.util.Timeout;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BlockingRestTemplateCustomizer implements RestTemplateCustomizer {
    @Override
    public void customize(RestTemplate restTemplate) {
        restTemplate.setRequestFactory(this.clientHttpRequestFactory());
    }

    private ClientHttpRequestFactory clientHttpRequestFactory() {
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(100);
        connectionManager.setDefaultMaxPerRoute(20);

        RequestConfig requestConfig = RequestConfig
                .custom()
                .setConnectionRequestTimeout(Timeout.ofMilliseconds(3000))
                .setResponseTimeout(Timeout.ofMilliseconds(3000))
                .build();
        CloseableHttpClient httpClient = HttpClients
                .custom()
                .setConnectionManager(connectionManager)
                .setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy())
                .setDefaultRequestConfig(requestConfig)
                .build();
        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        httpRequestFactory.setHttpClient(httpClient);
        return httpRequestFactory;
    }
}
