package com.stickynotes.sticky.note.repository;

import com.stickynotes.sticky.note.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
  List<User> findByUsername(String username);
}
