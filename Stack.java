public interface Stack <E>{
    boolean full();
    boolean empty();
    E push(E item);
    E pop();
    E peek();
    E addSingle();
    E addStimulate();
    int getSize();
}
