package com.bepviet.dto;

import com.bepviet.enums.Role;
import lombok.Data;

@Data
public class UserDto {
    private String fullName;
    private String email;
    private Role role;
    private String password;
}
