package com.nibm.eadcw.loginandregis.repository;

import com.nibm.eadcw.loginandregis.model.userAccountDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userAccountDetailsRepo extends JpaRepository<userAccountDetails,String> {
}
