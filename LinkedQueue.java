public class LinkedQueue<T> implements Iterable<T>, Queue<T> {

    private java.util.LinkedList<T> queue = new java.util.LinkedList<T>();

    public LinkedQueue() {}

    public LinkedQueue(T firstElem) {
        offer(firstElem);
    }

    // Return the size of the queue
    public int size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T peek() {
        if (isEmpty()) throw new RuntimeException("Queue Empty");
        return queue.peekFirst();
    }

    public T poll() {
        if (isEmpty()) throw new RuntimeException("Queue Empty");
        return queue.removeFirst();
    }

    public Character offer(T elem) {
        queue.addLast(elem);
        return (Character) elem;
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return queue.iterator();
    }
}