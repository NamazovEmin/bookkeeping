package az.namazov.bookkeeping.controller.response;

import lombok.Data;

@Data
public class AuthResponse {

    private String userName;
    private String token;
}
