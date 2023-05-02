package com.example.demo2.domain.user;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    // protected User() {}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Column(nullable = false)
    private String name;
    private Integer age;

    public User(String name, Integer age){
//        if(name == null || name.isBlank()) {
//            throw new IllegalArgumentException(String.format("잘못된 name(%s)가 들어왔습니다.", name));
//        }
        this.name = name;
        this.age = age;
    }
}
