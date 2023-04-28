package com.example.demo.BusinessLayer;

import com.example.demo.dtos.DreamDto;

import java.util.List;

public interface DreamService {
    DreamDto save(DreamDto dreamDto);
    void update(DreamDto dreamDto);
    void delete(Long id);
    List<DreamDto> findAll();
}
