package cases.task.management.system.models;

import java.util.HashMap;
import java.util.Map;

public class User {
    private static int count = 0;
    private int id;
    private String userName;
    private Map<Integer, Task> taskMap;

    //service
    public User(String userName) {
        this.id = count++;
        this.userName = userName;
        this.taskMap = new HashMap<>();
    }

    public User(String userName, Map<Integer, Task> taskMap) {
        this.id = count++;
        this.userName = userName;
        this.taskMap = taskMap;
    }

    public Task removeTask(int taskId) {
        return taskMap.remove(taskId);
    }

    public Task addTask(Task task) {
        return taskMap.put(task.getId(), task);
    }

    //getter and setter
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Map<Integer, Task> getTaskMap() {
        return taskMap;
    }

    public void setTaskMap(Map<Integer, Task> taskMap) {
        this.taskMap = taskMap;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName +
                "}";
    }
}
