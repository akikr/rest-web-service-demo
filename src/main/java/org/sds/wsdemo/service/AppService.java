package org.sds.wsdemo.service;

import org.sds.wsdemo.modal.User;
import org.sds.wsdemo.rest.apis.modals.CustomUser;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AppService {

    private static final String GIT_API_URI = "https://api.github.com/users/";

    private RestTemplate restTemplate;

    public User getUser(String username) {
        restTemplate = getRestTemplate();
        ResponseEntity<CustomUser> responseEntity = restTemplate.getForEntity(GIT_API_URI + username, CustomUser.class);
        CustomUser response = responseEntity.getBody();
        User user = new User();
        user.setId(response.getId());
        user.setName(response.getName());
        user.setPublicRepos(Integer.parseInt(response.getPublicRepos()));
        user.setLocation(response.getLocation());
        user.setCreatedAt(response.getCreatedAt());
        user.setUpdatedAt(response.getUpdatedAt());
        user.setUrl(response.getHtmlUrl());
        return user;
    }

    private RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
