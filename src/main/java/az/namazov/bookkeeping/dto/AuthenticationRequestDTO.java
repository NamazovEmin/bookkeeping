package az.namazov.bookkeeping.dto;

import lombok.Data;

@Data
public class AuthenticationRequestDTO {

    private String userName;
    private String userPassword;
}
