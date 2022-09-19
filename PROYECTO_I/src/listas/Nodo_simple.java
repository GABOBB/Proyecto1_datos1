/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
    public Nodo_simple(Object data){
    this.data1 = data;
    this.next=null;
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
