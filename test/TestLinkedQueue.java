import org.junit.Test;

public class TestLinkedQueue {

    private LinkedQueue queue1 = new LinkedQueue<Patron>();

    @Test
    public void testEnqueue() {
        Patron patron1 = new Patron("Suzie", true, 5);
        Patron patron2 = new Patron("Tommy", false, 8);
        Patron patron3 = new Patron("Jane", false, 5);
        queue1.enqueue(patron1);
        queue1.enqueue(patron2);
        queue1.enqueue(patron3);
        assert(patron1.getNextPatron().equals(patron3));
        assert(patron2.getNextPatron().equals(patron1));
        assert(patron3.getNextPatron() == (null));
    }

    @Test
    public void testDequeue() {
        Patron patron1 = new Patron("Suzie", true, 5);
        Patron patron2 = new Patron("Tommy", false, 8);
        Patron patron3 = new Patron("Jane", false, 5);
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
