package edi.test.developer.crudapitest.controller;

import edi.test.developer.crudapitest.entity.User;
import edi.test.developer.crudapitest.model.InsertUserRequest;
import edi.test.developer.crudapitest.model.UserResponse;
import edi.test.developer.crudapitest.model.WebResponse;
import edi.test.developer.crudapitest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(
            path = "/api/users",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> insert(@RequestBody InsertUserRequest request) {
        userService.insertData(request);
        return WebResponse.<String>builder().data("OK").build();
    }

    @GetMapping(
            path = "/api/users/{username}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<UserResponse> get(User user, @PathVariable("username") String username) {
        UserResponse userResponse = userService.get(username);
        return WebResponse.<UserResponse>builder().data(userResponse).build();
    }

    @DeleteMapping(
            path = "/api/users/{username}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> delete(User user, @PathVariable("username") String userName) {
        userService.delete(userName);
        return WebResponse.<String>builder().data("OK").build();
    }
}

