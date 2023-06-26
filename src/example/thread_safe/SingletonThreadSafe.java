package example.thread_safe;

public class SingletonThreadSafe {
//     Поле обязательно должно быть объявлено volatile, чтобы двойная проверка блокировки сработала как надо.
    private static volatile SingletonThreadSafe instance;

    public String value;

    private SingletonThreadSafe(String value) {
        this.value = value;
    }

    public static SingletonThreadSafe getInstance(String value) {
//         Техника здесь называется «блокировка с двойной проверкой» (Double-Checked Locking).
//         Она применяется, чтобы предотвратить создание нескольких объектов-одиночек, если метод будет
//         вызван из нескольких потоков одновременно.
//
//         Хотя переменная `result` вполне оправданно кажется здесь лишней, она
//         помогает избежать подводных камней реализации DCL в Java.
        SingletonThreadSafe result = instance;
        if (result != null) {
            return result;
        }
        synchronized(SingletonThreadSafe.class) {
            if (instance == null) {
                instance = new SingletonThreadSafe(value);
            }
            return instance;
        }
    }
}
