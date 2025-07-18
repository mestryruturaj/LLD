package cases.task.management.system.models;

import cases.task.management.system.exception.TaskManagementSystemException;

import java.util.Map;

public class User {
    private static int count = 0;
    private int id;
    private String userName;
    private Map<Integer, Task> taskMap;

    //service
    public User(String userName, Map<Integer, Task> taskMap) {
        this.id = count++;
        this.userName = userName;
        this.taskMap = taskMap;
    }

    public Task removeTask(int taskId) {
        if (!taskMap.containsKey(taskId)) {
            throw new TaskManagementSystemException(String.format("TASK_DOES_NOT_EXIST: Task with id %d does not exist.", taskId));
        }

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
}
