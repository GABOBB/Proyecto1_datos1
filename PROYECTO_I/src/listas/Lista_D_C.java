package listas;
/**
 *esta clase tiene como proposito el manejo de una lista
 * doblemente enlazada circular.
 * @author Gabriel
 */
public class Lista_D_C {
    private Nodo_D_C head;
    private Nodo_D_C last;
    private String ID;
    private String date;
    private int size;

    public Lista_D_C(String ID,String date){//inicializa la lista
        this.ID = ID;
        this.date = date;
        this.last = null;
        this.head = null;
        this.size = 0;
    }
    public Nodo_D_C getLast(){return this.last;}
    public Nodo_D_C getHead(){return this.head;}
    public int getSize(){return this.size;}
    public String getID(){return this.ID;}
    public String getDate(){return this.date;}
    
    public void addNodo_inicio(Nodo_D_C nodo){
        if (this.head==null){//si el 'head' es nulo la lista es vacia
            nodo.setNext(nodo);
            nodo.setPrevious(nodo);
            this.head=nodo;
            this.last=nodo;
        }else{
            nodo.setNext(this.head);
            nodo.setPrevious(this.last);
            this.head.setPrevious(nodo);
            this.head = nodo;
            this.last.setNext(this.head);
        }
        this.size++;
    } 
    
    public Nodo_D_C encuentra_id(String id){
        Nodo_D_C actual = this.head;
        while(actual!=null){
            if(actual.getId().equals(id)){
                return actual;
            }
            actual = actual.getNext();
        }
        return null;
    }
   
    
}
