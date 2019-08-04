package com.perso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perso.domain.User;

public interface UserRepository extends JpaRepository<User, String> {

}
