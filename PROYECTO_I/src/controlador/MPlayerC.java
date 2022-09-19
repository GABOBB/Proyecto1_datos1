package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import listas.Lista_D_C;
import listas.Lista_simple;
import listas.Nodo_D_C;
import listas.Nodo_simple;

/**
 * FXML Controller class
 *
 * @author Gabriel
 */
public class MPlayerC implements Initializable {
    
    private String PLs;
    private Boolean S_P = false;
    private Boolean Lp = false;
    private Lista_simple lis_de_lis = new Lista_simple();
    
    
    
    @FXML
    private Button BackB;
    @FXML
    private Button loop;
    @FXML
    private Slider volumen;
    @FXML
    private Button ST_PY_B;
    @FXML
    private Button NextB;
    @FXML
    private TableColumn Blib_nom;
    @FXML
    private TableColumn num_can;
    @FXML
    private TableColumn fecha;
    @FXML
    private TableView<Lista_D_C> tabla;
    
    private ObservableList<Lista_D_C> bibliotecas;
    
    public void init(String PLs){
        this.PLs = PLs;
    }
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bibliotecas = FXCollections.observableArrayList();
        
        this.Blib_nom.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.num_can.setCellValueFactory(new PropertyValueFactory("size"));
        this.fecha.setCellValueFactory(new PropertyValueFactory("fecha"));
    }    

    @FXML
    private void Last_song(ActionEvent event) {
        System.out.println("cancion anterior");
    }

    @FXML
    private void Stop_Play(ActionEvent event) {
        if (S_P){
            System.out.println("pausa");
        //parar musica
        }else{
            System.out.println("play");
        //reanudar musica
        }
        S_P = !S_P;
        
    }

    @FXML
    private void Next_song(ActionEvent event) {
        System.out.println("siguiente cancion");
        
    }

    @FXML
    private void loop_B(ActionEvent event) {
        if (Lp){
        System.out.println("loop on");
        
        }else{
        System.out.println("loop off");
        }
        Lp = !Lp;
    }
    
    public void cargaPLs(String pls){
        String[] temp = pls.split("/");
        for(int i=0;i<temp.length;i++){
            String id = (temp[i].split(":")[0]).split("!")[0];
            String f = (temp[i].split(":")[0]).split("!")[1];
            Lista_D_C lista = new Lista_D_C(id,f);
            String[] cans = (temp[i].split(":")[1]).split(",");
            for (String can : cans) {
                Nodo_D_C nodo = new Nodo_D_C(can);
                lista.addNodo_inicio(nodo);
            }
            i++;
            try{
                this.bibliotecas.add(lista);
                this.tabla.setItems(bibliotecas);
            }catch(Exception e){System.err.println("error cargando");}
        }
    }   
}
