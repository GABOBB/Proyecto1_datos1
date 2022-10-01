package listas;

/**
 * esta clase es responsable de manejar los datos relacionados 
 * con cada nodo de una lista doblemente enlazada circular (D_C)
 * @author Gabriel
 */
public class Nodo_D_C {
    private String id;
    private String data;
    private Nodo_D_C next;
    private Nodo_D_C previous;
    
    public Nodo_D_C(String id, String data){
        this.id = id;//identificador de cada nodo
        this.data = data;//un arreglo que contiene informacion de cada nodo
        this.previous = null;//referencia a la posicion anterios al nodo 
        this.next = null;//referencia a la posicion siguiente al nodo
    }
    public Nodo_D_C(String id){
        this.id = id;
        this.next = null;
        this.previous = null;
    }
    public String getId(){return this.id;}
    public void setId(String id){this.id = id;}
    
    public String getData(){return this.data;}
    public void setData(String data){this.data = data;}
    
    public Nodo_D_C getNext(){return this.next;}
    public void setNext(Nodo_D_C nodo){this.next = nodo;}
    
    public Nodo_D_C getPrevious(){return this.previous;}
    public void setPrevious(Nodo_D_C nodo){this.previous = nodo;}
}
