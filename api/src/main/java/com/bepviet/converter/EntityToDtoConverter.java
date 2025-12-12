package com.bepviet.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EntityToDtoConverter {
    private final ModelMapper modelMapper;
    public EntityToDtoConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public <S, T> T convertToDto(S source, Class<T> targetClass){
        return modelMapper.map(source, targetClass);
    }

    public <S, T> List<T> convertToDtoList(List<S> sourceList, Class<T> targetClass) {
        if (sourceList == null || sourceList.isEmpty()) {
            return Collections.emptyList();
        }
        return sourceList.stream()
                .map(source -> convertToDto(source, targetClass))
                .collect(Collectors.toList());
    }
    public <S, T> T convertToEntity(S source, Class<T> targetClass){
        return modelMapper.map(source, targetClass);
    }
}
