package com.ynz.front.demothymeleaf.security;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserSecDetailRepository extends CrudRepository<UserSecurityDetails, Long> {
    Optional<UserSecurityDetails> findByLoginName(String userName);
}
