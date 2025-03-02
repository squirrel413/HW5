import org.junit.Before;
import org.junit.Test;

import java.util.Queue;

public class TestLinkedQueue {

    private LinkedQueue<Patron> queue1;
    private Patron patron1 = new Patron("Suzie", true, 5);
    private Patron patron2 = new Patron("Tommy", false, 8);
    private Patron patron3 = new Patron("Jane", false, 5);

    @Before
    public void init(){
        queue1 = new LinkedQueue<Patron>();
    }

    @Test
    public void testEnqueue() {
        queue1.enqueue(patron1);
        queue1.enqueue(patron2);
        queue1.enqueue(patron3);
        assert(queue1.front.getData().equals(patron2));
        assert(queue1.front.getLink().getData().equals(patron1));
        assert(queue1.front.getLink().getLink().getData().equals(patron3));
    }

    @Test
    public void testDequeue() {
        queue1.enqueue(patron1);
        queue1.enqueue(patron2);
        queue1.enqueue(patron3);
        assert(queue1.dequeue().equals(patron2));
        assert(queue1.dequeue().equals(patron1));
        assert(queue1.dequeue().equals(patron3));
        assert(queue1.dequeue() == null);
    }

    @Test
    public void testIsEmpty() {
        assert(queue1.isEmpty());
    }
}
