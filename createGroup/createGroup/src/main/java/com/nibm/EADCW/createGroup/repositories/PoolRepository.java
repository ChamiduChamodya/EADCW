package com.nibm.EADCW.createGroup.repositories;

import com.nibm.EADCW.createGroup.models.PoolData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PoolRepository extends JpaRepository<PoolData, Integer> {
    @Query("select p from PoolData p where p.groupId=?1")
    List<PoolData> findPoolDataById(String groupId);
}
