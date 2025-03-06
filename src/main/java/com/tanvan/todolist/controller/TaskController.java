package com.tanvan.todolist.controller;

import com.tanvan.todolist.model.Task;
import com.tanvan.todolist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("{id}")
    public List<Task> getTaskListById(@PathVariable int id) {
        return taskService.getTaskListByID(id);
    }

    @PostMapping("/add")
    public void addTask(@RequestBody Task newTask) {
        taskService.addTask(newTask);
    }

    @PutMapping("/update/{id}")
    public boolean updateTask(@PathVariable int id, @RequestBody Task updatedTask) {
        return taskService.updateTask(id, updatedTask);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteTask(@PathVariable int id) {
        return taskService.deleteTask(id);
    }
}
