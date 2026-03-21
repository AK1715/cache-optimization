package com.ak.redis.controller;

import com.ak.redis.entities.Note;
import com.ak.redis.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @PostMapping
    public ResponseEntity<Note> create(@RequestBody Note note){
        return ResponseEntity.status(HttpStatus.CREATED).body(noteService.createNote(note));
    }

    @GetMapping
    public ResponseEntity<List<Note>> getAll(){
        return ResponseEntity.ok().body(noteService.getAll());
    }

    @GetMapping("/{noteId}")
    public ResponseEntity<Note> getById(@PathVariable String noteId){
        return ResponseEntity.ok().body(noteService.getById(noteId));
    }


    @DeleteMapping("/{noteId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteNote(@PathVariable String noteId){
        noteService.deleteNote(noteId);
    }
}
