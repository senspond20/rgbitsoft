package com.rgbitsoft.data.model.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
@Table(name = "ACCOUNT")
public class Account {

    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)  //: Mysql
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AccountSeqGenerator")
    @SequenceGenerator(sequenceName = "AccountSeq", name = "AccountSeqGenerator", allocationSize = 1)
    private Long id;

    @Column(nullable = false, length = 30)
    private String nickname;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false, length = 255)
    private String email;

    @CreationTimestamp
    private Timestamp createDate;


    @Builder
    public Account(String nickname, String password, String email){
        this.nickname = nickname;
        this.password = password;
        this.email = email;
    }
}