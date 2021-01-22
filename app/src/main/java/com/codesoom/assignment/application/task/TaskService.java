package com.codesoom.assignment.application.task;

import com.codesoom.assignment.application.IdGenerator;
import com.codesoom.assignment.domain.Task;

import java.util.*;

public class TaskService {
    private Map<Long, Task> tasks = new HashMap<>();
    private final IdGenerator idGenerator = new IdGenerator();

    public Task getTask(long id) {
        return getTaskById(id);
    }

    public List<Task> getTasks() {
        return new ArrayList<>(tasks.values());
    }

    public Task createNewTask(String title) {
        Task task = new Task(idGenerator.generateNewTaskId(), title);
        tasks.put(task.getId(), task);
        System.out.println("Completed to create task - " + task.toString());
        return task;
    }

    public Task updateTask(long id, String newTitle) {
        Task task = getTaskById(id);
        task.setTitle(newTitle);
        System.out.println("Completed to update task - " + task.toString());
        return task;
    }

    public Optional<Task> deleteTask(long id) {
        return findTaskById(id).map(task -> tasks.remove(task.getId()));
    }

    private Optional<Task> findTaskById(long id) {
        return Optional.ofNullable(tasks.get(id));
    }
}
