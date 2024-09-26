package com.doong.practice.team;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Team {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    public Team(String title) {
        this.title = title;
    }

    /*@OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<>();*/
}
