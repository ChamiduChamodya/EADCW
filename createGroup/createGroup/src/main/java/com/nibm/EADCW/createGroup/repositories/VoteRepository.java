package com.nibm.EADCW.createGroup.repositories;

import com.nibm.EADCW.createGroup.models.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Integer> {
    @Query("select i from Vote i where i.id=?1")
    List<Vote> findVotesById(String id);

    @Query("select u from Vote u where u.username=?1")
    List<Vote> findVotesByUname(String id);
}
