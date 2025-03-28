package com.example.demo.repository;

import com.example.demo.model.UserGroupJoin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserGroupJoinRepository extends JpaRepository<UserGroupJoin, Long> {

}
