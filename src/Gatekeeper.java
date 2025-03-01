import java.util.Scanner;

public class Gatekeeper {

    private boolean run = true;

    public void gatekeep(){
        Scanner input = new Scanner(System.in);


        while (run) {
            System.out.println("Please choose a command:\n"
            + "1. Add a patron to the queue.\n"
            + "2. Admit the highest priority patron.\n"
            + "3. Exit.");
            String instruction = input.nextLine();
            if (instruction.equals("1")) {

            } else if (instruction.equals("2")){

            } else if (instruction.equals("3")){
                run = false;
            } else {
                System.out.println("Error: invalid command");
            }
        }
    }

    public static void main(String[] args){
        new Gatekeeper().gatekeep();
    }
}
