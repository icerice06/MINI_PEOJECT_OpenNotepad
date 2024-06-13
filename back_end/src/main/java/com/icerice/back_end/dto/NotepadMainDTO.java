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
public class NotepadMainDTO {
    private int id;
    private String title;
    private Date date;
    private String content;

    public static NotepadMainDTO toNotepadMainDTO(NotepadEntity notepadEntity){
        NotepadMainDTO notepadMainDTO = new NotepadMainDTO();

        notepadMainDTO.setId(notepadEntity.getId());
        notepadMainDTO.setTitle(notepadEntity.getTitle());
        notepadMainDTO.setDate(notepadEntity.getDate());
        notepadMainDTO.setContent(notepadEntity.getContent());

        return notepadMainDTO;
    }
}
