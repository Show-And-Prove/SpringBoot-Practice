package com.example.demo.domain;

import lombok.*;


import javax.persistence.*;

/*
* === board Table ===
* create table board (
* bid bigint primary key auto increment,
* title varchar(100) not null,
* content varchar(1000) not null,
* writer varchar(30) not null,
* regdate datetime default now(),
* moddate datetime default now()
* );
*
 */




@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Board extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bid;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 1000, nullable = false)
    private String content;

    @Column(length = 30, nullable = false)
    private String writer;

    //update문으로 바뀔 여지가 있는것들
    public void change(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
