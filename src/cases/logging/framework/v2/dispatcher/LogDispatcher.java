package cases.logging.framework.v2.dispatcher;

public interface LogDispatcher {
    public void dispatch(String message);
    public void shutdown();
}

