package com.okeyo;

import com.okeyo.model.Login;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class Authentication {

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody Login login) {
       System.out.println(login.getUsername());
       System.out.println(login.getPassword());

        return ResponseEntity.ok().build();
    }


}
