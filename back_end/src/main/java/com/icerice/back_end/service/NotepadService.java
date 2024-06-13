package com.icerice.back_end.service;

import com.icerice.back_end.dto.NotepadDTO;
import com.icerice.back_end.dto.NotepadMainDTO;
import com.icerice.back_end.dto.NotepadModifyDto;
import com.icerice.back_end.entity.NotepadEntity;
import com.icerice.back_end.repository.NotepadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NotepadService {
    private final NotepadRepository notepadRepository;

    public List<NotepadMainDTO> findBlipNotepads() {
        return notepadRepository.findAll().stream()
                .filter(NotepadEntity::getIsBlip)
                .map(NotepadMainDTO::toNotepadMainDTO)
                .collect(Collectors.toList());
    }
    public NotepadMainDTO getById(Long id) { /**하나 출력*/
        NotepadEntity notepadEntity = notepadRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Notepad not found"));
        return NotepadMainDTO.toNotepadMainDTO(notepadRepository.save(notepadEntity));
    }
    public void modify(Long id, NotepadModifyDto notepadModifyDto) { /** 수정*/
        NotepadEntity notepadEntity = notepadRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Notepad not found"));

        if (!notepadModifyDto.getPassword().equals(notepadEntity.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 틀렸습니다.");
        }

        notepadEntity.setTitle(notepadModifyDto.getTitle());
        notepadEntity.setContent(notepadModifyDto.getContent());

        notepadRepository.save(notepadEntity);
    }

//    public void deleteNotepad(Long id, String password) { /** 삭제 isblip 부분을 false로 만든다*/
//        NotepadEntity notepadEntity = notepadRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Notepad not found"));
//
//        if (!password.equals(notepadEntity.getPassword())) {
//            throw new IllegalArgumentException("Incorrect password");
//        }
//
//        notepadEntity.setIsBlip(false);
//        notepadRepository.save(notepadEntity);
//    }
    public void deleteNotepad(Long id) { /** 삭제 isblip 부분을 false로 만든다*/
        NotepadEntity notepadEntity = notepadRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Notepad not found"));

        notepadEntity.setIsBlip(false);

        notepadRepository.save(notepadEntity);
    }

    public NotepadDTO save(NotepadDTO notepadDTO) { /** 그냥 저장용도*/
        NotepadEntity notepadEntity = NotepadEntity.toNotepadEntity(notepadDTO);

        notepadEntity.setDate(new Date());
        notepadEntity.setIsBlip(true);

        return NotepadDTO.toNotepadDTO(notepadRepository.save(notepadEntity));
    }




}
