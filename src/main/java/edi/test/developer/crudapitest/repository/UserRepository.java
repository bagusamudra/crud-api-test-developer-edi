package edi.test.developer.crudapitest.repository;

import edi.test.developer.crudapitest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findFirstByUsername(String username);
}
