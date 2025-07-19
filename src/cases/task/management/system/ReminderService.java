package cases.task.management.system;

import cases.task.management.system.enums.TaskState;
import cases.task.management.system.models.Task;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ReminderService {
    private ScheduledExecutorService scheduler;
    private Map<Integer, ScheduledFuture<?>> scheduledFutureMap;

    public ReminderService() {
        this.scheduler = Executors.newSingleThreadScheduledExecutor();
        this.scheduledFutureMap = new HashMap<>();
    }

    public void remind(Task task) {
        cancelReminder(task);

        if (task.getTaskState() == TaskState.COMPLETED) {
            return;
        }

        ScheduledFuture<?> scheduledFuture = scheduler.schedule(
                () -> {
                    synchronized (task) {
                        if (task.getTaskState() == TaskState.COMPLETED) {
                            return;
                        }

                        printReminder(task);
                        remind(task);
                    }
                }, 2, TimeUnit.SECONDS);
        scheduledFutureMap.put(task.getId(), scheduledFuture);
    }

    private void printReminder(Task task) {
        System.out.printf("Reminder!!! Task %s is not yet COMPLETED, Let's figure out a way to get it done.%n", task.getTitle());
    }

    private void cancelReminder(Task task) {
        ScheduledFuture<?> scheduledFuture = scheduledFutureMap.remove(task.getId());
        if (scheduledFuture == null) {
            return;
        }

        System.out.printf("Attempting to cancel existing reminder for task %s.%n", task.getTitle());
        scheduledFuture.cancel(false);
        scheduledFutureMap.remove(task.getId());
    }

    public void shutdown() {
        scheduler.shutdown();
    }
}
