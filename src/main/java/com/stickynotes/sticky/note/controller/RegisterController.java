package com.stickynotes.sticky.note.controller;

import com.stickynotes.sticky.note.dto.Response;
import com.stickynotes.sticky.note.model.OTPVo;
import com.stickynotes.sticky.note.model.User;
import com.stickynotes.sticky.note.service.RegisterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private RegisterUserService registerUserService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("")
    public ResponseEntity<Response> register(@RequestBody User user) {
        user.setRole("USER");
        user.setStatus(false);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return new ResponseEntity<Response>(registerUserService.registerUser(user), HttpStatus.OK);
    }

    @PostMapping("/checkUsernameAvail")
    public ResponseEntity<Response> checkUsernnameAvail(@RequestBody String username) {
        return new ResponseEntity<Response>(registerUserService.checkUsernameAvailable(username), HttpStatus.OK);
    }

    @PostMapping("/confirmUserForRegistration")
    public ResponseEntity<Response> confirmUserForRegistration(@RequestBody String username) {
        return new ResponseEntity<Response>(registerUserService.confirmUserForRegistration(username), HttpStatus.OK);
    }

    @PostMapping("/resendOtp")
    public ResponseEntity<Response> resendOtp(@RequestBody User user) {
        return new ResponseEntity<Response>(registerUserService.resendOtp(user), HttpStatus.OK);
    }

    @PostMapping("/validateOtp")
    public ResponseEntity<Response> validateOtp(@RequestBody Map<?, ?> requestObj) {
        return new ResponseEntity<Response>(registerUserService.validateOtp(requestObj), HttpStatus.OK);
    }
}
