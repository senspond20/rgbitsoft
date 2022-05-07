package com.rgbitsoft.data.model.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class AccountDto {
    private Long id;
    private String nickname;
    private String email;

    public AccountDto(Long id, String nickname, String email){
        this.id = id;
        this.nickname = nickname;
        this.email = email;
    }
}

