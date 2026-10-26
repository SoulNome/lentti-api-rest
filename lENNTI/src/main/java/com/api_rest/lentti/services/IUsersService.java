package com.api_rest.lentti.services;

import com.api_rest.lentti.model.Users;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUsersService {
    void  insert(Users users) throws  Exception;
    void update(Users users) throws Exception;
    void delete(Long document) throws Exception;
    Users findById(Long document) throws  Exception;
    List<Users> findAll() throws Exception;


}
