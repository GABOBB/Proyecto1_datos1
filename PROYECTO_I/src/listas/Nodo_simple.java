package listas;

/**
 *
 * @author Gabriel
 */
public class Nodo_simple {
   private String data;
   private Object data1;
   private Nodo_simple next;

    public Nodo_simple(String data) {
        this.data = data;
        this.next = null;
    }
    public Nodo_simple(String data,Object data1){
        this.data = data;
        this.data1 = data1;
        this.next=null;
    }

    public Object getData1(){
        return data1;
    }
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Nodo_simple getNext() {
        return next;
    }

    public void setNext(Nodo_simple next) {
        this.next = next;
    } 
}
