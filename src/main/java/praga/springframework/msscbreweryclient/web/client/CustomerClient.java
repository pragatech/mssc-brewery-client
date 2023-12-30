package praga.springframework.msscbreweryclient.web.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import praga.springframework.msscbreweryclient.web.config.ServerConfig;
import praga.springframework.msscbreweryclient.web.model.CustomerDto;

import java.net.URI;
import java.util.UUID;

@Component
public class CustomerClient {
    private final String CUSTOMER_PATH_V1="/api/v1/customer/";
    private final ServerConfig serverConfig;
    private final RestTemplate restTemplate;

    public CustomerClient(
            @Autowired ServerConfig serverConfig,
            @Autowired RestTemplateBuilder restTemplateBuilder) {
        this.serverConfig = serverConfig;
        this.restTemplate = restTemplateBuilder.build();
    }

    public CustomerDto getCustomer(UUID uuid){
        return restTemplate.getForObject(serverConfig.getApiHost()+CUSTOMER_PATH_V1+uuid, CustomerDto.class);
    }

    public URI saveCustomer(CustomerDto customerDto){
        return restTemplate.postForLocation(serverConfig.getApiHost()+CUSTOMER_PATH_V1, customerDto);
    }

    public void updateCustomer(UUID uuid, CustomerDto customerDto){
        restTemplate.put(serverConfig.getApiHost()+CUSTOMER_PATH_V1+uuid, customerDto);
    }

    public void deleteCustomer(UUID uuid){
        restTemplate.delete(serverConfig.getApiHost()+CUSTOMER_PATH_V1+uuid);
    }

}
