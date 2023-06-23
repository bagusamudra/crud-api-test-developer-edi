package edi.test.developer.crudapitest.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InsertUserRequest {

    @NotBlank
    @Size(max = 50)
    private String namalengkap;

    @NotBlank
    @Size(max = 10)
    private String username;

    @NotBlank
    @Size(max = 10)
    private String password;

    @NotBlank
    @Size(max = 10)
    private String status;

}
