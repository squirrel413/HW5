public interface PriorityQueue<T> {

    T dequeue();

    //int maxChild(int index);

    void enqueue(T toInsert);

    boolean isEmpty();


}
