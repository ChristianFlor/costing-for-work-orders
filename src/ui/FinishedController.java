package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class FinishedController {
	
	private MainController mainController;

    @FXML
    private ImageView foundCompImg;

    @FXML
    private TextField MDBill;

    @FXML
    private TextField CIFAPBill;

    @FXML
    private TextField CIFBill;

    @FXML
    private TextField MODBill;

    @FXML
    private DatePicker fechaFinBill;

    @FXML
    void bill(ActionEvent event) {
    	mainController.finishOrder();
    	//closeButtonAction();
    	
    }
   /* 
    @FXML private javafx.scene.control.Button closeButton;

    @FXML
    private void closeButtonAction(){
        // get a handle to the stage
        Stage stage = (Stage) closeButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }*/
    
    public void setMainController(MainController main) {
    	mainController = main;
    }
    
    public double getMDBill() {
    	return Double.parseDouble(MDBill.getText());
    }
    
    public double getCIFAPBill() {
    	return Double.parseDouble(CIFAPBill.getText());
    }
    
    public double getCIFBill() {
    	return Double.parseDouble(CIFBill.getText());
    }
    
    public double getMODBill() {
    	return Double.parseDouble(MODBill.getText());
    }
    
    public DatePicker getFechaFinBill() {
    	return fechaFinBill;
    }
}
