package cases.task.management.system;

import cases.task.management.system.enums.TaskState;
import cases.task.management.system.models.Task;
import cases.task.management.system.models.User;

import java.util.concurrent.TimeUnit;

public class Client {
    public static void main(String[] args) {
        TaskManagementSystem taskManagementSystem = new TaskManagementSystem();

        //users
        User u1 = new User("Ruturaj");
        User u2 = new User("TestUser");

        //tasks
        Task t1 = taskManagementSystem.createTask("Task 1", "This task defines whether Task Management System works well.", u1);
        Task t2 = taskManagementSystem.createTask("Task 2", "I guess it's working.", u2);
        Task t3 = taskManagementSystem.createTask("Task 3", "Is it still working?", u2);
        Task t4 = taskManagementSystem.createTask("Task 4", "Looks like we made it.", u2);

        taskManagementSystem.updateTaskWithAuthor(t3.getId(), u1);
        taskManagementSystem.updateTaskWithDescription(t3.getId(), "I updated it.");
        taskManagementSystem.updateTaskWithTaskState(t3.getId(), TaskState.IN_PROGRESS);

        try {
            TimeUnit.SECONDS.sleep(3);
            taskManagementSystem.updateTaskWithTaskState(t1.getId(), TaskState.IN_PROGRESS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            TimeUnit.SECONDS.sleep(3);
            taskManagementSystem.updateTaskWithTaskState(t2.getId(), TaskState.IN_PROGRESS);
            taskManagementSystem.updateTaskWithTaskState(t1.getId(), TaskState.COMPLETED);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            TimeUnit.SECONDS.sleep(3);
            taskManagementSystem.updateTaskWithTaskState(t4.getId(), TaskState.IN_PROGRESS);
            taskManagementSystem.updateTaskWithTaskState(t3.getId(), TaskState.COMPLETED);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            TimeUnit.SECONDS.sleep(3);
            taskManagementSystem.updateTaskWithTaskState(t2.getId(), TaskState.COMPLETED);
            taskManagementSystem.updateTaskWithTaskState(t4.getId(), TaskState.COMPLETED);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        taskManagementSystem.shutdown();

    }
}
