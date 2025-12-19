package task;

class Task {
    private final String taskID;
    private String taskName;
    private String taskDescription;

    Task(String taskID, String taskName, String taskDescription) {
        this.taskID = validateTaskID(taskID);
        this.taskName = validateTaskName(taskName);
        this.taskDescription = validateTaskDescription(taskDescription);

    }
    public String getTaskID() {
        return taskID;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskName(String taskName) {
        this.taskName = validateTaskName(taskName);
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = validateTaskDescription(taskDescription);
    }

    public static String validateTaskID(String taskID) {
        if (taskID == null || taskID.isBlank()) {
            throw new IllegalArgumentException("Task ID is required.");
        }
        taskID = taskID.trim();
        if (taskID.length() > 10) {
            throw new IllegalArgumentException("Task ID cannot be longer than 10 characters.");
        }
        return taskID;
    }

    public static String validateTaskName(String taskName) {
        if (taskName == null || taskName.isBlank()) {
            throw new IllegalArgumentException("Task Name is required.");
        }
        taskName = taskName.trim();
        if (taskName.length() > 20) {
            throw new IllegalArgumentException("Task Name cannot be longer than 20 characters.");
        }
        return taskName;
    }

    public static String validateTaskDescription(String taskDescription) {
        if (taskDescription == null || taskDescription.isBlank()) {
            throw new IllegalArgumentException("Task Name is required.");
        }
        taskDescription = taskDescription.trim();
        if (taskDescription.length() > 50) {
            throw new IllegalArgumentException("Task description cannot be longer than 50 characters.");
        }
        return taskDescription;
    }
}
