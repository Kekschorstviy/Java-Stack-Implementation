import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import static java.lang.System.*;

public class MyStack<E> implements Stack{
    private final E[] array;
    private int BottomElement;

    /**
     * Constructor for the stack object. The bottom element of the stack is assigned a value
     * of -1 at the beginning to accurately track the element after adding or deleting
     */
    public MyStack() {
        int max_capacity = 100;
        array = (E[]) new Object[max_capacity];
        BottomElement = -1;
    }
    /**
     * Boolean helper methods to know if the stack is full or empty
     * @return true / false
     */
    public boolean full() {
        return BottomElement == 99;
    }
    public boolean empty(){
        return BottomElement == -1;
    }

    /**
     * Push, Pop, Peek operations
     * <p>
     * Push operation: First of all, the elements must be shifted one position to the right (->) to make room for a new element.
     * To perform such a shift, the for loop was implemented with the initial parameter of the element i = bottom, so as not to shift zero values
     * and therefore increase productivity. After the shift, in accordance with the LIFO principle (the last input is the first output), the element
     * to be pushed should be assigned to an array of positions[0] (top of the stack)
     * <p>
     * Pop operation : At the very beginning, a generic object should be created, it will save an array element that should be removed from the Stack.
     * Next, the position [0] in the array is assigned the null value (pop operation) and after that all the elements, using the for loop, are shifted to
     * the left (<-) in order to fill the space that is being mastered and not violate the basic principle of the stack.At the very end, after performing the
     * operation, the bottom element of the stack is decremented and the method returns the deleted element
     * <p>
     * Peek: Method just returns the top element (array[0]) of the stack without popping it
     */
    public E push(Object item) {
        try {
            if (full()) {
                System.err.println("Stack is full. Cannot push item: " + item);
            }
            for (int i = BottomElement; i >= 0; i--) {
                array[i + 1] = array[i];
            }
            array[0] = (E) item; // Add the new item at the top
            BottomElement++; // Update the top element position
        }catch (Exception e){
            err.println("Something went wrong in push operation");
        }
        return (E) item; // Return the item that was pushed
    }
    public E pop() {
        E poppedItem = array[0]; // Store the item to be popped
           try {
               if(empty()){
                   throw new RuntimeException("Stack is empty");
               }
                // Shift elements left
                for (int i = 0; i < BottomElement; i++) {
               array[i] = array[i + 1];
                }
                array[BottomElement] = null;
                BottomElement--;

           }catch (Exception e ) {}
        return poppedItem;
    }
    public E peek(){
        if(empty()){
            return null;
        }
        return array[0];
    }

    /**
     * Addition methods :
     * 1. Stimulate - method is going to add 100 random numbers. Uses push operation and a for() loop to fill the stack with random numbers
     * <p>
     * 2. Add Single - method is going to add a single value. Method asks user for input object to be pushed on stack. Then it uses push(a).
     */
    public E addSingle() {
        Scanner in = new Scanner(System.in);
        E result = null;
        try {
            out.println("Value: ");
            E a = (E) in.next();
            result = push(a);
        } catch (IllegalStateException e) {
            out.println("Something gone wrong in addSingle");
        }

        return result;
    }
    public  E addStimulate(){
        Random random = new Random();
        E result = null;
        int lim = getSize();
        try {
            if (full() || lim != 0) {
                throw new RuntimeException("Stack is full");
            }
            for (int i = 0; i < array.length; i++) {
                int a = random.nextInt();
                result = push(a); // Cast to T explicitly
            }
        } catch (IllegalStateException e) {
            err.println("Stack is full");
        }
        return result;
    }

    /**
     * Get size method returns the amount of 'not null' values therefore amount of objects pushed/stored on stack.
     * This waaay , in my opinion, is the proper one ,since standard array has been used therefore it's not dynamic
     * and the size is constant after the creation
     * @return size
     */
    public int getSize(){
        int size = 0;
       for (int i = 0; i < array.length; i++){
           if(array[i] != null){
               size++;
           }
       }
       return size;
    }

    public String toString() {
        return "Stack :" + Arrays.toString(array) ;
    }

    }

