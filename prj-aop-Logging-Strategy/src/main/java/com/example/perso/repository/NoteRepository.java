package com.example.perso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.perso.model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

}
