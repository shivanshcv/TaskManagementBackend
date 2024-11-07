package com.example.springtest.pojos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UserDto {
    private String name;
    private String email;
    private String password;
}
