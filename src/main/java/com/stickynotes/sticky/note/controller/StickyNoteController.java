package com.stickynotes.sticky.note.controller;

import com.stickynotes.sticky.note.dto.Response;
import com.stickynotes.sticky.note.model.StickyNoteVo;
import com.stickynotes.sticky.note.service.StickyNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stickyNote")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class StickyNoteController {

    @Autowired
    private StickyNoteService stickyNoteService;

    @GetMapping("/loadNotes")
    public ResponseEntity<Response> loadNotes() {
        return new ResponseEntity<Response>(this.stickyNoteService.loadStickyNotes(), HttpStatus.OK);
    }

    @PostMapping("/saveNote")
    public ResponseEntity<Response> saveNote(@RequestBody StickyNoteVo stickyNoteVo) {
        return new ResponseEntity<Response>(this.stickyNoteService.saveNote(stickyNoteVo), HttpStatus.OK);
    }

    @PostMapping("/deleteNote")
    public ResponseEntity<Response> deleteNote(@RequestBody StickyNoteVo stickyNoteVo) {
        return new ResponseEntity<Response>(this.stickyNoteService.deleteNote(stickyNoteVo), HttpStatus.OK);
    }

    @PostMapping("/updateNotePosition")
    public ResponseEntity<Response> updateNotePosition(@RequestBody StickyNoteVo stickyNoteVo) {
        return new ResponseEntity<Response>(this.stickyNoteService.updateNotePosition(stickyNoteVo), HttpStatus.OK);
    }

}
