package com.example.demo.controller;

import com.example.demo.model.UserGroupJoin;
import com.example.demo.service.UserGroupJoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/user-group-join")
public class UserGroupJoinController {

    private final UserGroupJoinService userGroupJoinService;

    @Autowired
    public UserGroupJoinController(UserGroupJoinService userGroupJoinService) {
        this.userGroupJoinService = userGroupJoinService;
    }

    // Create a new UserGroupJoin record
    @PostMapping("/create")
    public ResponseEntity<UserGroupJoin> createUserGroupJoin(@RequestBody UserGroupJoin userGroupJoin) {
        UserGroupJoin createdJoin = userGroupJoinService.createUserGroupJoin(userGroupJoin.getGroupId(), userGroupJoin.getUserId());
        return new ResponseEntity<>(createdJoin, HttpStatus.CREATED);
    }


    // Get all UserGroupJoin records
    @GetMapping("/all")
    public ResponseEntity<List<UserGroupJoin>> getAllUserGroupJoins() {
        List<UserGroupJoin> joins = userGroupJoinService.getAllUserGroupJoins();
        return ResponseEntity.ok(joins);
    }

    // Get a specific UserGroupJoin by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserGroupJoin> getUserGroupJoinById(@PathVariable Long id) {
        Optional<UserGroupJoin> join = userGroupJoinService.getUserGroupJoinById(id);
        return join.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete UserGroupJoin by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUserGroupJoin(@PathVariable Long id) {
        userGroupJoinService.deleteUserGroupJoin(id);
        return ResponseEntity.noContent().build();
    }

    // Get all UserGroupJoin records for a specific groupId
    @GetMapping("/group/{groupId}")
    public ResponseEntity<List<UserGroupJoin>> getUserGroupJoinsByGroupId(@PathVariable Long groupId) {
        List<UserGroupJoin> joins = userGroupJoinService.getUserGroupJoinsByGroupId(groupId);
        return ResponseEntity.ok(joins);
    }

    // Get all UserGroupJoin records for a specific userId
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<UserGroupJoin>> getUserGroupJoinsByUserId(@PathVariable Long userId) {
        List<UserGroupJoin> joins = userGroupJoinService.getUserGroupJoinsByUserId(userId);
        return ResponseEntity.ok(joins);
    }
}
