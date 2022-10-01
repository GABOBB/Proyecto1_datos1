package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import listas.Lista_simple;
import listas.Nodo_simple;

/**
 * FXML Controller class
 *  se encarga de la logica detras de la ventana de inicio
 * @author Gabriel
 */
public class InSeC implements Initializable {
    private Stage stagei;
    
    private Lista_simple lusuarios = new Lista_simple();
    @FXML
    private TextField User;
    @FXML
    private PasswordField PW;
    @FXML
    private Button ButtonIn;
    @FXML
    private Label label_mesage;
    @FXML
    private AnchorPane ventana;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Archivos usuarios = new Archivos();
        String dire = "C:\\Users\\Gabriel\\Desktop\\INTENTO_III\\PROYECTO_I\\src\\auxiliar\\credenciales.txt";
        usuarios.Leer(dire, lusuarios);
        
    }    

    @FXML
    private void TryIn(ActionEvent event) {
        String user = User.getText();
        String pw = PW.getText();
        
        if((!user.isBlank())&&(!pw.isBlank())){
            Nodo_simple actual =lusuarios.getHead();
            while(actual!=null){
                
                String temp = actual.getData();
                String u = temp.split(";")[1];
                String p = temp.split(";")[3];
                if(user.equals(u) && pw.equals(p)){
                    String PLs = temp.split(";")[4];
                    try{
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/MPlayer.fxml"));
                        Parent root = loader.load();
                        MPlayerC controlador =loader.getController();
                        Scene scene = new Scene(root);
                        Stage stage = new Stage();
                        stage.setScene(scene);
                        controlador.init(temp);
                        controlador.cargaPLs(PLs);
                        stage.show();
                        this.stagei.close();
                    }catch(IOException e){
                        Alert a = new Alert(Alert.AlertType.ERROR);
                        a.setHeaderText(null);
                        a.setTitle("Error");
                        a.setContentText("la biblioteca esta vacia");
                        a.showAndWait();
                    }
                }
                actual = actual.getNext();
            }
            label_mesage.setText("incorrecto :/");
            
        }else{label_mesage.setText("falta data");}
    }

    void setStage(Stage primaryStage){
        stagei = primaryStage;
    }
    
}
