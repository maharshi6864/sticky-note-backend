package com.stickynotes.sticky.note.service;

import com.stickynotes.sticky.note.dto.Response;
import com.stickynotes.sticky.note.dto.StickyNoteDto;
import com.stickynotes.sticky.note.model.StickyNoteVo;
import com.stickynotes.sticky.note.repository.StickyNoteRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class StickyNoteServiceImp implements StickyNoteService {

    @Autowired
    private StickyNoteRepository stickyNoteRepository;

    @Autowired
    private UserService userService;

    @Override
    public Response loadStickyNotes() {
        List<StickyNoteDto> list = this.stickyNoteRepository.findByUser(userService.getCurrentUser());
        return new Response("Success", list, true);
    }

    @Override
    public Response saveNote(StickyNoteVo stickyNoteVo) {
        stickyNoteVo.setUser(userService.getCurrentUser());
        stickyNoteRepository.save(stickyNoteVo);
        return new Response("Success", null, true);
    }

    @Override
    public Response deleteNote(StickyNoteVo stickyNoteVo) {
        stickyNoteVo.setUser(userService.getCurrentUser());
        stickyNoteRepository.delete(stickyNoteVo);
        return new Response("Success", stickyNoteVo, true);
    }

    @Override
    public Response updateNotePosition(StickyNoteVo stickyNoteVo) {
        StickyNoteVo stickyNoteVo2 = this.stickyNoteRepository.findById(stickyNoteVo.getId())
                .orElseThrow(() -> new EntityNotFoundException("Entity not found"));
        stickyNoteVo2.setPositionX(stickyNoteVo.getPositionX());
        stickyNoteVo2.setPositionY(stickyNoteVo.getPositionY());
        this.stickyNoteRepository.save(stickyNoteVo2);
        return new Response("Success", stickyNoteVo, true);
    }
}
