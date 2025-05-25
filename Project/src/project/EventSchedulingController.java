
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static project.EventScheduling.fe;
import static project.EventScheduling.custn;


public class EventSchedulingController implements Initializable {
// Switch to Home
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
    private TextField Custn_field;
    @FXML
    private TextField cond_F;
    
 @FXML
 private TextArea event_Area;
    
    public void Start_Simulation(ActionEvent event) throws IOException {
        try {
          EventScheduling.custn = Integer.parseInt(Custn_field.getText());
          EventScheduling.F = Integer.parseInt(cond_F.getText());
          EventScheduling.Simulate();
              EventScheduling.calc_fel();
        EventScheduling.calc_fel_last();
          event_Area.setText(EventScheduling.Print_Event_Scheduling_Table());
          Statistics();
        } catch (NumberFormatException ex) {
            err.setText(" * Please, Enter only numbers");
        
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    //Statistics
    @FXML
    private TextField avg_response;
    @FXML
    private TextField proportion;
    public void Statistics(){
        double x = fe[(custn * 2) - 1].f , y = fe[(custn * 2) - 1].n ,  z = fe[(custn * 2) - 1].s;
        double avg_respo = (z / y);
    double pro_f = (x / y );
    avg_response.setText(avg_respo + " mins");
    proportion.setText(pro_f + " %");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
