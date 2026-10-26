package com.api_rest.lentti.services;

import com.api_rest.lentti.exepction.BadRequestException;
import com.api_rest.lentti.exepction.ConflictException;
import com.api_rest.lentti.exepction.ModelNotFoundException;
import com.api_rest.lentti.model.Users;
import com.api_rest.lentti.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService  implements IUsersService{
    @Autowired
    private IUserRepository userRepository;
public void validation(Users users) throws Exception{
    if (users == null){
        throw new BadRequestException("Es obligatorio el registro");
    }if (users.getUserDocument() == 0){
        throw  new BadRequestException("El documento es obligatorio");
    }if("".equals(users.getName())|| users.getName() == null){
        throw new BadRequestException("El nombre es obligatorio");
    }if (users.getPhone() == 0){
        throw new BadRequestException("El numero de telefono es obligatorio");
    }if (users.getEmail() == null ){
        throw  new BadRequestException("El email no puede estar vacio");
    }
    if("".equals(users.getPassword())||users.getPassword() == null ){
        throw new BadRequestException("La constraseña no puede estar vacia");
    }

}
    @Override
    public void insert(Users users) throws Exception {
    validation(users);
    Optional<Users> oldUser =userRepository.findById(users.getUserDocument());
    if (oldUser.isPresent()){
        throw  new ConflictException("Ya existe un usuario con este documento");
    }
    userRepository.save(users);
    }
    @Override
    public void update(Users users) throws Exception {
    validation(users);
    Optional<Users> oldUser = userRepository.findById(users.getUserDocument());
    if (!oldUser.isPresent()){
        throw new ModelNotFoundException("No existe un usuario con este documento");
    }
    userRepository.save(users);
    }

    @Override
    public void delete(Long document) throws Exception {
        Optional<Users> oldUsers = userRepository.findById(document);
    if (document == 0){
        throw new BadRequestException("El documento no puede estar vacio");
    }if (!oldUsers.isPresent()){
        throw new ModelNotFoundException("El usuario no existe");
        }
    userRepository.deleteById(document);
    }

    @Override
    public Users findById(Long document) throws Exception {
        Optional<Users> oldUsers = userRepository.findById(document);
        if (document == 0){
            throw new BadRequestException("El documento no puede estar vacio");
        }if (!oldUsers.isPresent()){
            throw new ModelNotFoundException("El usuario no existe");
        }
        return oldUsers.orElse(null);
    }

    @Override
    public List<Users> findAll() throws Exception {
        return userRepository.findAll();
    }
}
