package listas;

/**
 *
 * @author Gabriel
 */
public class Lista_simple {
    Nodo_simple head;
    Nodo_simple next;
    int size;

    public Lista_simple(){
        this.head = null;
        this.next = null;
        this.size = 0;
    }

    public Nodo_simple getHead() {
        return head;
    }

    public void setHead(Nodo_simple head) {
        this.head = head;
    }

    public Nodo_simple getNext() {
        return next;
    }

    public void setNext(Nodo_simple next) {
        this.next = next;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    public void add_nodo(Nodo_simple nodo){
        if(this.head==null){
            this.head = nodo;
        }else{
            nodo.setNext(this.head);
            this.head=nodo;
        }
        this.size++;
    }
    
    public Nodo_simple busca_dato(String data){
        Nodo_simple actual = this.head;
        while(actual.getNext()!=null){
            if(actual.getData().equals(data)){
                return actual;
            }
        }
        return null;
    }
    
    
}
