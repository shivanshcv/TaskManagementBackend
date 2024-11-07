package com.example.springtest.pojos;

import com.example.springtest.enums.Status;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class TaskDto {
    private String taskName;
    private String taskDescription;
    private Status status;
}
