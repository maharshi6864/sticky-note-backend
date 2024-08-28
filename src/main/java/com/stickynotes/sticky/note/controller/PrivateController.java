package com.stickynotes.sticky.note.controller;

import com.stickynotes.sticky.note.dto.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stickyNote")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class PrivateController {



}
