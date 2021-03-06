package com.nibm.EADCW.createGroup.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nibm.EADCW.createGroup.models.UserVote;
import com.nibm.EADCW.createGroup.repositories.UserVoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserVoteController {

    @Autowired
    private UserVoteRepository userVoteRepository;

    @GetMapping("/uservote/ping")
    public String ping() {
        return "pong";
    }

    @GetMapping(path = "/uservote/count/{id}")
    public int getVoteCountById(@PathVariable String id) {
        try {
            int count = userVoteRepository.findVoteCountById(id);
            if (count != 0) {
                return count;
            } else {
                System.out.println("no");
                return 0;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            return 0;
        }
    }

    @PostMapping(path = "/uservote")
    public ResponseEntity<JsonNode> createGroup(@RequestBody UserVote userVote) throws JsonProcessingException {
        try {
            userVoteRepository.save(userVote);
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
