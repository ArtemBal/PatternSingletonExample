package example.one_thread;

public class SingletonSingleThread {
    private static SingletonSingleThread instance;
    public String value;

    private SingletonSingleThread(String value) {
        // Медленная инициализация.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.value = value;
    }

    public static SingletonSingleThread getInstance(String value) {
        if (instance == null) {
            instance = new SingletonSingleThread(value);
        }
        return instance;
    }

}
