package com.nibm.eadcw.loginandregis.repository;

import com.nibm.eadcw.loginandregis.model.userAccountDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface userAccountDetailsRepo extends JpaRepository<userAccountDetails,String> {

    @Query(value = "SELECT u.tel_no FROM userAccountDetails u WHERE u.username = ?1")
    String getTelefromUsername(String user);
}
