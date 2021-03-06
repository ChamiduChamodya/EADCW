package com.nibm.EADCW.createGroup.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nibm.EADCW.createGroup.models.UserVote;
import com.nibm.EADCW.createGroup.repositories.UserVoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserVoteController {

    @Autowired
    private UserVoteRepository userVoteRepository;

    @GetMapping("/uservote/ping")
    public String ping() {
        return "pong";
    }

    @GetMapping(path = "/uservote/{id}")
    public List<UserVote> getGroupById(@PathVariable String id) {
        try {
            List<UserVote> userVotes = userVoteRepository.findUserVotesById(id);
            if (!userVotes.isEmpty()) {
                return userVotes;
            } else {
                System.out.println("no");
                return null;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
    }

    @GetMapping(path = "/uservote/username/{username}")
    public List<UserVote> getGroupByUname(@PathVariable String username) {
        try {
            List<UserVote> userVotes = userVoteRepository.findUserVotesByUname(username);
            if (!userVotes.isEmpty()) {
                return userVotes;
            } else {
                System.out.println("no");
                return null;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
    }

    @GetMapping(path = "/uservote/count/{id}")
    public ResponseEntity<JsonNode> getVoteCountById(@PathVariable String id) throws JsonProcessingException {
        int count = 0;
        ObjectMapper mapper = new ObjectMapper();
        String newString = "{\"result\": \"" + count + "\"}";
        JsonNode json = mapper.readTree(newString);
        try {
            count = userVoteRepository.findVoteCountById(id);
            System.out.println(count);
            String newString2 = "{\"result\": \"" + count + "\"}";
            json = mapper.readTree(newString2);
            if (count != 0) {
                return ResponseEntity.ok(json);
            } else {
                System.out.println("no");
                return ResponseEntity.ok(json);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            return ResponseEntity.ok(json);
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
