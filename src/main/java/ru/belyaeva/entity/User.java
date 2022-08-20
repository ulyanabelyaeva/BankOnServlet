package ru.belyaeva.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    private long id;

    private String name;

    private String lastName;

    private String series;

    private String number;

    private Role role;

    private String password;

    private Score score;
}
