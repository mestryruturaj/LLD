package cases.task.management.system.models;

import cases.task.management.system.enums.TaskState;

import java.sql.Timestamp;

public class TaskLog {
    private static int counter = 0;
    private int id;
    private Task task;
    private TaskState taskState;
    private User user;
    private Timestamp timestamp;

    public TaskLog(Task task, TaskState taskState, User user, Timestamp timestamp) {
        this.id = counter++;
        this.task = task;
        this.taskState = taskState;
        this.user = user;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public TaskState getTaskState() {
        return taskState;
    }

    public void setTaskState(TaskState taskState) {
        this.taskState = taskState;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "TaskLog{" +
                "\nid=" + id +
                "\ntask=" + task +
                "\ntaskState=" + taskState +
                "\ntimestamp=" + timestamp +
                "\n}";
    }
}
