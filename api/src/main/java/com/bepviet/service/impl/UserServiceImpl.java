package com.bepviet.service.impl;

import com.bepviet.converter.EntityToDtoConverter;
import com.bepviet.dto.UserDto;
import com.bepviet.repository.UserRepository;
import com.bepviet.repository.entity.UserEntity;
import com.bepviet.service.UserService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final EntityToDtoConverter entityToDtoConverter;

    public UserServiceImpl(UserRepository userRepository, EntityToDtoConverter entityToDtoConverter) {
        this.userRepository = userRepository;
        this.entityToDtoConverter = entityToDtoConverter;
    }
    public List<UserDto> findAll(Map<String, Object> params){
        List<UserEntity> userEntities = (List<UserEntity>) userRepository.findAll();
        return entityToDtoConverter.convertToDtoList(userEntities, UserDto.class);
    }
    public UserDetails loadUserByUsername(String email){
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email:" + email));
        return User.builder()
                .username(userEntity.getFullName())
                .password(userEntity.getPassword())
                .roles(userEntity.getRole().name())
                .build();

    }
}
