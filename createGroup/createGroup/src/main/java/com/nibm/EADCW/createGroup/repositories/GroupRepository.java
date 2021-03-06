package com.nibm.EADCW.createGroup.repositories;

import com.nibm.EADCW.createGroup.models.CreateGroups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<CreateGroups, Integer> {
    @Query("select i from CreateGroups i where i.id=?1")
    List<CreateGroups> findGroupById(int id);

    @Query("select u from CreateGroups u where u.username=?1")
    List<CreateGroups> findGroupIdByUname(String id);
}
