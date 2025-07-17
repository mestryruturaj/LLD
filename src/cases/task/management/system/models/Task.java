package cases.task.management.system.models;

import cases.task.management.system.enums.TaskState;

public class Task {
    private static int counter = 0;
    private int id;
    private String title;
    private String description;
    private TaskState taskState;
    private User author;

}
