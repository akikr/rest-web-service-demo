package org.sds.wsdemo.client.controller;

import org.sds.wsdemo.client.modal.ResponseModal;
import org.sds.wsdemo.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestClientController {

    @Autowired
    private AppService appService;

    @GetMapping(path = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseModal getUserApi(@RequestParam("username") String username) {
        ResponseModal response = new ResponseModal();
        response.setId(appService.getUser(username).getId());
        response.setName(appService.getUser(username).getName());
        response.setPublicRepos(String.valueOf(appService.getUser(username).getPublicRepos()));
        response.setLocation(appService.getUser(username).getLocation());
        response.setCreatedAt(appService.getUser(username).getCreatedAt());
        response.setUpdatedAt(appService.getUser(username).getUpdatedAt());
        response.setUrl(appService.getUser(username).getUrl());
        return response;
    }

    @GetMapping(path = "/userV2", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseModal getUserApiV2(@RequestParam("username") String username) {
        ResponseModal response = new ResponseModal();
        response.setId(appService.getUserV2(username).getId());
        response.setName(appService.getUserV2(username).getName());
        response.setPublicRepos(String.valueOf(appService.getUserV2(username).getPublicRepos()));
        response.setLocation(appService.getUserV2(username).getLocation());
        response.setCreatedAt(appService.getUserV2(username).getCreatedAt());
        response.setUpdatedAt(appService.getUserV2(username).getUpdatedAt());
        response.setUrl(appService.getUserV2(username).getUrl());
        return response;
    }
}
