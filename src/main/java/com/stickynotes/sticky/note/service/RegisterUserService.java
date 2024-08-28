package com.stickynotes.sticky.note.service;

import com.stickynotes.sticky.note.dto.Response;
import com.stickynotes.sticky.note.model.OTPVo;
import com.stickynotes.sticky.note.model.User;

import java.util.Map;

public interface RegisterUserService {

    Response registerUser(User user);

    Response checkUsernameAvailable(String username);

    Response confirmUserForRegistration(String username);

    Response resendOtp(User user);

    Response validateOtp(Map<?,?> requestObj);
}
