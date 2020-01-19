public class MyClass<T> implements TestInterface<T>{

    private T value;

    public T get(T value) {
        return value;
    }

    public T set(T value) {
        this.value = value;
        return value;
    }

}
