package com.example.demo.repository;

import com.example.demo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUserId(Long userId);
    List<Task> findByObjectiveId(Long objectiveId);

        @Query("SELECT SUM(a.progress) FROM Task a WHERE a.taskId = :taskId OR a.parentTaskId = :taskId")
        long getOverallProgressForTask(@Param("taskId") Long taskId);

        @Query("SELECT t FROM Task t WHERE t.parentTaskId = :parentTaskId")
        List<Task> getSubtasksByTask(@Param("parentTaskId") Long parentTaskId);

}