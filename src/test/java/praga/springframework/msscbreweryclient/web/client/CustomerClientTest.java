package praga.springframework.msscbreweryclient.web.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import praga.springframework.msscbreweryclient.web.model.CustomerDto;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerClientTest {
    @Autowired
    private CustomerClient customerClient;
    @Test
    void getCustomer() {
        CustomerDto customerDto = customerClient.getCustomer(UUID.randomUUID());
        assertNotNull(customerDto);
    }

    @Test
    void saveCustomer() {
        CustomerDto customerDto = CustomerDto.builder().name("Praga").build();
        URI uri = customerClient.saveCustomer(customerDto);
        assertNotNull(uri);
        System.out.println(uri.toString());
    }

    @Test
    void updateCustomer() {
        CustomerDto customerDto = CustomerDto.builder().name("Praga").build();
        customerClient.updateCustomer(UUID.randomUUID(), customerDto);
    }

    @Test
    void deleteCustomer() {
        //Spring will automatically validate HttpStatus Code. if we are getting BAD request, it will fail automatically
        //This is taken care by Spring boot
        customerClient.deleteCustomer(UUID.randomUUID());
    }
}