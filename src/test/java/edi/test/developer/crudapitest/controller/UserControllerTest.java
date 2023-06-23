package edi.test.developer.crudapitest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edi.test.developer.crudapitest.entity.User;
import edi.test.developer.crudapitest.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ObjectMapper om;

    @BeforeEach
    void setUp() {
        userRepository.deleteAll();

    }

    @Test
    void insertTest() {
        User user = new User();
        user.setNamalengkap("test");
        user.setUsername("test");
        user.setPassword("test");
        user.setStatus("test");

        userRepository.save(user);

        assertNotNull(user.getUserid());
    }

    @Test
    void deleteTest() {
        User user = new User();
        user.setNamalengkap("test");
        user.setUsername("test");
        user.setPassword("test");
        user.setStatus("test");

        userRepository.save(user);

        assertNotNull(user.getUserid());

        userRepository.delete(user);

        assertNull(user.getUserid());
    }
}