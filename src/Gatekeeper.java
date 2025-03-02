import java.util.Scanner;
/**
 * This class handles creating a queue, either heap or linked variations
 * and allows the user to add Patrons to the queue based on coolness and
 * regularity.
 * @author Nicholas Tibbels nst2038@rit.edu
 * @author Samuel Whitney shw9601@rit.edu
 * */
public class Gatekeeper {
    /**
     * This method is called by main to run the loop of adding patrons
     * to a queue after user input. Supports a HeapQueue class and a
     * LinkedQueue class as underlying data structure for the queue.
     * */

    private boolean run = true;
    private PriorityQueue<Patron> queue;

    public void gatekeep(){
        Scanner input = new Scanner(System.in);
        //Allow users to choose heap or linked queue mode
        System.out.println("Please choose queue mode:[heap|linked]");
        String mode = input.nextLine();
        while (!mode.equals("heap") && !mode.equals("linked")) {
            System.out.println("Error:invalid mode");
            mode = input.nextLine();
        }
        if (mode.equals("heap")) {
            this.queue = new HeapQueue<Patron>();
        } else {
            this.queue = new LinkedQueue<Patron>();
        }
        //Main program loop for adding patrons and allowing them in
        while (run) {
            System.out.println("Please choose a command:\n"
            + "1. Add a patron to the queue.\n"
            + "2. Admit the highest priority patron.\n"
            + "3. Exit.");
            String instruction = input.nextLine();
            if (instruction.equals("1")) {
                Patron toAdd = new Patron(); //parameterless constructor
                System.out.print("Patron name:");
                String tempName = input.nextLine();
                toAdd.setName(tempName);
                System.out.print("Coolness (1-10):");
                String tempCoolness = input.nextLine();
                toAdd.setCoolness(Integer.parseInt(tempCoolness));
                System.out.print("Regular (y/n):");
                String tempRegular = input.nextLine();
                if (tempRegular.equals("y")) {
                    toAdd.setRegular(true);
                } else {
                    toAdd.setRegular(false);
                }
                queue.enqueue(toAdd);
            } else if (instruction.equals("2")){
                if (queue.isEmpty()) {
                    System.out.println("Queue is empty.");
                } else {
                    Patron admitted = queue.dequeue();
                    if (admitted.getRegular()) {
                        System.out.println("Regular " + admitted.getName()
                                + " with coolness factor " + admitted.getCoolness() + " gets in!!!");
                    } else {
                        System.out.println(admitted.getName() + " with coolness factor "
                                + admitted.getCoolness() + " gets in!!!");
                    }
                }
            } else if (instruction.equals("3")){
                run = false;
            } else {
                System.out.println("Error: invalid command");
            }
        }
        System.out.println("Thanks for playing!");
    }

    public static void main(String[] args){
        new Gatekeeper().gatekeep();
    }
}
