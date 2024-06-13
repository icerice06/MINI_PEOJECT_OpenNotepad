package com.icerice.back_end.dto;

import com.icerice.back_end.entity.NotepadEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class NotepadDTO {
    private int id;
    private String title;
    private Date date;
    private String content;
    private String password;
    private Boolean isBlip;

    public static NotepadDTO toNotepadDTO(NotepadEntity notepadEntity){
        NotepadDTO notepadDTO = new NotepadDTO();

        notepadDTO.setId(notepadEntity.getId());
        notepadDTO.setTitle(notepadEntity.getTitle());
        notepadDTO.setDate(notepadEntity.getDate());
        notepadDTO.setContent(notepadEntity.getContent());
        notepadDTO.setPassword(notepadEntity.getPassword());
        notepadDTO.setIsBlip(notepadEntity.getIsBlip());

        return notepadDTO;
    }

}