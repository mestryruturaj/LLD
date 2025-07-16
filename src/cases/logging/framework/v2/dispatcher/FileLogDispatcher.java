package cases.logging.framework.v2.dispatcher;

import java.io.FileWriter;
import java.io.IOException;

public class FileLogDispatcher implements LogDispatcher {
    private final FileWriter fileWriter;
    private final String path;

    public FileLogDispatcher(String path) {
        this.path = path;
        try {
            this.fileWriter = new FileWriter(path);
        } catch (IOException e) {
            System.out.println("CREATION_FAILED");
            throw new RuntimeException(e);
        }
    }


    @Override
    public void dispatch(String message) {
        try {
            this.fileWriter.write(message);
            this.fileWriter.write(System.lineSeparator()); // Optional: line break
            this.fileWriter.flush(); // Ensure it's written to disk
        } catch (IOException e) {
            System.out.println("DISPATCHING_FAILED");
            throw new RuntimeException(e);
        }
    }

    @Override
    public void shutdown() {
        try {
            this.fileWriter.close();
        } catch (IOException e) {
            System.out.println("FAILED_SHUTDOWN: Could not shut Down File Log Dispatcher...");
            throw new RuntimeException(e);
        }
        System.out.println("Shutting Down File Log Dispatcher...");
    }
}
