package com.tanvan.todolist.service;

import com.tanvan.todolist.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private List<Task> taskList = new ArrayList<Task>();
    public TaskService() {
        taskList.add(new Task(1, "Hoc Spring Boot", false));
        taskList.add(new Task(1, "Hoc Django", false));
        taskList.add(new Task(1, "Hoc su dung git", true));
        taskList.add(new Task(3, "Spring MVC", true));
    }

    public List<Task> getTaskListByID(int id) {
        return taskList.stream()
                .filter(task -> task.getId() == id)
                .collect(Collectors.toList());
    }

    // Thêm một task mới
    public void addTask(Task newTask) {
        taskList.add(newTask);
    }

    // Cập nhật task theo ID
    public boolean updateTask(int id, Task updatedTask) {
        Optional<Task> existingTask = taskList.stream()
                .filter(task -> task.getId() == id)
                .findFirst();

        if (existingTask.isPresent()) {
            Task task = existingTask.get();
            task.setTitle(updatedTask.getTitle());
            task.setDone(updatedTask.isDone());
            return true;
        }
        return false; // Không tìm thấy task để cập nhật
    }

    // Xóa task theo ID
    public boolean deleteTask(int id) {
        return taskList.removeIf(task -> task.getId() == id);
    }
}
