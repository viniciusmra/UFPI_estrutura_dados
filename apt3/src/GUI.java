import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUI extends Application {
    public Stage primaryStage;
    public Stage dialog = new Stage();

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    // Metodo que abre o arquivo FXML da interface e exibe na tela 
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        // tela principal
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("layout.fxml"));
        Parent root = fxmlLoader.load();
        Scene tela = new Scene(root);

        primaryStage.setTitle("Arvore Binaria - Ellem | Pedro | Vinicius");
        primaryStage.setScene(tela);
        primaryStage.show();
    }
}
