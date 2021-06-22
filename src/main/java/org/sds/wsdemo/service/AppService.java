package org.sds.wsdemo.service;

import org.sds.wsdemo.modal.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api")
public interface AppService {

    @GetMapping(value = "/user",
            consumes = MediaType.TEXT_PLAIN_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    User getUser(String username);

    @GetMapping(value = "/userV2",
            consumes = MediaType.TEXT_PLAIN_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    User getUserV2(String username);
}
