
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GUI extends Application {
    public static void main(String[] args) {
        //String[] argumentos = {java --module-path C:/openjfx-18.0.1_windows-x64_bin-sdk/javafx-sdk-18.0.1/lib --add-modules javafx.controls,javafx.fxml -jar apt3.jar
        launch(args);
    }


    @Override
    // Método que abre o arquivo FXML da interface e exibe na tela 
    public void start(Stage primaryStage) throws Exception {
        //FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("layout.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("treetest.fxml"));
        Parent root = fxmlLoader.load();
        Scene tela = new Scene(root);

        primaryStage.setTitle("Arvore Binaria - Ellem | Pedro | Vinicius");
        primaryStage.setScene(tela);
        primaryStage.show();

    }
}
