package com.stickynotes.sticky.note.service;

import com.stickynotes.sticky.note.model.OTPVo;
import com.stickynotes.sticky.note.model.User;

import java.util.Map;

public interface OTPService {

    Map<?, ?> sendOtpForRegistration(User user);

    Map<?, ?> resendOtpForRegistration(User user);

    String getOtpExpriration(String username);

    Map<?, ?> validateOtpForRegistration(OTPVo otpVo);
}
