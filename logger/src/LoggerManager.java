public class LoggerManager {
    public static AbstractLogger getAbstractLogger(){
        ErrorLogger errorLogger = new ErrorLogger(2);
        InfoLogger infoLogger = new InfoLogger(1);
        DebugLogger debugLogger = new DebugLogger(3);

        infoLogger.setNextLevelLogger(errorLogger);
        errorLogger.setNextLevelLogger(debugLogger);
         return infoLogger;
    }

    public static LogSubject getLogSubject(){
        FileObserver fileObserver = new FileObserver();
        LogSubject logSubject = new LogSubject();
        logSubject.addLogObserver(fileObserver,1);

        return logSubject;
    }
}
