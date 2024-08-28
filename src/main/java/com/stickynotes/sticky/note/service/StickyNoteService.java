package com.stickynotes.sticky.note.service;

import com.stickynotes.sticky.note.dto.Response;
import com.stickynotes.sticky.note.model.StickyNoteVo;

public interface StickyNoteService {

    Response loadStickyNotes();

    Response saveNote(StickyNoteVo stickyNoteVo);

    Response deleteNote(StickyNoteVo stickyNoteVo);

    Response updateNotePosition(StickyNoteVo stickyNoteVo);
}
