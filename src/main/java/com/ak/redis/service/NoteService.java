package com.ak.redis.service;

import com.ak.redis.entities.Note;
import com.ak.redis.repository.NoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

//    @Autowired
    private NoteRepo noteRepo;

    public NoteService(NoteRepo noteRepo){
        this.noteRepo = noteRepo;
    }

    @CachePut(value = "notes", key = "#result.id")
    // save
    public Note createNote(Note note){
        return noteRepo.save(note);
    }

    // get
    public List<Note> getAll(){
        return noteRepo.findAll();
    }

    @Cacheable(value = "notes", key = "#noteId")
    // getById
    public Note getById(String noteId){
        return noteRepo.findById(noteId).orElseThrow(() -> new RuntimeException("Note with given id not found"));
    }

    // update
    public Note updateNote(String noteId, Note note){
        Note note1 = noteRepo.findById(noteId).orElseThrow(() -> new RuntimeException("Note with given id not found"));
        note1.setTitle(note.getTitle());
        note1.setContent(note.getContent());
        note1.setLive(note.getLive());

        return noteRepo.save(note1);
    }

    @CacheEvict(value = "notes", key = "noteId")
    // delete
    public void deleteNote(String noteId){
        Note note = noteRepo.findById(noteId).orElseThrow(() -> new RuntimeException("Note with given not found"));
        noteRepo.delete(note);
    }




}
