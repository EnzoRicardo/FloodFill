package structures;
import model.No;
import model.Pixel;


public class FilaEncadeada {
    private No front;
    private No rear;

    public void enqueue(Pixel pixel){  //enqueue = entrar na fila
        No newNode = new No(pixel);
        if(front == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.setNext(newNode);
            rear = newNode;
        }
    }

    public Pixel dequeue(){  //dequeue = sair da fila
        if (front == null){
            return null;
        }

        Pixel removed = front.getValue();
        front = front.getNext();

        if (front == null){
            rear = null;
        }

        return removed;
    }

    public boolean isEmpty(){
        return front == null;
    }

}
