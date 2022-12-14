package com.account;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.account.data.Account;

@RepositoryRestResource(collectionResourceRel = "account", path = "account")
public interface AccountRepository  extends PagingAndSortingRepository<Account, Long> {
    
    List<Account> findByAccountNumber(@Param("account") int account);
}
