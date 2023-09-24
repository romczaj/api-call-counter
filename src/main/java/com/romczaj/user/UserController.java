package com.romczaj.user;

import com.romczaj.callcounter.ApiCounter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class UserController {

    private final UserFacade userFacade;

    @GetMapping("/users/{login}")
    @ApiCounter(field = "login")
    ResponseEntity<UserApiResponse> getUser(@PathVariable("login") String login) {
        UserApiResponse response = userFacade.findUser(login);
        return ResponseEntity.ok(response);
    }
}
