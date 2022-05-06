import java.io.File;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Window;

public class Controller {
    /*
    @FXML
    private TextField entryField;

    @FXML
    private ListView<String> entryList;

    @FXML
    private Button fileButton;

    @FXML
    private Button nameButton;

    @FXML //Botão limpar
    void clearEntryList(ActionEvent event){
        entryList.getItems().clear();
    }

    @FXML
    void fileEntry(ActionEvent event) {
        String filename = entryField.getText();
        entryField.clear();
        String[] nameList = App.readWords(filename);
        for(int i = 0; i < nameList.length; i++){
            entryList.getItems().add(nameList[i]);
        }
    }

    @FXML
    void nameEntry(ActionEvent event) {
        String name = entryField.getText();
        entryField.clear();
        entryList.getItems().add(name);
    }

    @FXML
    void test(){
        
        System.out.println(entryList.getSelectionModel().getSelectedItem());
    }

    @FXML
    void fileSelector(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        //File file = fileChooser.showOpenDialog(primaryStage);
    }

    @FXML // Roda quando a interface inicializa
    private void initialize() {
        //drawTree(10);
    }

    /*
    public void drawNodeRecursive(int x1,int y1,int x,int y, String value){
        Line line = new Line(x1, y1+5, x, y);
        drawField.getChildren().add(line);
        Circle circle = new Circle(x,y, 15, Paint.valueOf("blue"));
        drawField.getChildren().add(circle);
        Text txt = new Text(x-3,y+3, String.valueOf(value));
        drawField.getChildren().add(txt);
    }

    public void drawTree(int depth){
        double hSize = drawField.getPrefWidth();
        double wSize = drawField.getPrefHeight();

        int nHeight = (depth + 1)*2 - 1;
        int nWidth = (2^depth)*2 - 1;

     
        System.out.println(nHeight);
        System.out.println(nWidth);

        double hGridSize = hSize/nHeight;
        double wGridSize = wSize/nWidth;
        
        System.out.println(hGridSize);
        System.out.println(wGridSize);

        for(int i = 1; i <= nHeight; i++){
            for(int j = 1; j <= nWidth; j++){
                Circle circle = new Circle((j*wGridSize) - (wGridSize/2), (i*hGridSize) - (hGridSize/2), wGridSize/4, Paint.valueOf("blue"));
                drawField.getChildren().add(circle);
            }
        }
    }*/


    ////////////////////////////////////////////////////////////////
    //Vinicius tentando novamente imprimir a arvore
    @FXML
    private Pane drawPane;

    @FXML // Roda quando a interface inicializa
    private void initialize() {
        drawTree(4);
    }

    public void drawTree(int depth){
        double hSize = drawPane.getPrefWidth();
        double wSize = drawPane.getPrefHeight();

        System.out.println(hSize);
        System.out.println(wSize);

        int nHeight = (depth + 1);
        int nWidth = (int) Math.pow(2,depth)*2 - 1;

        double hGridSize = hSize/nHeight;
        double wGridSize = wSize/nWidth;
        
        int count = 0;
        for(int i = nHeight; i >= 1; i--){
            double firstDraw = Math.pow(2,count);
            Circle circle1 = new Circle((firstDraw*wGridSize) - (wGridSize/2), i*2*Math.sqrt((0.75)*(wGridSize*wGridSize)), wGridSize/4, Paint.valueOf("blue"));
            drawPane.getChildren().add(circle1);
            

            for(int j = (int)firstDraw+1; j <= nWidth; j++){
                System.out.println(j + " - " + (j-firstDraw) + " - " + Math.pow(2,count+1));
                if((j-firstDraw)%(Math.pow(2,count+1)) == 0){
                    Circle circle2 = new Circle((j*wGridSize) - (wGridSize/2), i*2*Math.sqrt((0.75)*(wGridSize*wGridSize)), wGridSize/4, Paint.valueOf("blue"));
                    drawPane.getChildren().add(circle2);
                }
            }
            count++;
        }
    }
}
