package org.sds.wsdemo.controller;

import org.sds.wsdemo.modal.User;
import org.sds.wsdemo.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/git-api")
public class AppController {

    @Autowired
    private AppService appService;

    @GetMapping("/user")
    public User getUserDetails(@RequestParam("username") final String username) {
        return appService.getUser(username);
    }
}
