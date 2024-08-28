package com.stickynotes.sticky.note.service;


import com.stickynotes.sticky.note.model.User;

public interface UserService {

  void insertUser(User user);

  User findByUserName(String username);

  User getCurrentUser();
}
