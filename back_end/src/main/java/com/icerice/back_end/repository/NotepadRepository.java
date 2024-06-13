package com.icerice.back_end.repository;

import com.icerice.back_end.entity.NotepadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotepadRepository extends JpaRepository<NotepadEntity, Long> {
}