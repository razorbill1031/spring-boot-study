package me.kimhejoong.springbootdeveloper;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class QuizController {

    @GetMapping("/quiz")
    public ResponseEntity<String> quiz(@ResponseParam("code") int code) {
        switch (code) {
            case 1:
                return ResponseEntity.created(null).body("Created!");

            case 2:
                return ResponseEntity.badRequest().body("Bad Request!");

            default:
                return ResponseEntity.ok().body("OK!");
        }
    }

    @PostMapping("/quiz")
    public ResponseEntity<String> quiz2(@ResponseBody Code code) {

        switch (code.value()) {
            case 1:
                return ResponseEntity.status(403).body("Forbidden!");

            default:
                return ResponseEntity.ok().body("OK!");
        }
    }
}

record Code(int value) {}