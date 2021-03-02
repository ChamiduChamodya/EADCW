package com.nibm.EADCW.createGroup.controllers;

import com.nibm.EADCW.createGroup.repositories.GroupRepository;
import com.nibm.EADCW.createGroup.models.CreateGroups;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GroupController {

    @Autowired
    private GroupRepository groupRepository;

    @GetMapping("/group/ping")
    public String ping() {
        return "pong";
    }

    @GetMapping(path = "/group/{id}")
    public List<CreateGroups> getGroupById(@PathVariable int id) {
        try {
            List<CreateGroups> groups = groupRepository.findGroupById(id);
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

    @PostMapping(path = "/group")
    public String createGroup(@RequestBody CreateGroups createGroups) {
        try {
            groupRepository.save(createGroups);
            return "successful";
        } catch (Exception e) {
            System.out.println(e.toString());
            return "unsuccessful";
        }
    }
}
