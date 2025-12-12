package com.bepviet.controller;

import com.bepviet.dto.UserDto;
import com.bepviet.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users/")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    @PreAuthorize("hasRole('MANAGER')")
    public List<UserDto> findAll(@RequestParam(required = false) Map<String, Object> params, Authentication authentication){
        var auth = SecurityContextHolder.getContext().getAuthentication();

        return userService.findAll(params);
    }
}
