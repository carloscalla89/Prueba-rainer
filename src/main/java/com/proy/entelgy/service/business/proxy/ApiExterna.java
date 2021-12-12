package com.proy.entelgy.service.business.proxy;

import com.proy.entelgy.properties.ApplicationProperties;
import com.proy.entelgy.service.business.dto.UserDTOResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ApiExterna {

    private ApplicationProperties applicationProperties;
    private RestTemplate externalRestTemplate;

    @Autowired
    public ApiExterna(ApplicationProperties applicationProperties, RestTemplate externalRestTemplate) {
        this.applicationProperties = applicationProperties;
        this.externalRestTemplate = externalRestTemplate;
    }

    public UserDTOResponse getApiExterna() {

        return externalRestTemplate.getForObject(applicationProperties.getUrl(), UserDTOResponse.class);
    }

}
