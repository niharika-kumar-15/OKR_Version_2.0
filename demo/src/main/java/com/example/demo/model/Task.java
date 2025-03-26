package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long taskId;

    @Column(name = "task_name", nullable = false)
    private String taskName;

    @Column(name = "objective_id", nullable = false) // Directly storing the objective_id
    private Long objectiveId;

    @Column(name = "description")
    private String description;

    @Column(name = "task_objective", nullable = false)
    private String taskObjective;

    @Column(name = "can_be_divided", nullable = false)
    private Boolean canBeDivided;

    @Column(name = "parent_task_id")
    private Long parentTaskId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "due_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dueDate;

    @Column(name = "progress", nullable = false)
    private Integer progress = 0;

    public Task() {}

    // Constructor for Task
    public Task(String taskName, Long objectiveId, String description, Boolean canBeDivided, Long parentTaskId, Long userId, Date dueDate, String taskObjective) {
        this.taskName = taskName;
        this.objectiveId = objectiveId;
        this.description = description;
        this.canBeDivided = canBeDivided;
        this.parentTaskId = parentTaskId;
        this.userId = userId;
        this.dueDate = dueDate;
        this.taskObjective = taskObjective;
        this.progress = 0;
    }

    public Long getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Long getObjectiveId() {
        return objectiveId;
    }

    public void setObjectiveId(Long objectiveId) {
        this.objectiveId = objectiveId;
    }

    public String getTaskObjective() {
        return taskObjective;
    }

    public void setTaskObjective(String taskObjective) {
        this.taskObjective = taskObjective;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getCanBeDivided() {
        return canBeDivided;
    }

    public void setCanBeDivided(Boolean canBeDivided) {
        this.canBeDivided = canBeDivided;
    }

    public Long getParentTaskId() {
        return parentTaskId;
    }

    public void setParentTaskId(Long parentTaskId) {
        this.parentTaskId = parentTaskId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }
}
