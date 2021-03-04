package com.example.onlineMenu.repository.user;

import com.example.onlineMenu.documents.user.ClientUser;
import org.springframework.data.repository.CrudRepository;

public interface ClientUserRepository extends CrudRepository<ClientUser, Long> {

    ClientUser findByMobile(String mobile);
}
