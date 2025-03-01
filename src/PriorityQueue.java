public interface PriorityQueue<T> {

    T dequeue();

    void enqueue(T toInsert);

    boolean isEmpty();


}
