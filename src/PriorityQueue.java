public interface PriorityQueue<T> {
/**
 * This interface class allows standardization for methods required for
 * any queues with some hierarchical order on them.
 * @author Nick Tibbels nst2038@gmail.com
 * @author Sam Whitney shw9601@rit.edu
 * */

    T dequeue();

    void enqueue(T toInsert);

    boolean isEmpty();


}
