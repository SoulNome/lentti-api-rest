package com.api_rest.lentti.repository;

import com.api_rest.lentti.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository  extends JpaRepository<Users, Long> {
}
