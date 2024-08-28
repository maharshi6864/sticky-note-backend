package com.stickynotes.sticky.note.repository;

import com.stickynotes.sticky.note.model.OTPVo;
import com.stickynotes.sticky.note.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OTPRepository extends CrudRepository<OTPVo,Integer> {

    List<OTPVo> findByUser(User user);
}
