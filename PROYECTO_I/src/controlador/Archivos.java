package controlador;

import java.io.*;
import listas.Lista_D_C;
import listas.Lista_simple;
import listas.Nodo_D_C;
import listas.Nodo_simple;

/**
 *
 * @author Gabriel
 */
public class Archivos {
    
    public void Leer(String direccion, Lista_simple lista){
        try{
            BufferedReader bf = new BufferedReader(new FileReader(direccion));
            String bfRead;
            while((bfRead=bf.readLine())!=null){
                Nodo_simple nodo = new Nodo_simple(bfRead);
                lista.add_nodo(nodo);
                System.out.println(nodo.getData());
            }
        }catch(Exception e){
            System.err.println("error leyendo archivo");
        }   
    }
    
    public void Leer(String direccion, Lista_D_C lista){
        try{
            BufferedReader bf = new BufferedReader(new FileReader(direccion));
            String bfRead;
            while((bfRead=bf.readLine())!=null){
                String id = bfRead.split(";")[0];
                String data = bfRead.split(";")[1];
                Nodo_D_C nodo = new Nodo_D_C(id, data);
                lista.addNodo_inicio(nodo);
            }
        }catch(Exception e){
            System.err.println("error leyendo archivo");
        }   
    }
}
