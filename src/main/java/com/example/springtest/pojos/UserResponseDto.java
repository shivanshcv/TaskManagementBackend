package com.example.springtest.pojos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Data
@Getter
@Setter
@Component
public class UserResponseDto {
    private Long id;
    private String name;
    private String email;
}
