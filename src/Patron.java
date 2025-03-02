public class Patron implements Comparable<Patron> {

    private String name;
    private boolean regular;
    private int coolness;

    public Patron(){}

    public Patron(String name, boolean regular, int coolness) {
        this.name = name;
        this.regular = regular;
        this.coolness = coolness;
    }

    public int compareTo(Patron patron){
        if (this.regular && !patron.regular && this.coolness == patron.coolness){
            return 1;
        } else if (!this.regular && patron.regular && this.coolness == patron.coolness){
            return -1;
        } else {
            return this.coolness - patron.coolness;
        }

    }

    public String getName(){return this.name;}

    public boolean getRegular(){return this.regular;}

    public int getCoolness(){return this.coolness;}

    public void setName(String name){this.name = name;}

    public void setRegular(boolean regular){this.regular = regular;}

    public void setCoolness(int coolness){this.coolness = coolness;}
}
