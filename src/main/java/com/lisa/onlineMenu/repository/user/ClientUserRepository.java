package com.lisa.onlineMenu.repository.user;

import com.lisa.onlineMenu.documents.user.ClientUser;
import org.springframework.data.repository.CrudRepository;

public interface ClientUserRepository extends CrudRepository<ClientUser, Long> {

    ClientUser findByMobile(String mobile);
}
