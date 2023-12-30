package praga.springframework.msscbreweryclient.web.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import praga.springframework.msscbreweryclient.web.config.ServerConfig;
import praga.springframework.msscbreweryclient.web.model.BeerDto;

import java.net.URI;
import java.util.UUID;

@Component
public class BreweryClient {

    private final String BEER_PATH_V1="/api/v1/beer/";
    private final RestTemplate restTemplate;
    private final ServerConfig serverConfig;

    public BreweryClient(
            @Autowired RestTemplateBuilder restTemplateBuilder,
            @Autowired ServerConfig serverConfig) {
        this.restTemplate = restTemplateBuilder.build();
        this.serverConfig = serverConfig;
    }

    public BeerDto getBeerById(UUID uuid){
        return restTemplate.getForObject(serverConfig.getApiHost()+BEER_PATH_V1+uuid, BeerDto.class);
    }

    public URI saveNewBeer(BeerDto beerDto){
        return restTemplate.postForLocation(serverConfig.getApiHost()+BEER_PATH_V1, beerDto);
    }

    public void updateBeer(UUID uuid, BeerDto beerDto){
        restTemplate.put(serverConfig.getApiHost()+BEER_PATH_V1+uuid, beerDto);
    }

    public void deleteBeer(UUID uuid){
        restTemplate.delete(serverConfig.getApiHost()+BEER_PATH_V1+uuid);
    }

}
