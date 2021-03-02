package com.nibm.EADCW.createGroup.controllers;

import com.nibm.EADCW.createGroup.models.PoolData;
import com.nibm.EADCW.createGroup.models.UserGroups;
import com.nibm.EADCW.createGroup.repositories.PoolRepository;
import com.nibm.EADCW.createGroup.repositories.UserGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class UserGroupController {

    @Autowired
    private UserGroupRepository userGroupRepository;

    @Autowired
    private PoolRepository poolRepository;

    @GetMapping("/user/group/ping")
    public String ping() {
        return "pong";
    }

    @GetMapping(path = "/user/group/{id}")
    public List<UserGroups> getUserGroupById(@PathVariable int id) {
        try {
            List<UserGroups> groups = userGroupRepository.findUserGroupById(id);
            if (!groups.isEmpty()) {
                return groups;
            } else {
                System.out.println("no");
                return null;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
    }

    @PostMapping(path = "/user/group")
    public String createGroup(@RequestBody UserGroups userGroups) {
        try {
            userGroupRepository.save(userGroups);
            return "successful";
        } catch (Exception e) {
            System.out.println(e.toString());
            return "unsuccessful";
        }
    }

    @GetMapping(path = "/pooldata/{groupId}")
    public List<PoolData> getPoolDataById(@PathVariable String groupId) {
        try {
            List<PoolData> poolData = poolRepository.findPoolDataById(groupId);
            if (!poolData.isEmpty()) {
                return poolData;
            } else {
                System.out.println("no");
                return null;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
    }


    @PostMapping("/pooldata")
    public void createNutrientList(@RequestBody Map<String, Object> requestBody) {
        System.out.println(requestBody.size());
        PoolData poolData;
        for (int i = 0; i < requestBody.size()-2; i++){
            poolData = new PoolData(requestBody.get("username").toString(),requestBody.get("id").toString(),requestBody.get(String.valueOf(i)).toString());
            poolRepository.save(poolData);
        }
    }
}
