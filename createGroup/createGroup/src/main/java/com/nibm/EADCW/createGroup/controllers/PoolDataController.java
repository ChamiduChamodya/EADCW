package com.nibm.EADCW.createGroup.controllers;

import com.nibm.EADCW.createGroup.models.PoolData;
import com.nibm.EADCW.createGroup.repositories.PoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class PoolDataController {

    @Autowired
    private PoolRepository poolRepository;

    @GetMapping("pooldata/ping")
    public String ping() {
        return "pong";
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
        for (int i = 0; i < requestBody.size() - 2; i++) {
            poolData = new PoolData(requestBody.get("username").toString(), requestBody.get("id").toString(), requestBody.get(String.valueOf(i)).toString());
            poolRepository.save(poolData);
        }
    }
}
