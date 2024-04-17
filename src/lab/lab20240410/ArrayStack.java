package lab.lab20240410;

import java.util.NoSuchElementException;

public class ArrayStack<E> {
    private E s[];
    private int top;
    public ArrayStack(int n) {
        s = (E[]) new Object[n];
        top = -1;
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public E peek() {
        if (isEmpty())
            throw new NoSuchElementException();
        return s[top];
    }

    public void push(E newItem) {
        if (size() == s.length)
            return;
        s[++top] = newItem;
    }

    public E pop() {
        if (isEmpty())
            throw new NoSuchElementException();
        E item = s[top];
        s[top--] = null;

        return item;
    }
}
