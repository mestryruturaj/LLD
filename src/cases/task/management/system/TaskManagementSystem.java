package cases.task.management.system;

import cases.task.management.system.enums.TaskState;
import cases.task.management.system.exception.TaskManagementSystemException;
import cases.task.management.system.models.Task;
import cases.task.management.system.models.User;

import java.util.Map;

public class TaskManagementSystem {
    private Map<Integer, Task> taskMap;
    private Map<Integer, User> taskToUserMap;
    //services
    public Task createTask(String title, String description, User user) {
        return new Task(title, description, TaskState.TODO, user);
    }

    public Task updateTask(int taskId, Task updatedTask) {
        taskMap.put(taskId, updatedTask);
        return updatedTask;
    }

    public Task removeTask(int taskId) {
        if (!taskMap.containsKey(taskId)) {
            throw new TaskManagementSystemException(String.format("TASK_DOES_NOT_EXIST: Task with id %d does not exist.", taskId));
        }

        return taskMap.get(taskId);
    }

    public Task getTask(int taskId) {
        if (!taskMap.containsKey(taskId)) {
            throw new TaskManagementSystemException(String.format("TASK_DOES_NOT_EXIST: Task with id %d does not exist.", taskId));
        }

        return taskMap.get(taskId);
    }

    public void updateTaskUser(Task task, User user) {
        taskToUserMap.put(task.getId(), user);
        task.setAuthor(user);
    }
}
