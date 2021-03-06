package com.nibm.EADCW.createGroup.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nibm.EADCW.createGroup.repositories.GroupRepository;
import com.nibm.EADCW.createGroup.models.CreateGroups;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    //Get Basic Data to New Vote
    //Get Basic Data to Group Details
    //Get Basic Data to Home/Join Group
    @GetMapping(path = "/group/id/{id}")
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

    //Get Basic Data to View My Groups
    @GetMapping(path = "/group/username/{username}")
    public List<CreateGroups> getGroupIdByUname(@PathVariable String username) {
        try {
            List<CreateGroups> groups = groupRepository.findGroupIdByUname(username);
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

    //Save created Group Basic Data
    @PostMapping(path = "/group")
    public ResponseEntity<JsonNode> createGroup(@RequestBody CreateGroups createGroups) throws JsonProcessingException {
        try {
            groupRepository.save(createGroups);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode json = mapper.readTree("{\"result\": \"successful\"}");
            return ResponseEntity.ok(json);
        } catch (Exception e) {
            System.out.println(e.toString());
            ObjectMapper mapper = new ObjectMapper();
            JsonNode json = mapper.readTree("{\"result\": \"unsuccessful\"}");
            return ResponseEntity.ok(json);
        }
    }
}
