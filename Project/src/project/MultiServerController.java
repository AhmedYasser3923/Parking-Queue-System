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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import static project.MultiServer.c;
import static project.MultiServer.Simulation_length;


public class MultiServerController implements Initializable {
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

// Start simulation
    @FXML
    private Label err;
    @FXML
    private TextField Simlength;
    @FXML
    private Button start1;
    
 @FXML
 private TextArea MultiArea_table;
    
    public void Start_Simulation(ActionEvent event) throws IOException {
        try {
            Simulation_length = Integer.parseInt(Simlength.getText());
            MultiServer.Simulate();
  MultiArea_table.setText( MultiServer.print_Simulation_Table());
           
    Statistics();
        } catch (NumberFormatException ex) {
            err.setText(" * Please, Enter only numbers");
        
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    @FXML
     private TextField able_utilization_textfield;
    @FXML
     private TextField baker_utilization_textfield;
     @FXML
     private TextField nitroG_utilization_textfield;
    @FXML
    private TextField served_Able_textfield;
    @FXML
    private TextField served_Baker_textfield;
    @FXML
    private TextField served_NitroG_textfield;
    @FXML
    private TextField AbleAverageST_textfield;
    @FXML
    private TextField BakerAverageST_textfield;
    @FXML
    private TextField NitroGAverageST_textfield;
    @FXML
    private TextField AvgWaitingTimeAll_textfield;
    @FXML
    private TextField AvgWaitingTimeCust_textfield;
    @FXML
    private TextField Avg_IAT;
    
   public  void Statistics(){
    double  total_Able_servicetime = 0.0;
    double total_Baker_servicetime = 0.0;
    double total_NitroG_servicetime = 0.0;
    double Able_count = 0.0;
    double Baker_count = 0.0;
    double NitroG_count = 0.0;
    double Waiting_count = 0.0;
    double Max_Able_serviceEnd = 0.0; // simulation Time Able
    double Max_Baker_serviceEnd = 0.0; // simulation Time Baker
    double Max_NitroG_serviceEnd = 0.0; // simulation Time NitroG
    double Total_WaitingTime = 0.0;
     double Total_IAT = 0.0;
    for(int i = 0; i < Simulation_length; i++){ 
    total_Able_servicetime += c[i].getServiceTime_Able() ; 
    total_Baker_servicetime +=c[i].getServiceTime_Baker();
    total_NitroG_servicetime += c[i].getServiceTime_NitroG();
    Total_WaitingTime += c[i].getWaitingTime();
    Total_IAT += c[i].getIAT();
      if(c[i].getWaitingTime() != 0){
    Waiting_count++;
    }
    if (c[i].getServiceTime_Able() != 0 ){
    Able_count++;
    if(c[i].getServiceEnd_Able() > Max_Able_serviceEnd){
    Max_Able_serviceEnd = c[i].getServiceEnd_Able();
    }
    }
    else if (c[i].getServiceTime_Baker() != 0){
    Baker_count++;
      if(c[i].getServiceEnd_Baker()> Max_Baker_serviceEnd){
    Max_Baker_serviceEnd = c[i].getServiceEnd_Baker();
    }
    }
    else {
    NitroG_count++;
      if(c[i].getServiceEnd_NitroG()> Max_NitroG_serviceEnd){
    Max_NitroG_serviceEnd = c[i].getServiceEnd_NitroG();
    }
    }
    }

    double able_utilization = (  total_Able_servicetime / Max_Able_serviceEnd);

   able_utilization_textfield.setText( able_utilization +" %" );
    
    
    double baker_utilization = (  total_Baker_servicetime / Max_Baker_serviceEnd);
    baker_utilization_textfield.setText( baker_utilization + " %");
    
    double nitroG_utilization = (  total_NitroG_servicetime / Max_NitroG_serviceEnd);
    
    nitroG_utilization_textfield.setText( nitroG_utilization + " %");
  
     served_Able_textfield.setText(((Able_count / Simulation_length) *100) + " %");
     served_Baker_textfield.setText(((Baker_count / Simulation_length) *100) + " %");
     served_NitroG_textfield.setText(((NitroG_count/ Simulation_length) *100) + " %");
    
     AbleAverageST_textfield.setText(((total_Able_servicetime / Simulation_length) *100) + " min");
     BakerAverageST_textfield.setText(((total_Baker_servicetime / Simulation_length) *100) + " min");
     NitroGAverageST_textfield.setText(((total_NitroG_servicetime / Simulation_length) *100) + " min");
    AvgWaitingTimeAll_textfield.setText((Total_WaitingTime / Simulation_length) + " min");
    AvgWaitingTimeCust_textfield.setText((Total_WaitingTime / Waiting_count) + " min" );
    Avg_IAT.setText((Total_IAT / Simulation_length) + " min");
    }
 
   
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {

}
}


