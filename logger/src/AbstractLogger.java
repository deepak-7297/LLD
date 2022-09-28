public abstract class AbstractLogger {
    int level;
    public AbstractLogger abstractLogger;

    public void setNextLevelLogger(AbstractLogger abstractLogger){
        this.abstractLogger = abstractLogger;
    }


    public void logMessage(int lvl, String message){
        if(this.level == lvl)
            this.displayMessage(message);

        if (abstractLogger != null)
            abstractLogger.logMessage(lvl, message);
    }

    protected abstract void displayMessage(String message);
}
