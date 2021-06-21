package org.sds.wsdemo.service;

import org.sds.wsdemo.modal.User;

public interface AppService {

    User getUser(String username);

    User getUserV2(String username);
}
