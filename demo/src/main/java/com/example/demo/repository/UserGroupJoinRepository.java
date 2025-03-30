package com.example.demo.repository;

import com.example.demo.model.User;
import com.example.demo.model.UserGroupJoin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserGroupJoinRepository extends JpaRepository<UserGroupJoin, Long> {

    List<UserGroupJoin> findByGroupId(Long groupId );
}
