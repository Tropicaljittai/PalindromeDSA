public class ListStack<T> implements Iterable<T>, Stack<T> {

    private java.util.LinkedList<T> stack = new java.util.LinkedList<T>();

    public ListStack() {}

    public ListStack(T firstElem) {
        push(firstElem);
    }

    public int size() {
        return stack.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void push(T elem) {
        stack.addLast(elem);
    }

    public T pop() {
        if (isEmpty()) throw new java.util.EmptyStackException();
        return stack.removeLast();
    }

    public T peek() {
        if (isEmpty()) throw new java.util.EmptyStackException();
        return stack.peekLast();
    }

    public int search(T elem) {
        return stack.lastIndexOf(elem);
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return stack.iterator();
    }

    public String toString() {
        return stack.toString();
    }
}