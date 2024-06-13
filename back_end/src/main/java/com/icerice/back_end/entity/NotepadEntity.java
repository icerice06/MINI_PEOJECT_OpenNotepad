package com.icerice.back_end.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.icerice.back_end.dto.NotepadDTO;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "posts")
public class NotepadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title", nullable = false, length = 20)
    private String title;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "content", nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(name = "password", nullable = false, length = 4)
    private String password;

    @Column(name = "is_blip")
    private Boolean isBlip;

    public static NotepadEntity toNotepadEntity(NotepadDTO notepadDTO){
        NotepadEntity notepadEntity = new NotepadEntity();

        notepadEntity.setId(notepadDTO.getId());
        notepadEntity.setTitle(notepadDTO.getTitle());
        notepadEntity.setDate(notepadDTO.getDate());
        notepadEntity.setContent(notepadDTO.getContent());
        notepadEntity.setPassword(notepadDTO.getPassword());
        notepadEntity.setIsBlip(notepadDTO.getIsBlip());
        return notepadEntity;

    }

}
