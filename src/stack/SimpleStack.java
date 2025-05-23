package stack;

public interface SimpleStack<T> {
    void push(T item);
    T pop();
    T top();
    T peek(); // HINZUFÜGEN
    boolean isEmpty();
}


