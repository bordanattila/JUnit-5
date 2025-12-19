package task;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void testTaskClass() {
        Task task = new Task("12345", "Class Test", "Testing the Task class with valid values.");
        assertTrue(task.getTaskID().equals("12345"));
        assertTrue(task.getTaskName().equals("Class Test"));
        assertTrue(task.getTaskDescription().equals("Testing the Task class with valid values."));
    }

    @Test
    void testTaskClassTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(
                    "123456789012",
                    "Runing Class Test with inputs that are have longer character cout than allowed.",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec congue tincidunt massa, eget tempus arcu feugiat vitae. Nunc fermentum urna eget ante fringilla, in rutrum metus convallis. Nullam vehicula ex nec aliquet accumsan. Cras fermentum auctor ligula, convallis vehicula odio interdum at. Fusce finibus nisi sit amet diam feugiat semper. Nam finibus nibh sit amet."
            );
        });
    }


    @Test
    void testTaskClassNullValues() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(
                    null,
                    "Class Test Null",
                    "Testing the Task Class with new values for each"
            );
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(
                    "123",
                    null,
                    "Testing the Task Class with new values for each"
            );
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(
                    "123",
                    "Class Test Null",
                    null
            );
        });
    }

    @Test
    void testTaskClassWithExactValues() {
        Task task = new Task("1234567890", "Class Test with 20 c", "Testing the Task class wvalid values.");
        assertTrue(task.getTaskID().equals("1234567890"));
        assertTrue(task.getTaskName().equals("Class Test with 20 c"));
        assertTrue(task.getTaskDescription().equals("Testing the Task class wvalid values."));
    }

    @Test
    void testTaskClassSetters() {
        Task task = new Task("12345", "Class Test", "Testing the Task class with valid values.");
        task.setTaskName("Testing name update");
        task.setTaskDescription("Testing descriptioni update");

        assertTrue(task.getTaskID().equals("12345"));
        assertTrue(task.getTaskName().equals("Testing name update"));
        assertTrue(task.getTaskDescription().equals("Testing descriptioni update"));

        assertThrows(IllegalArgumentException.class, () -> {
            task.setTaskName("Runing Class Test with long inputs");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            task.setTaskDescription("Testing the Task Class with new values for the descriptiong iwth long value.");
        });
    }

    @Test
    void testTaskIDIsNotUpdatable() {
        Task task = new Task("12345", "Test", "Description");
        assertEquals("12345", task.getTaskID());
    }
}
