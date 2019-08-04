package com.perso.customvalidation.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.perso.customvalidation.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {}