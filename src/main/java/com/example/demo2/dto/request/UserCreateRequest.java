package com.example.demo2.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateRequest {
    private long id;
    private String name;
    private Integer age;

}
