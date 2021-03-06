package com.nibm.EADCW.createGroup.repositories;

import com.nibm.EADCW.createGroup.models.UserVote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserVoteRepository extends JpaRepository<UserVote, Integer> {

    @Query("select count(v) from UserVote v where v.id=?1")
    int findVoteCountById(String id);
}
