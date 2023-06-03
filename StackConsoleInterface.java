import java.util.Scanner;

import static java.lang.System.out;

public class StackConsoleInterface {
    public static MyStack <Integer> n = new MyStack <Integer>();
    public static void menu(){
        Scanner in = new Scanner(System.in);
        do {
            out.println(
                    "(1) Insert a value that is read from the console.\n" +
                            "(2) Output size of the stack.\n" +
                            "(3) Output the size and contents of the stack.\n" +
                            "(4) Output and remove the top element.\n" +
                            "(5) Insert 100 random numbers to the stack.\n" +
                            "(6) Exit");
            int choice = in.nextInt();
            switch (choice) {
                case 1:
                    n.addSingle();
                    break;
                case 2:
                    out.println(n.getSize());
                    break;
                case 3:
                    out.println(n.toString() + "\n" + "Size: " + n.getSize());
                    break;
                case 4:
                    out.println(n.peek());
                    n.pop();
                    break;
                case 5:
                    n.addStimulate();
                    break;
                case 6:
                   return;
                default:
                    out.println("Unknown");
            }
        }while (true);
    }
    public static void main(String[] args){
        menu();
    }
}
