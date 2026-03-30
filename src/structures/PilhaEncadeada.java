package structures;

import model.No;
import model.Pixel;

public class PilhaEncadeada {
    private No top;

    public void push(Pixel pixel){
        No newNode = new No(pixel);
        newNode.setNext(top);
        top = newNode;
    }

    public Pixel pop() {
        if (top == null){
            return null;
        }

        Pixel removed = top.getValue();
        top = top.getNext();
        return removed;
    }

    public boolean isEmpty(){
        return top == null;
    }

}
