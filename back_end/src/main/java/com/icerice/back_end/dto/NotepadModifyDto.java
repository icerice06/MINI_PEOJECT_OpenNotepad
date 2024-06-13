package com.icerice.back_end.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotepadModifyDto {
    private String title;
    private String content;
    private String password;
}
