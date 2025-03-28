package com.example.demo.service;

import com.example.demo.model.Group;
import com.example.demo.repository.GroupRepository;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService {

    private final GroupRepository groupRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    // Create or Update a Group
    public Group saveOrUpdateGroup(Group group) {
        return groupRepository.save(group);
    }


    @Transactional
    public Group createGroup(Group group) {
        if (group.getGroupId() != null && groupRepository.existsById(group.getGroupId())) {
            // If groupId is present, update the existing group
            // You can modify the group fields that can be updated.
            return groupRepository.save(group);  // This will update the existing group
        } else {
            // If no groupId, it's a new group, so create a new one
            return groupRepository.save(group);  // This will create a new group
        }
    }
    // Get all Groups

    @Transactional
    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    // Get a Group by its ID
    public Optional<Group> getGroupById(Long groupId) {
        return groupRepository.findById(groupId);
    }

    // Delete a Group by its ID
    public void deleteGroup(Long groupId) {
        groupRepository.deleteById(groupId);
    }
}
