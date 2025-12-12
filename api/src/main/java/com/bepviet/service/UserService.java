package com.bepviet.service;

import com.bepviet.dto.UserDto;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<UserDto> findAll(Map<String, Object> params);
}
