package controlador;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import listas.Lista_simple;
import controlador.Archivos;

/**
 *
 * @author Gabriel
 */
public class FXMain extends Application {

    
    @Override
    public void start(Stage primaryStage) {
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(FXMain.class.getResource("/vista/InSe.fxml"));
            Pane ventana = (Pane) loader.load();
            Scene scene = new Scene(ventana);
            primaryStage.setScene(scene);
            InSeC controlador = loader.getController();
            controlador.setStage(primaryStage);
            primaryStage.show();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {launch(args);}
}
