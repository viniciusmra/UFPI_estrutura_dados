import java.io.File;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

//classe reponsavel por inserir os elementos e acoes dos componentes da interface
public class Controller {
    GUI gui = new GUI();
    BSTPlus<String, Integer> st = new BSTPlus<String, Integer>();
    
    // Elementos da interface
    @FXML
    private TextField entryField;

    @FXML
    private TextField nodeEntry;

    @FXML
    private ListView<String> entryList;

    @FXML
    private ListView<String> outList;

    @FXML
    private Button fileButton;

    @FXML
    private Button findButton;
    
    @FXML
    private Button inButton;

    @FXML
    private Button preButton;

    @FXML
    private Button posButton;

    @FXML
    private Label labelHeight;

    @FXML
    private Label labelInternalPath;

    @FXML
    private Label labelNNodes;

    @FXML
    private Label labelValue;

    @FXML
    private Label labelDepth;

    // Metodos de controle da interface
    @FXML // Método que roda assim que a interface é iniciada
    void initialize() {
        // Desabilita os botões
        findButton.setDisable(true);
        nodeEntry.setDisable(true);
        inButton.setDisable(true);
        preButton.setDisable(true);
        posButton.setDisable(true);

        // Criar um listener para obsercar o campo de texto do procurar Node.
        // Quando o texto é atualizado a cor de fundo da campo é mudado pra branco
        nodeEntry.textProperty().addListener((observable, oldValue, newValue) -> {
            nodeEntry.setStyle("-fx-control-inner-background: #FFFFFF;");
        });

    }

    @FXML // Método que importa o arquivo selecionado
    void fileEntry(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        fileChooser.setTitle("Abrir arquivo");
        File filename = fileChooser.showOpenDialog(gui.primaryStage);

        entryField.clear();
        entryList.getItems().clear();
        String[] nameList = BSTPlus.readWords(filename.getAbsolutePath());
        for(int i = 0; i < nameList.length; i++){
            entryList.getItems().add(nameList[i]);
        }
    }

    @FXML // metodo que adiciona o nome digitado no campo manualmente
    void nameEntry(ActionEvent event) {
        String name = entryField.getText();
        entryField.clear();
        entryList.getItems().add(name);
    }

    @FXML // Metodo que exclui o nome selecionado
    void deleteSelected(ActionEvent event) {
        entryList.getItems().remove(entryList.getSelectionModel().getSelectedItem());
    }

    @FXML // Metodo que limpa a lista de nomes da entrada
    void clear(ActionEvent event) {
        entryList.getItems().clear();
    }

    @FXML //Metodo reponsavel para mostrar a altura, comprimento e numero de nos da arvore binaria
    void generateTree(){  
        for (String s : st.keys()) {
            st.delete(s);
        }
        outList.getItems().clear();
        
        ArrayList<String> nameList = new ArrayList<>(entryList.getItems());

        if(nameList.size() > 0){
            for(int i = 0; i < nameList.size(); i++){
                st.put(nameList.get(i), i);
            }
            labelHeight.setText("Altura: " + st.height());
            labelInternalPath.setText("Comprimento Interno: " + st.internalPathLength());
            labelNNodes.setText("Número de nós: " + st.size());
        }

        // Habilita os botões
        findButton.setDisable(false);
        nodeEntry.setDisable(false);
        inButton.setDisable(false);
        preButton.setDisable(false);
        posButton.setDisable(false);
    }

    //TRAVESSIAS

    @FXML //Em ordem: esquerda-raiz-direita
    void inOrder(){ 
        outList.getItems().clear();
        ArrayList<String> nameList = new ArrayList<>(st.inOrder());
        for(int i = 0; i < nameList.size(); i++){
            outList.getItems().add(nameList.get(i));
        }    
    }

    @FXML //Pre-ordem: raiz-esquerda-direita
    void preOrder(){
        outList.getItems().clear();
        ArrayList<String> nameList = new ArrayList<>(st.preOrder());
        for(int i = 0; i < nameList.size(); i++){
            outList.getItems().add(nameList.get(i));
        }    
    }

    @FXML //Pos-ordem: esquerda-direita-raiz
    void posOrder(){ 
        outList.getItems().clear();
        ArrayList<String> nameList = new ArrayList<>(st.posOrder());
        for(int i = 0; i < nameList.size(); i++){
            outList.getItems().add(nameList.get(i));
        }    
    }
    @FXML //Metodo reposnsavel por procurar um valor e a profundidade de um no
    void findNode(){ 
        String name = nodeEntry.getText();
        try {
            labelValue.setText("Valor: " + st.getValue(name));
            labelDepth.setText("Profundidade: " + st.getDepth(name));
            nodeEntry.setStyle("-fx-control-inner-background: #619e7e;");
        } catch (Exception e) {
            nodeEntry.setStyle("-fx-control-inner-background: #f28482;");

            labelValue.setText("Valor: ");
            labelDepth.setText("Profundidade: ");
        }
    }
}
