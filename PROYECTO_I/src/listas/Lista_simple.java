package listas;

/**
 *esta clase manea la logica relacionada con las listas enlazadas simples
 * @author Gabriel
 */
public class Lista_simple {
    Nodo_simple head;//el apuntador al primer elemento de la lista
    int size;

    public Lista_simple(){
        this.head = null;
        this.size = 0;
    }

    public Nodo_simple getHead() {
        return head;
    }

    public void setHead(Nodo_simple head) {
        this.head = head;
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
        while(actual!=null){
            if(actual.getData().equals(data)){
                return actual;
            }else{
                actual=actual.getNext();
            }
        }
        return null;
    }

    public Nodo_simple busca_objeto(Object nodo){
        Nodo_simple aux = this.head;
        while(aux.getNext()!=null){
            if(aux==nodo){
                return aux;
            }else{
            aux = aux.getNext();
            }
        }
        return null;
    }
    
    
}
