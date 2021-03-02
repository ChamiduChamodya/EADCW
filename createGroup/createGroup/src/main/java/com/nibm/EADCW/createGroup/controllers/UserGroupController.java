package com.nibm.EADCW.createGroup.controllers;

import com.nibm.EADCW.createGroup.models.UserGroups;
import com.nibm.EADCW.createGroup.repositories.UserGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserGroupController {

    @Autowired
    private UserGroupRepository userGroupRepository;

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
}
