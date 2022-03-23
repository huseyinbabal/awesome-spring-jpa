package com.example.awesomespringjpa.models;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private long expireDate;

    @OneToOne(cascade = CascadeType.ALL)
    private Person person;
}
