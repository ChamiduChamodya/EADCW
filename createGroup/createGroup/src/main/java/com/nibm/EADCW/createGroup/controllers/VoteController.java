package com.nibm.EADCW.createGroup.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nibm.EADCW.createGroup.models.Vote;
import com.nibm.EADCW.createGroup.repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class VoteController {

    @Autowired
    private VoteRepository voteRepository;

    @GetMapping("/vote/ping")
    public String ping() {
        return "pong";
    }

    @GetMapping(path = "/vote/{id}")
    public List<Vote> getGroupById(@PathVariable String id) {
        try {
            List<Vote> votes = voteRepository.findVotesById(id);
            if (!votes.isEmpty()) {
                return votes;
            } else {
                System.out.println("no");
                return null;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
    }

    @GetMapping(path = "/vote/username/{username}")
    public List<Vote> getGroupIdByUname(@PathVariable String username) {
        try {
            List<Vote> votes = voteRepository.findVotesByUname(username);
            if (!votes.isEmpty()) {
                return votes;
            } else {
                System.out.println("no");
                return null;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
    }

    @PostMapping("/vote")
    public ResponseEntity<JsonNode> createNutrientList(@RequestBody Map<String, Object> requestBody) throws JsonProcessingException {
        try {
            Vote vote;
            for (int i = 0; i < requestBody.size() - 2; i++) {
                vote = new Vote(requestBody.get("id").toString(), requestBody.get("username").toString(), requestBody.get(String.valueOf(i)).toString());
                voteRepository.save(vote);
            }
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
