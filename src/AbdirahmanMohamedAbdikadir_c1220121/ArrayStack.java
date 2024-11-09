package AbdirahmanMohamedAbdikadir_c1220121;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack <T> {

    int top;
    private final static int DEFAULT_CAPACITY = 3;
    private T[] stack;

    ArrayStack(int initialCapacity) {
        top = 0;
        stack = (T[]) (new Object[initialCapacity]);
    }

    ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    public int size() {
        return top;
    }

    public T pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        top--;
        T result = stack[top];
        stack[top] = null;
        return result;
    }

    public T peek() {
        return stack[top];
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public void push(T element) {
        if (isFull()) {
            stack = Arrays.copyOf(stack, stack.length * 2); // expanding Capacity
        }
        stack[top] = element;
        top++;
    }

    public boolean isFull() {
        return stack.length == top;
    }

    public void display() {
        for (int i = top - 1; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }

    public int getLength() {
        return stack.length;
    }

    public T getElementByIndex(int i) {
        return stack[i];
    }

    private boolean isDuplicated(ArrayStack array, T element) {
        if (array.size() == 0) {
            return false;
        }
        for (int i = 0; i < array.size(); i++) {
            if (array.getElementByIndex(i) == element) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "ArrayStack{" +
                "top=" + top +
                ", stack=" + Arrays.toString(stack) +
                '}';
    }

    public void merge(ArrayStack<T> s1, ArrayStack<T> s2) {
        int newSize = s1.size() + s2.size();


        if (stack.length < newSize) {
            stack = Arrays.copyOf(stack, newSize);
        }

        for (int i = 0; i < s1.size(); i++) {
            boolean duplicated;
            duplicated = isDuplicated(this, s1.getElementByIndex(i));
            if (!duplicated)
                this.push(s1.stack[i]);
        }

        for (int i = 0; i < s2.size(); i++) {
            boolean duplicated;
            duplicated = isDuplicated(this, s2.getElementByIndex(i));
            if (!duplicated)
                this.push(s2.stack[i]);
        }
    }

    public static void main(String[] args) {
        ArrayStack<Integer> s1 = new ArrayStack<>(4);
        ArrayStack<Integer> s2 = new ArrayStack<>(4);
        ArrayStack<Integer> s3 = new ArrayStack<>(4);


        s1.push(20);
        s1.push(30);
        s1.push(57);


        s2.push(30);
        s2.push(20);
        s2.push(20);
        s1.push(45);


        System.out.println(s3);
        s3.merge(s1, s2);
        s3.display();
    }


}
