package edi.test.developer.crudapitest.service;

import edi.test.developer.crudapitest.entity.User;
import edi.test.developer.crudapitest.model.InsertUserRequest;
import edi.test.developer.crudapitest.model.UserResponse;
import edi.test.developer.crudapitest.repository.UserRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Set;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Validator validator;

    @Transactional
    public void insertData(InsertUserRequest request) {
        Set<ConstraintViolation<InsertUserRequest>> constraintViolations = validator.validate(request);
        if (constraintViolations.size() != 0) {
            //error
            throw new ConstraintViolationException(constraintViolations);
        }

        if (userRepository.existsById(request.getUsername())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Data");
        }

        User user = new User();
        user.setUserid(String.valueOf(UUID.randomUUID()));
        user.setNamalengkap(request.getNamalengkap());
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setStatus(request.getStatus());

        userRepository.save(user);
    }

    public UserResponse getData(User user) {
        return UserResponse.builder()
                .userid(user.getUserid())
                .namalengkap(user.getNamalengkap())
                .username(user.getUsername())
                .password(user.getPassword())
                .status(user.getStatus())
                .build();
    }

    @Transactional(readOnly = true)
    public UserResponse get(String username) {
        User user = userRepository.findFirstByUsername(username)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        return getData(user);
    }

    @Transactional
    public void delete(String username) {
        User deleteUser = userRepository.findFirstByUsername(username)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        userRepository.delete(deleteUser);
    }

}
