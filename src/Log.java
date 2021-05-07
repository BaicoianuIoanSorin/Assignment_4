import java.util.ArrayList;

public class Log {
    private ArrayList<String> logs;
    private static Log instance;

    public Log()
    {
        logs = new ArrayList<>();
    }

    public void addLog(String log)
    {
        logs.add(log);
        System.out.println(log);
    }

    public static Log getInstance() {
        if (instance == null) {
            instance = new Log();
        }
        return instance;
    }
}
