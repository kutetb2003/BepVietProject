package com.bepviet.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EntityToDtoConverter {
    private final ModelMapper modelMapper;
    public EntityToDtoConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public <S, T> T convertToDto(S source, Class<T> targetClass){
        return modelMapper.map(source, targetClass);
    }
}
