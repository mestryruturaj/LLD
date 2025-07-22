package cases.task.management.system;

import cases.task.management.system.enums.TaskState;
import cases.task.management.system.exception.TaskManagementSystemException;
import cases.task.management.system.model.Task;
import cases.task.management.system.model.TaskLog;
import cases.task.management.system.model.User;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskManagementSystem {
    private Map<Integer, Task> taskMap;
    private Map<Integer, User> taskToUserMap;
    private List<TaskLog> taskLogs;
    private ReminderService reminderService;

    //services
    public TaskManagementSystem() {
        this.taskMap = new HashMap<>();
        this.taskToUserMap = new HashMap<>();
        this.taskLogs = new ArrayList<>();
        this.reminderService = new ReminderService();
    }

    public Task createTask(String title, String description, User user) {
        Task task = new Task(title, description, TaskState.TODO, user);
        taskMap.put(task.getId(), task);
        connectTaskAndUser(task, user);
        addLog(task, task.getTaskState(), user);
        reminderService.remind(task);
        return task;
    }

    public Task updateTaskWithTaskState(int taskId, TaskState taskState) {
        Task task = taskMap.get(taskId);
        task.setTaskState(taskState);
        addLog(task, taskState, task.getAuthor());
        return task;
    }

    public Task updateTaskWithAuthor(int taskId, User author) {
        Task task = taskMap.get(taskId);
        User curAuthor = task.getAuthor();
        disconnectTaskAndUser(task, curAuthor);
        connectTaskAndUser(task, author);
        addLog(task, task.getTaskState(), author);
        return task;
    }

    public Task updateTaskWithTitle(int taskId, String title) {
        Task task = taskMap.get(taskId);
        task.setTitle(title);
        addLog(task, task.getTaskState(), task.getAuthor());
        return task;
    }

    public Task updateTaskWithDescription(int taskId, String description) {
        Task task = taskMap.get(taskId);
        task.setDescription(description);
        addLog(task, task.getTaskState(), task.getAuthor());
        return task;
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

    public void shutdown() {
        reminderService.shutdown();
    }

    //helper
    private void connectTaskAndUser(Task task, User user) {
        task.setAuthor(user);
        user.getTaskMap().put(task.getId(), task);
    }

    private void disconnectTaskAndUser(Task task, User user) {
        task.setAuthor(null);
        user.getTaskMap().remove(task.getId());
    }

    private void addLog(Task task, TaskState taskState, User user) {
        TaskLog taskLog = new TaskLog(task, taskState, user, Timestamp.valueOf(LocalDateTime.now()));
        taskLogs.add(taskLog);
        System.out.println(taskLog);
        System.out.println();
    }
}
