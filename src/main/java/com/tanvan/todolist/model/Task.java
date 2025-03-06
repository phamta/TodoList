package com.tanvan.todolist.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    private int user_id;
    private String task_id;
    private String title;
    private boolean done;
}
