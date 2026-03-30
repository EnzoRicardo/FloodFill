package model;

public class No {
    private Pixel value;
    private No next;

    public No(Pixel value){
        this.value = value;
        this.next = null;
    }

    public Pixel getValue(){
        return value;
    }

    public No getNext() {
        return next;
    }

    public void setNext(No next){
        this.next = next;
    }
}
