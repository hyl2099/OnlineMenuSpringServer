package com.example.onlineMenu.repository;

import com.example.onlineMenu.documents.ClientUser;
import org.springframework.data.repository.CrudRepository;

public interface ClientUserRepository extends CrudRepository<ClientUser, Long> {

    ClientUser findByMobile(String mobile);
}
