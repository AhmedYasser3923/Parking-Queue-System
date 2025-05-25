 package project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXMLDocumentController implements Initializable {
    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;
    // Switch to Multi-Server 
    public void Switch_to_MultiServer(ActionEvent event) throws IOException{
    root = FXMLLoader.load(getClass().getResource("MultiServer.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root,1500,777);
    stage.setScene(scene);
    stage.show();
    }
    // Switch to Classical Inventory Simulation 
    public void Switch_to_Classical_Inventory(ActionEvent event) throws IOException{
    root = FXMLLoader.load(getClass().getResource("ClassicalInventory.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root,1500,777);
    stage.setScene(scene);
    stage.show();
    }
    // Switch to (M,N) Inventory Simulation 
    public void Switch_to_MN_Inventory(ActionEvent event) throws IOException{
    root = FXMLLoader.load(getClass().getResource("MN_Inventory_Simulation.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root,1500,777);
    stage.setScene(scene);
    stage.show();
    }
    // Switch to Event Scheduling
    public void Switch_to_EventScheduling(ActionEvent event) throws IOException{
    root = FXMLLoader.load(getClass().getResource("EventScheduling.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root,1500,777);
    stage.setScene(scene);
    stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
