package com.tanvan.todolist.service;

import com.tanvan.todolist.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private List<Task> taskList = new ArrayList<>();

    public TaskService() {
        taskList.add(new Task(1, "1_1", "Hoc Spring Boot", false));
        taskList.add(new Task(1, "1_2", "Hoc Django", false));
        taskList.add(new Task(1, "1_3", "Hoc su dung git", true));
        taskList.add(new Task(3, "3_1", "Spring MVC", true));
    }

    // Lấy danh sách task theo user_id
    public List<Task> getTaskListByID(int user_id) {
        return taskList.stream()
                .filter(task -> task.getUser_id() == user_id)  // Fix biến id -> user_id
                .collect(Collectors.toList());
    }

    // Thêm một task mới
    public void addTask(Task newTask) {
        taskList.add(newTask);
    }

    // Cập nhật task theo user_id và task_id
    public boolean updateTask(int user_id, String task_id, Task updatedTask) {
        Optional<Task> existingTask = taskList.stream()
                .filter(task -> task.getUser_id() == user_id && task.getTask_id().equals(task_id))  // Fix: Lọc cả user_id và task_id
                .findFirst();

        if (existingTask.isPresent()) {
            Task task = existingTask.get();
            task.setTitle(updatedTask.getTitle());
            task.setDone(updatedTask.isDone());
            return true;
        }
        return false; // Không tìm thấy task để cập nhật
    }

    // Xóa task theo user_id và task_id
    public boolean deleteTask(int user_id, String task_id) {
        return taskList.removeIf(task -> task.getUser_id() == user_id && task.getTask_id().equals(task_id)); // Fix: Lọc cả user_id và task_id
    }
}