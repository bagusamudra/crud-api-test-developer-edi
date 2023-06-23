package edi.test.developer.crudapitest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {

    private String userid;

    private String namalengkap;

    private String username;

    private String password;

    private String status;
}

