public class Logger {
    public static Logger logger;
    public static AbstractLogger abstractLogger;
    public static LogSubject logSubject;

    private Logger() throws Exception {
        if(logger!=null)
            throw new Exception("Object already create");
    }

    public Logger getLogger() throws Exception{
        if(logger == null){
            synchronized (Logger.class){
                logger = new Logger();
                abstractLogger = LoggerManager.getAbstractLogger();
                logSubject = LoggerManager.getLogSubject();
            }
        }
        return logger;
    }

    public void infoLogger(String message){
        addLog(message, 1);
    }

    public void debugLogger(String message){
        addLog(message, 3);
    }

    public void errorLogger(String message){
        addLog(message, 2);
    }

    private void addLog(String message, int level){
        abstractLogger.logMessage(level, message);
    }
}
