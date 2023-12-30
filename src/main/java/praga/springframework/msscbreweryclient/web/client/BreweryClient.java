package praga.springframework.msscbreweryclient.web.client;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import praga.springframework.msscbreweryclient.web.config.properties.ServerConfig;
import praga.springframework.msscbreweryclient.web.model.BeerDto;

import java.util.UUID;
@Component
public class BreweryClient {
    public final String BEER_PATH_V1="/api/v1/beer/";

    private final ServerConfig serverConfig;

    /*There is multiple ways to get rest template. standard-way in springboot is to get via RestTemplateBuilder.
      We need to declare it at global level. so that it can use configuration given by Spring boot
     */
    private final RestTemplate restTemplate;

    //Constructer injection to get RestRemplate
    public BreweryClient(
            @Autowired RestTemplateBuilder restTemplateBuilder,
            @Autowired ServerConfig serverConfig) {
        this.restTemplate = restTemplateBuilder.build();
        this.serverConfig = serverConfig;
    }

    public BeerDto getBeerById(UUID uuid){
        return restTemplate.getForObject(serverConfig.getApiHost()+BEER_PATH_V1 + uuid, BeerDto.class);
    }
}
