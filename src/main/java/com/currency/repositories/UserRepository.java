package com.currency.repositories;

import com.currency.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);

    @Query(value = "SELECT * FROM users WHERE role = 'ROLE_USER' ", nativeQuery = true)
    List<User> findAll();

    void deleteByUsername(String username);

}
