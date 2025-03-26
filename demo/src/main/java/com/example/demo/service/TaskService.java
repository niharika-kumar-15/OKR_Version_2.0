package com.example.demo.service;

import com.example.demo.model.Objective;
import com.example.demo.model.Task;
import com.example.demo.repository.ObjectiveRepository;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ObjectiveRepository objectiveRepository;

    public Task createTask(Task task) {
        // Ensure the objective exists by checking the objective_id directly
        Objective objective = objectiveRepository.findById(task.getObjectiveId())
                .orElseThrow(() -> new IllegalArgumentException("Objective not found"));

        // Set the objective_id and taskObjective manually
        task.setObjectiveId(objective.getObjectiveId());
        task.setTaskObjective(objective.getObjectiveName());  // Set the objective name for the task

        // Save the task to the repository
        return taskRepository.save(task);
    }
    public List<Task> getTasksByUserId(Long userId) {
        return taskRepository.findByUserId(userId); // Use the repository to fetch tasks by userId
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
}
