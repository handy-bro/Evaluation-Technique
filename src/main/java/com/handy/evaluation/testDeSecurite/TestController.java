package com.handy.evaluation.testDeSecurite;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Ce controller est pour tester si l'authentification base sur le jwt fonctione correctement
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Hello world. This will not work if the user is not authenticated"); // il faut que le token soit valide
    }
}
