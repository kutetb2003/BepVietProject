package com.bepviet.service;

import com.bepviet.dto.CuisineDto;

import java.util.List;

public interface CuisineService {
    CuisineDto findById(Long id);
    List<CuisineDto> findAll();
}
