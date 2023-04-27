public interface Queue<T> {
    public Character offer(T elem);

    public T poll();

    public T peek();

    public int size();

    public boolean isEmpty();
}