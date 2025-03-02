public class Patron implements Comparable<Patron> {

 /**
 * This class creates Patron objects that implement Comparable. Patrons
 * can be compared based on coolness and regularity. Regular Patrons have
 * higher order than non-regular Patrons, however coolness is the primary
 * ordering ranking.
 * @author Nick Tibbels nst2038@gmail.com
 * @author Sam Whitney shw9601@rit.edu
 * */

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
        /**
         * This method is the implementation of Comparable's compareTo method.
         * It prioritizes sorting by coolness and then by regularity.
         * */
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
