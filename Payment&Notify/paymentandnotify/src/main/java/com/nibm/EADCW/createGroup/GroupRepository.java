package com.nibm.EADCW.createGroup;

import com.nibm.EADCW.createGroup.models.Groups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Groups, Integer > {
    @Query("select g from Groups g where g.id=?1")
    List<Groups> findGroupById(int id);
}
