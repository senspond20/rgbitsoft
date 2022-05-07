package com.rgbitsoft.data.model.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.rgbitsoft.data.model.dto.AccountDto;
import com.rgbitsoft.data.model.entity.Account;
import com.rgbitsoft.data.model.entity.QAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//public interface AccountRepository extends JpaRepository<Account,Long>, QuerydslPredicateExecutor<Account> {
public interface AccountRepository extends JpaRepository<Account,Long>, CustomAccountRepository {
    Account save(Account account);
    List<Account> findAll();

}
interface CustomAccountRepository {
    List<AccountDto> findAllFromQueryDSL();
    AccountDto findByEmailFromQueryDSL(String email);
}

class CustomAccountRepositoryImpl extends QuerydslRepositorySupport implements CustomAccountRepository {

    private final JPAQueryFactory query;
    private final QAccount account;

    public CustomAccountRepositoryImpl(JPAQueryFactory query) {
        super(Account.class);
        account = QAccount.account;
        this.query = query;
    }

    @Override
    public List<AccountDto> findAllFromQueryDSL(){
        return query.select(
                Projections.constructor(AccountDto.class,
                        account.id,
                        account.nickname,
                        account.email
                )).from(account)
                .fetch();
    }

    @Override
    public AccountDto findByEmailFromQueryDSL(String email) {
        return query.select(
                Projections.constructor(AccountDto.class,
                        account.id,
                        account.nickname,
                        account.email
                )).from(account)
                .where(account.email.eq(email))
                .fetchOne();
    }

}