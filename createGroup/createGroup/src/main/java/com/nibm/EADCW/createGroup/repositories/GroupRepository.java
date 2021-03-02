package com.nibm.EADCW.createGroup.repositories;

import com.nibm.EADCW.createGroup.models.CreateGroups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<CreateGroups, Integer > {
    @Query("select g from CreateGroups g where g.id=?1")
    List<CreateGroups> findGroupById(int id);
}
