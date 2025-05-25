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
import static project.Classical_Inventory.Days;
import static project.Classical_Inventory.priceBuy;
import static project.Classical_Inventory.priceLostProfit;
import static project.Classical_Inventory.priceSell;
import static project.Classical_Inventory.number_of_purchase_tickets;
import static project.Classical_Inventory.priceScrap;
import static project.Classical_Inventory.t;

public class ClassicalInventoryController implements Initializable {
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
    
    //Start Simulation
    @FXML 
    private TextField sim_days;
    @FXML 
    private TextField buy;
    @FXML 
    private TextField scrap;
    @FXML 
    private TextField purchase;
    @FXML 
    private TextField sell;
    @FXML 
    private TextArea classicArea;
    @FXML 
    private Label err;
   
    //Start Simulation
    public void Start_Simulation(ActionEvent event) throws IOException{
     try {
          Days = Integer.parseInt(sim_days.getText());  
          number_of_purchase_tickets = Double.parseDouble(purchase.getText());  
          priceBuy = Double.parseDouble(buy.getText());  
          priceSell = Double.parseDouble(sell.getText());  
          priceLostProfit = (priceSell - priceBuy);
          priceScrap = Double.parseDouble(scrap.getText());  
      Classical_Inventory.Simulate();
      classicArea.setText(Classical_Inventory.PrintSimulation1());
 Statistics();
        } catch (NumberFormatException ex) {
            err.setText(" * Please, Enter only numbers");
        
        } catch (Exception ex) {
            System.out.println(ex);
        }
    } 
   // Statistics
     @FXML 
    private TextField TotalRevnue;
     @FXML 
    private TextField TotalLostProfit;
     @FXML 
    private TextField TotalScrap;
     @FXML 
    private TextField TotalDailyProfit;
    public  void Statistics(){
double total_Revenue = 0;
double total_LostProfit = 0;
double total_Scrap = 0;
double total_DailyProfit = 0;
for(int i = 0 ; i < Days; i++){
total_Revenue += t[i].RevenueSale;
total_LostProfit += t[i].LostProfit_ForExcess_Demand;
total_Scrap += t[i].Salvage_FromSale_Scrap;
total_DailyProfit += t[i].DailyProfit;
}
     TotalRevnue.setText( total_Revenue+" $");
     TotalLostProfit.setText(total_LostProfit+" $");
     TotalScrap.setText( total_Scrap+" $");
     TotalDailyProfit.setText( total_DailyProfit+" $");
}
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
