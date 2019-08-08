package com.example.easynotes.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.easynotes.aspect.TimeTracking;
import com.example.easynotes.aspect.UserAccess;
import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.Note;
import com.example.easynotes.repository.NoteRepository;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/*
 *  https://www.callicoder.com/spring-boot-rest-api-tutorial-with-mysql-jpa-hibernate/
 */

@RestController
@RequestMapping("/api")
public class NoteController {

	private static final Logger LOG = LogManager.getLogger( NoteController.class.getName() );
		
    @Autowired
    NoteRepository noteRepository;

    @TimeTracking
    @GetMapping("/notes")
    public List<Note> getAllNotes() {
    	LOG.debug( " *** getAllNotes " );
        return noteRepository.findAll();
    }

    @UserAccess
    @PostMapping("/notes")
    public Note createNote(@Valid @RequestBody Note note) {
    	LOG.debug( " *** createNote " );
        return noteRepository.save(note);
    }
    
    @TimeTracking
    @GetMapping("/notes/{id}")
    public Note getNoteById(@PathVariable(value = "id") Long noteId) {
    	LOG.debug( " *** getNoteById " );
        return noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
    }
    
    @UserAccess
    @PutMapping("/notes/{id}")
    public Note updateNote(@PathVariable(value = "id") Long noteId,
                                           @Valid @RequestBody Note noteDetails) {
    	LOG.debug( " *** updateNote " );
        Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

        note.setTitle(noteDetails.getTitle());
        note.setContent(noteDetails.getContent());

        Note updatedNote = noteRepository.save(note);
        return updatedNote;
    }

    @DeleteMapping("/notes/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) {
    	LOG.debug( " *** deleteNote " );
        Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

        noteRepository.delete(note);

        return ResponseEntity.ok().build();
    }
}
