package com.stickynotes.sticky.note.repository;

import com.stickynotes.sticky.note.dto.StickyNoteDto;
import com.stickynotes.sticky.note.model.StickyNoteVo;
import com.stickynotes.sticky.note.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StickyNoteRepository extends CrudRepository<StickyNoteVo, Integer> {
    @Query("SELECT new com.stickynotes.sticky.note.dto.StickyNoteDto(sn.title, sn.id,sn.positionX,sn.positionY,sn.bgColor) FROM StickyNoteVo sn WHERE sn.user = :user")
    List<StickyNoteDto> findByUser(User user);

}
