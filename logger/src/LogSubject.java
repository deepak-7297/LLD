import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogSubject {
    public Map<Integer, List<LogObserver>> logObserverMapping = new HashMap<>();

    public void addLogObserver(LogObserver observer, int level){
        List<LogObserver> observers = logObserverMapping.getOrDefault(level, new ArrayList<>());
        observers.add(observer);
        logObserverMapping.put(level, observers);
    }

    public void removeObserver(LogObserver observer, int level){
        List<LogObserver> observers = logObserverMapping.getOrDefault(level, new ArrayList<>());
        observers.remove(observer);
    }

    public void notifyAllObserver(int level, String message){
        List<LogObserver> observers = logObserverMapping.getOrDefault(level, new ArrayList<>());
        for(LogObserver observer : observers){
            observer.log(message);
        }
    }
}
