package cases.traffic.signal.system.utils;

import java.util.concurrent.TimeUnit;

public class TimePrinter extends Thread {
    @Override
    public void run() {
        int timeElapsed = 0;
        while (true) {
            System.out.printf("T: %d%n", timeElapsed);
            timeElapsed++;
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
