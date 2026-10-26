package com.api_rest.lentti.controller;

import com.api_rest.lentti.model.Users;
import com.api_rest.lentti.services.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUsersService usersService;
    @GetMapping()
    public ResponseEntity<List <Users>> findAll()throws Exception{
        return new ResponseEntity<>(usersService.findAll(), HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<Users> findById(@PathVariable("id") long document) throws Exception{
         return  new ResponseEntity<>(usersService.findById(document),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Object> insert(@RequestBody Users users) throws Exception{
      usersService.insert(users);
      return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody Users users) throws Exception{
        usersService.update(users);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") long document) throws Exception{
        usersService.delete(document);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
}
