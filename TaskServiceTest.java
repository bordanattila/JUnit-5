package task;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskServiceTest {
    private TaskService newTask;

    @BeforeEach
    void beforeEachTest() {
        newTask = new TaskService();
        newTask.addTask("123", "new Task", "This is a new task.");
    }

    @Test
    void testTaskServiceClassAddTask() {

        Task retrievedTask = newTask.getTask("123");
        assertTrue(retrievedTask.getTaskID().equals("123"));
        assertTrue(retrievedTask.getTaskName().equals("new Task"));
        assertTrue(retrievedTask.getTaskDescription().equals("This is a new task."));
    }

    @Test
    void testTaskSErviceClassDuplicateId() {
       assertThrows(IllegalStateException.class, () -> {
           newTask.addTask("123", "another new Task", "This is another new task.");
       });
    }

    @Test
    void testTaskServiceClassRemoveTask() {
        assertDoesNotThrow(() -> {
            newTask.removeTask("123");
        });
    }

    @Test
    void testTaskServiceClassRemoveTaskNotFound() {
        assertThrows(NoSuchElementException.class, () -> {
            newTask.removeTask("12345");
        });
    }

    @Test
    void testTaksServiceClassUpdateAllFields() {
        newTask.updateTask("123", "Name Updated", "Description updated");
        Task updated = newTask.getTask("123");
        assertTrue(updated.getTaskName().equals("Name Updated"));
        assertTrue(updated.getTaskDescription().equals("Description updated"));
    }

    @Test
    void testTaksServiceClassUpdateName() {
        newTask.updateTask("123", "Name only updated", null);
        Task updated = newTask.getTask("123");
        assertTrue(updated.getTaskName().equals("Name only updated"));
    }

    @Test
    void testTaksServiceClassUpdateDescription() {
        newTask.updateTask("123", null, "Desctiption only updated");
        Task updated = newTask.getTask("123");
        assertTrue(updated.getTaskDescription().equals("Desctiption only updated"));
    }

    @Test
    void testTaskSErviceClassUpdateAllNull() {
        newTask.updateTask("123", null, null);
        Task updated = newTask.getTask("123");
        assertTrue(updated.getTaskName().equals("new Task"));
        assertTrue(updated.getTaskDescription().equals("This is a new task."));
    }

    @Test
    void testTaksServiceClassTaskIdNull() {
        assertThrows(NoSuchElementException.class, () -> {
            newTask.updateTask(null,  "Name updated", "Desctiption updated");
        });
    }

    @Test
    void testTaskServiceClassTaskNotFound() {
        Task task = newTask.getTask("999");
        assertNull(task);
    }

    @Test
    void testTaskServiceClassTaskExists() {
        Task task = newTask.getTask("123");
        assertTrue(task.getTaskID().equals("123"));
        assertTrue(task.getTaskName().equals("new Task"));
        assertTrue(task.getTaskDescription().equals("This is a new task."));
    }
}
