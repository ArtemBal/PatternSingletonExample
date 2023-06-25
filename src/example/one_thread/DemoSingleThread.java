package example.one_thread;

public class DemoSingleThread {
    public static void main(String[] args) {
        System.out.println("""
                If you see the same value, then singleton was reused (yay!)
                If you see different values, then 2 singletons were created (booo!!)

                RESULT:
                """);
        SingletonSingleThread singleton = SingletonSingleThread.getInstance("FOO");
        SingletonSingleThread anotherSingleton = SingletonSingleThread.getInstance("BAR");
        System.out.println(singleton.value);
        System.out.println(anotherSingleton.value);
    }
}
