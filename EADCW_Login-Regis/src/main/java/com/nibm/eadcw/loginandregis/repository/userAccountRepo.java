package com.nibm.eadcw.loginandregis.repository;

import com.nibm.eadcw.loginandregis.model.userAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface userAccountRepo extends JpaRepository<userAccount,String> {

    @Query(value = "SELECT u.password FROM userAccount u WHERE u.email = ?1 ")
    String getPasswordByEmail(String email);
}
