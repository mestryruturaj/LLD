package cases.task.management.system.model;

import cases.task.management.system.enums.TaskState;

public class Task {
    private static int counter = 0;
    private int id;
    private String title;
    private String description;
    private TaskState taskState;
    private User author;

    public Task(String title, String description, TaskState taskState, User author) {
        this.id = counter++;
        this.title = title;
        this.description = description;
        this.taskState = taskState;
        this.author = author;
    }

    public Task(String title, String description, User author) {
        this.id = counter++;
        this.title = title;
        this.description = description;
        this.author = author;
        this.taskState = TaskState.TODO;
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public synchronized TaskState getTaskState() {
        return taskState;
    }

    public synchronized void setTaskState(TaskState taskState) {
        this.taskState = taskState;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }


    @Override
    public String toString() {
        return "\nTask{" +
                "\n\tid=" + id +
                "\n\ttitle='" + title + '\'' +
                "\n\tdescription='" + description + '\'' +
                "\n\ttaskState=" + taskState +
                "\n\tauthor=" + author +
                "\n}";
    }


}
