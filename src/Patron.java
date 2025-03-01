public class Patron implements Comparable<Patron> {

    private String name;
    private boolean regular;
    private int coolness;

    public Patron(String name, boolean regular, int coolness) {
        this.name = name;
        this.regular = regular;
        this.coolness = coolness;
    }

    public int compareTo(Patron patron){
        return this.coolness - patron.coolness;
    }

    private String getName(){return this.name;}

    private boolean getRegular(){return this.regular;}

    private int getCoolness(){return this.coolness;}

    private void setRegular(boolean regular){this.regular = regular;}

    private void setCoolness(int coolness){this.coolness = coolness;}

}
