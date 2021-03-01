package com.nibm.EADCW.createGroup;

import com.nibm.EADCW.createGroup.models.Groups;
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

    @GetMapping(path = "/groups/{id}")
    public List<Groups> getGroupById(@PathVariable int id) {
        try {
            List<Groups> groups = groupRepository.findGroupById(id);
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

    @PostMapping(path = "/groups")
    public String createGroup(@RequestBody Groups groups) {
        try {
            groupRepository.save(groups);
            return "successful";
        } catch (Exception e) {
            System.out.println(e.toString());
            return "unsuccessful";
        }
    }
}
