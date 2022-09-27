package controlador;

import java.io.*;
import javafx.scene.control.Alert;
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
                System.out.println(nodo.getData()+"[info]");
            }
        }catch(Exception e){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText(null);
            a.setTitle("Error");
            a.setContentText("Error leyendo el archivo");
            a.showAndWait();
        }   
    }
    
    public void Leer(String direccion, Lista_D_C lista){
        try{
            BufferedReader bf = new BufferedReader(new FileReader(direccion));
            String bfRead;
            while((bfRead=bf.readLine())!=null){
                Nodo_D_C nodo = new Nodo_D_C(bfRead);
                lista.addNodo_inicio(nodo);
                //System.out.println(nodo.getData());
            }
        }catch(Exception e){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText(null);
            a.setTitle("Error");
            a.setContentText("Error leyendo el archivo");
            a.showAndWait();
        } 
    }
    public void sobreEscrive(String id, String data){
        Lista_simple lis = new Lista_simple();
        String d = "C:\\Users\\Gabriel\\Desktop\\INTENTO_III\\PROYECTO_I\\src\\auxiliar\\credenciales.txt";
        Leer(d,lis);
        Nodo_simple actual = lis.getHead();
        String temp="";
        while(actual!=null){
            System.out.println(id+"[1-1]");
            System.out.println((actual.getData()).split(";")[1]+"[1-2");
            if(id.equals((actual.getData()).split(";")[1])){
                System.out.println(actual.getData()+"  [2-1]");
                actual.setData(data);
                System.out.println(actual.getData()+"  [2-2]");
            }
            temp=actual.getData()+"\r\n"+temp;
            System.out.println(actual.getData()+"  [3]");
            actual=actual.getNext();
        }
        try(FileWriter FI_WR = new FileWriter(d)){
            System.out.println(temp+" [4]");
            FI_WR.write(temp);
        }catch(Exception e){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText(null);
            a.setTitle("Error");
            a.setContentText("Error ecribiendo el archivo");
            a.showAndWait();
        } 
    }
    
}
