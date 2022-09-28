public class DatabaseObserver implements LogObserver{

    @Override
    public void log(String message) {
        System.out.println("Writing to Database" + message);
    }
}
