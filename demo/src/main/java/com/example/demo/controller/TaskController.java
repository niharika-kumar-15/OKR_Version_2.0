package com.example.demo.controller;

import com.example.demo.model.Task;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/create")
    public ResponseEntity<?> createTask(@RequestBody Task task) {
        System.out.println("Received Task: " + task);
        return ResponseEntity.ok(taskService.createTask(task));
    }


    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Task>> getTasksByUserId(@PathVariable Long userId) {
        List<Task> tasks = taskService.getTasksByUserId(userId);
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();  // Calls the service method to fetch all tasks
        return ResponseEntity.ok(tasks);
    }


    @GetMapping("/getTasks/{objectiveId}")
    public ResponseEntity<List<Task>> getTasksByObjective(@PathVariable Long objectiveId){
        List<Task> tasks = taskService.getTasksByeObjective(objectiveId);
        return ResponseEntity.ok(tasks);
    }


    @GetMapping("getSubtasks/{parentTaskId}")
    public ResponseEntity<List<Task>> getSubtasksByTask(@PathVariable Long parentTaskId){
        List<Task> subTasks = taskService.getSubtasksByTask(parentTaskId);
        return  ResponseEntity.ok(subTasks);
    }


    @GetMapping("/all/subtasks")
    public ResponseEntity<List<Task>> getAllSubTasks() {
        List<Task> tasks = taskService.getAllSubTasks();  // Calls the service method to fetch all tasks
        return ResponseEntity.ok(tasks);
    }

    //adding progress for each task
    @PutMapping("/{taskId}/progress/{progress}")
    public ResponseEntity<Task> updateTaskProgress(@PathVariable Long taskId, @PathVariable Integer progress) {
        Task updatedTask = taskService.updateTaskProgress(taskId, progress);
        return ResponseEntity.ok(updatedTask);
    }
    // getting the overall progress
    @GetMapping("/objective/{objectiveId}/progress")
    public ResponseEntity<Integer> getOverallProgress(@PathVariable Long objectiveId) {
        Integer overallProgress = taskService.calculateOverallProgress(objectiveId);
        return ResponseEntity.ok(overallProgress);
    }



}
