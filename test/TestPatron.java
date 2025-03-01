import org.junit.Test;

public class TestPatron {

    @Test
    public void testPatron() {
        Patron patron1 = new Patron("Tessa Pate Ron", true, 8);
        Patron patron2 = new Patron("Joe Schmo", false, 1);
        assert(patron1.getName().equals("Tessa Pate Ron"));
        assert(patron1.getRegular());
        assert(!patron2.getRegular());
        assert(patron1.getCoolness() == 8);
        assert(patron1.compareTo(patron2) > 0);
    }

}
