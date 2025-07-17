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
}
