package com.nibm.EADCW.createGroup.repositories;

import com.nibm.EADCW.createGroup.models.UserGroups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserGroupRepository extends JpaRepository<UserGroups, Integer> {
    @Query("select u from UserGroups u where u.id=?1")
    List<UserGroups> findUserGroupById(int id);
}