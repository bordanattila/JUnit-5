package task;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

class TaskService {
    private Map<String, Task> tasks = new HashMap<>();

    public void addTask(String id, String name, String description) {
        if (tasks.containsKey(id)) {
            throw new IllegalStateException("Duplicate Task ID, Task ID must be unique.");
        }
        Task task = new Task(id, name, description);
        tasks.put(id, task);
    }

    public void removeTask(String id){
        if (tasks.remove(id) == null) {
            throw new NoSuchElementException("Task ID not found.");
        }
    }

    public void updateTask(String id, String name, String description) {
        Task taskToUpdate = tasks.get(id);

        if (taskToUpdate == null) {
            throw new NoSuchElementException("Task ID is required to update information");
        }
        if (name != null && !name.isBlank()) {
            taskToUpdate.setTaskName(name);
        }
        if (description != null && !description.isBlank()) {
            taskToUpdate.setTaskDescription(description);
        }
    }

    public Task getTask(String id) {
        return tasks.get(id);
    }
}
