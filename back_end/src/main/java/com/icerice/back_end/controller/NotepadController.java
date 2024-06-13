package com.icerice.back_end.controller;

import com.icerice.back_end.dto.NotepadDTO;
import com.icerice.back_end.dto.NotepadMainDTO;
import com.icerice.back_end.dto.NotepadModifyDto;
import com.icerice.back_end.service.NotepadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notepad")
@RequiredArgsConstructor
public class NotepadController {
    private final NotepadService notepadService;

    @GetMapping("")
    public ResponseEntity<List<NotepadMainDTO>> getBlipNotepads() {
        List<NotepadMainDTO> blipNotepads = notepadService.findBlipNotepads();
        return ResponseEntity.ok(blipNotepads);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotepadMainDTO> getById(@PathVariable("id") Long id) {
        NotepadMainDTO notepadMainDTO = notepadService.getById(id);
        return ResponseEntity.ok(notepadMainDTO);
    }

    @PostMapping("/add")
    public ResponseEntity<NotepadDTO> addNotepad(@RequestBody NotepadDTO notepadDTO) {
        notepadService.save(notepadDTO);
        return ResponseEntity.ok(notepadDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> modify(@PathVariable("id") Long id, @RequestBody NotepadModifyDto notepadModifyDto) {
        notepadService.modify(id, notepadModifyDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotepad(@PathVariable("id") Long id) {
        notepadService.deleteNotepad(id);
        return ResponseEntity.ok().build();
    }
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteNotepad(@PathVariable("id") Long id, @RequestParam("password") String password) {
//        notepadService.deleteNotepad(id, password);
//        return ResponseEntity.ok().build();
//    }

}
