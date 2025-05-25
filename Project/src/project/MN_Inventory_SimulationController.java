
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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static project.MN_Inventory_Simulation.Cycle;
import static project.MN_Inventory_Simulation.Days_work;
import static project.MN_Inventory_Simulation.InventoryStart;
import static project.MN_Inventory_Simulation.OrderQuantity;
import static project.MN_Inventory_Simulation.condition;
import static project.MN_Inventory_Simulation.inv;
public class MN_Inventory_SimulationController implements Initializable {
// Switch to HOME 

    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;
// Switch to HOME 
    public void Switch_to_Home(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
     @FXML
    private Label err;
     @FXML
    private TextField inv_start;
     @FXML
    private TextField cycle;
     @FXML
    private TextField order;
     @FXML
    private TextField Condition;
     @FXML
    private TextField days_work;
     @FXML
     private TextArea MN_Area;
    // Start Simulation
    public void Start_Simulation(ActionEvent event) throws IOException {
        try {
            InventoryStart = Integer.parseInt(inv_start.getText());
            Cycle = Integer.parseInt(cycle.getText());
           OrderQuantity = Integer.parseInt(order.getText());
           Days_work = Integer.parseInt(days_work.getText());
           condition = Integer.parseInt(Condition.getText());
           MN_Inventory_Simulation.Simulate();
           MN_Area.setText(MN_Inventory_Simulation.PrintSimulation1());
           Calculate_Total_Avg_Ending_Inventory();
        } catch (NumberFormatException ex) {
            err.setText(" * Please, Enter only numbers");
        
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    //Statistics
    @FXML
    private TextField Total_ending;
    @FXML
    private TextField AVG_ending;
    public void Calculate_Total_Avg_Ending_Inventory(){
int total = 0; double avg = 0.0;
for(int e = 0; e < Cycle * Days_work; e++){
total += inv[e].InventoryEnding;
}
    Total_ending.setText( total + "   ");
    avg = total / (Cycle * Days_work);
    AVG_ending.setText(avg + "  ");
}
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
