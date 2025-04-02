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

    public List<Task> getTasksByeObjective(Long objectiveId) {
        return taskRepository.findByObjectiveId(objectiveId);
    }

    public long getOverallProgressForTask(Long taskId) {
        return taskRepository.getOverallProgressForTask(taskId);
    }

    public List<Task> getSubtasksByTask(Long parentTaskId) {
        return taskRepository.getSubtasksByTask(parentTaskId);
    }

    public List<Task> getAllSubTasks() {
        return taskRepository.getAllSubTasks();
    }



    // adding each progress
    public Task updateTaskProgress(Long taskId, Integer progress) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        task.setProgress(progress);
        return taskRepository.save(task);
    }
    public Integer calculateOverallProgress(Long objectiveId) {
        // Query the repository to get the tasks for the given objective
        List<Task> tasks = taskRepository.findByObjectiveId(objectiveId);

        // Calculate the sum of progress values
        int totalProgress = tasks.stream().mapToInt(Task::getProgress).sum();

        // Calculate the average progress (totalProgress divided by the number of tasks)
        int taskCount = tasks.size();

        // If there are tasks, calculate the average; otherwise, return 0
        if (taskCount > 0) {
            return totalProgress / taskCount;  // Integer division
        } else {
            return 0;
        }
    }





}
