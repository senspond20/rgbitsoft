package com.rgbitsoft.data.model.repository;


import com.rgbitsoft.data.model.dto.AccountDto;
import com.rgbitsoft.data.model.entity.Account;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class AccountRepoTests {

    @Autowired
    private AccountRepository accountRepository;

    @BeforeEach
    void setup(){
        accountRepository.save(Account.builder().email("1231@gmail.com").nickname("아이바당").password("비밀번호").build());
        accountRepository.save(Account.builder().email("1efe@gmail.com").nickname("오이에").password("비밀번호12").build());
        accountRepository.save(Account.builder().email("efe@gmail.com").nickname("가나다당").password("비밀번호242").build());
    }
    @DisplayName("JPA 기본 findAll Test")
    @Test
    void findAllTest1(){
        List<Account> list = accountRepository.findAll();
        list.forEach(System.out::println);
    }


    @DisplayName("Query DSL Custom find")
    @Test
    void findAllTest2(){
        List<AccountDto> list = accountRepository.findAllFromQueryDSL();
        list.forEach(System.out::println);
    }
    @DisplayName("Query DSL Custom find")
    @Test
    void findAllTest3(){
        AccountDto accountDto = accountRepository.findByEmailFromQueryDSL("1231@gmail.com");
        System.out.println(accountDto);
    }

    @Test
    void test3(){
        List<Account> list = accountRepository.findAll();
        System.out.println(list);
    }

    @Test
    void crud(){
        System.out.println("df");
//        QAccount account = QAccount.account;
//
//        Predicate predicate = account.email.containsIgnoreCase("서초구")
//                .and(account.email.startsWith("개포"));

        // Optional<Account> one = accountRepository.findOne(predicate);
        // assertThat(one).isEmpty();
    }
}
