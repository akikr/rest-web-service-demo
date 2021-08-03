package org.sds.wsdemo.service.impl;

import org.sds.wsdemo.modal.User;
import org.sds.wsdemo.rest.apis.modals.CustomUser;
import org.sds.wsdemo.service.AppService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class AppServiceImpl implements AppService {

    private static final String GIT_API_URI = "https://api.github.com/users/";

    private RestTemplate restTemplate;
    private WebClient webClient;

    public AppServiceImpl(RestTemplate restTemplate, WebClient webClient) {
        this.restTemplate = restTemplate;
        this.webClient = webClient;
    }

    @Override
    public User getUser(String username) {
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

    @Override
    public User getUserV2(String username) {
        CustomUser response = webClient
                .get()
                .uri(GIT_API_URI + username)
                .retrieve()
                .bodyToMono(CustomUser.class)
                .block();

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
}
