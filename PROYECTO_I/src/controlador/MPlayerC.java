package controlador;

import java.awt.Paint;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
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
    
    private String infoU;
    private String PLS;
    private Nodo_D_C actual = null;
    private Lista_D_C lis = null;
    private Boolean show = false;
    private Boolean S_P = false;
    private Boolean Lp = false;
    private Lista_simple lis_de_lis = new Lista_simple();
    private ObservableList<Lista_D_C> bibliotecas;
    @FXML
    private Button BackB;
    @FXML
    private Button loop;
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
    @FXML
    private Button add_bilioteca;
    @FXML
    private Button remuve_bilioteca;
    @FXML
    private Button opciones;
    @FXML
    private Label nombreL;
    @FXML
    private TextField newBibliotecaT;
    
    
    public void init(String info){
        this.infoU = info;
        this.PLS = (info.split(";"))[4];
    }
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
        bibliotecas = FXCollections.observableArrayList();
        
        this.num_can.setCellValueFactory(new PropertyValueFactory("size"));
        this.Blib_nom.setCellValueFactory(new PropertyValueFactory("ID"));
        this.fecha.setCellValueFactory(new PropertyValueFactory("date"));
    }    
    
    @FXML
    private void loop_B(ActionEvent event){
        
        if(Lp){this.loop.setText("][");//System.out.println("loop off");
        }else{this.loop.setText("[]");//System.out.println("loop on");
        }
        Lp = !Lp;
    }
  
    @FXML
    private void seleccionar(MouseEvent event){
        try{
            this.lis = this.tabla.getSelectionModel().getSelectedItem();
            ActionEvent e = new ActionEvent();
            Stop_Play_B(e);
            String id = this.lis.getID();
            Nodo_simple aux = lis_de_lis.busca_dato(id);
            if(aux==null){
                nombreL.setText("");
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setHeaderText(null);
                a.setTitle("Error");
                a.setContentText("la biblioteca esta vacia");
                a.showAndWait();
            }else{
                this.lis = (Lista_D_C) aux.getData1();
                this.actual = lis.getHead();
                nombreL.setText(this.actual.getId());
            }
        }catch(Exception e){
            nombreL.setText("biblioteca sin\ncanciones :/");
        }
    }
    

    @FXML
    private void Last_song_B(ActionEvent event){
        if(this.lis!=null){
            if(Lp){
                this.actual = this.actual.getPrevious();
                nombreL.setText(this.actual.getId());
            }else{
                if(this.actual.getPrevious()==this.lis.getLast()){
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setHeaderText(null);
                    a.setTitle("Error");
                    a.setContentText("El modo reproduccion continua no esta activado");
                    a.showAndWait();
                }else{this.actual = this.actual.getPrevious();
                    nombreL.setText(this.actual.getId());
                }
            }
        }else{
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText(null);
            a.setTitle("Error");
            a.setContentText("No hay biblioteca seleccionada");
            a.showAndWait();
        }
    }

    @FXML
    private void Stop_Play_B(ActionEvent event){
        if (S_P){ST_PY_B.setText("||");//System.out.println("pausa");parar musica
        }else{ST_PY_B.setText(">");//System.out.println("play");//reanudar musica
        }
        S_P = !S_P;
    }

    @FXML
    private void Next_song_B(ActionEvent event){
        if (this.lis!=null){
            if(Lp){
                this.actual = this.actual.getNext();
                nombreL.setText(this.actual.getId());
            }else{
                if(this.actual.getNext()==this.lis.getHead()){
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setHeaderText(null);
                    a.setTitle("Error");
                    a.setContentText("El modo reproduccion continua no esta activado");
                    a.showAndWait();
                }else{this.actual = this.actual.getNext();
                    nombreL.setText(this.actual.getId());
                }
            }
        }else{
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText(null);
            a.setTitle("Error");
            a.setContentText("No hay biblioteca seleccionada");
            a.showAndWait();
        }
    }   

    @FXML
    private void add_b_B(ActionEvent event) {
        LocalDate date = LocalDate.now();
        String d = (date+"").split("-")[1]+"-"+(date+"").split("-")[2];
        String n = newBibliotecaT.getText();
        if(n.isBlank()){n="---";}
        this.infoU =this.infoU + n+"!"+d+":"+"/";
        Lista_D_C l = new Lista_D_C(n,d);
        this.bibliotecas.add(l);
        this.tabla.refresh();
        Archivos write = new Archivos();
        write.sobreEscrive(this.infoU.split(";")[1],this.infoU);
    }

    @FXML
    private void remuve_b_B(ActionEvent event) {
        if(this.lis == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("No hay biblioteca seleccionada");
            alert.showAndWait();
        }else{
            String temp="";
            String id = this.lis.getID();
            String[] pls = PLS.split("/");
            for(int i=0;i<pls.length;++i){
                String ids =pls[i].split("!")[0];
                if(!id.equals(ids)){
                    temp+=pls[i]+"/";}
            }
            this.PLS = temp;
            this.infoU =this.infoU.substring(0,35)+this.PLS;
            Archivos write = new Archivos();
            //System.out.println(this.infoU);
            write.sobreEscrive(this.infoU.split(";")[1],this.infoU);
            this.bibliotecas.remove(this.lis);
            this.tabla.refresh();
            this.lis = null;
        }
    }

    @FXML
    private void opcionesB(ActionEvent event) {
        this.show = !this.show;
        if(this.show){this.opciones.setText("-");
        }else{this.opciones.setText("+");}
        remuve_bilioteca.setVisible(this.show);
        newBibliotecaT.setVisible(this.show);
        add_bilioteca.setVisible(this.show);
        
            


    }
    
        
    public void cargaPLs(String pls){
        String[] temp = pls.split("/");
        for (String temp1 : temp) {
            if(temp1!=null){
                String ID = (temp1.split(":")[0]).split("!")[0];
                String date = (temp1.split(":")[0]).split("!")[1];
                Lista_D_C lista = new Lista_D_C(ID ,date);
                try{
                    String[] cans = (temp1.split(":")[1]).split(",");
                    for (String can : cans) {
                        Nodo_D_C nodo = new Nodo_D_C(can);
                        lista.addNodo_inicio(nodo);
                    }
                }catch(Exception e){}//System.err.println("biblioteca vasia");
                Nodo_simple nodof = new Nodo_simple(ID,lista);
                lis_de_lis.add_nodo(nodof);
                this.bibliotecas.add(lista);
                this.tabla.setItems(bibliotecas);
                
            }
        }    
    }
}
    
