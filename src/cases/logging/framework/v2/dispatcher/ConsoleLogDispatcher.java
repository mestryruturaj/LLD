package cases.logging.framework.v2.dispatcher;

public class ConsoleLogDispatcher implements LogDispatcher {

    @Override
    public void dispatch(String message) {
        System.out.println(message);
    }

    @Override
    public void shutdown() {
        System.out.println("Shutting Down Console Log Dispatcher...");
    }
}
